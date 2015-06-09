package com.ncs.gsyt.modules.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.json.util.JSONObject;
import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.core.util.JSONMessage;
import com.ncs.gsyt.modules.model.Area;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.ZTreeObject;
import com.ncs.gsyt.modules.service.AreaService;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.RoleService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.util.MD5;
import com.ncs.gsyt.modules.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class UserAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;

	

	@Resource
	private RoleService roleService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private AreaService areaService;
	
	

	private User user = new User();

	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public User getModel() {
		return user;
	}

	/**
	 * hanjun
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getUserList_pass() throws Exception {
		Search search = new Search(User.class);
		search = this.getSearch(search);
		if (user.getUserName() != null && !"".equals(user.getUserName())) {
			search.addFilterILike("userName", "%" + user.getUserName() + "%");
		}
		if (user.getUserCode() != null && !"".equals(user.getUserCode())) {
			search.addFilterEqual("userCode", user.getUserCode());
		}

		int count = userService.count(search);
		List<User> list = userService.searchAll(search);
		List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				User user = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				
				
				String roleName = "";
				if (null != user.getRole()) {
					roleName = user.getRole().getRolename();
				}
				row.put("id", user.getUserID());
				row.put("cell",
						new Object[] { user.getUserID(), user.getUserCode(),
								user.getUserName(),
								user.getPhone(), roleName, null!=user.getEnterprise()?user.getEnterprise().getEnterpriseName():"",
										null!=user.getArea()?user.getArea().getAreaName():"", user.getEnable()});
				userList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, userList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}

	@Action(value = "/userNamage", results = {
			@Result(name = SUCCESS, location = "/admin/user/userlist.jsp"),
			@Result(name = "userForm", location = "/admin/user/useredit.jsp"),
			@Result(name = "changePwd", location = "/admin/user/changepwd.jsp"),
			@Result(name = "showRole", location = "/admin/user/showroles.jsp"),
			@Result(name = "setDept", location = "/admin/user/setDept.jsp")

	})
	@Override
	public String execute() {

		return SUCCESS;
	}

	/*@Action(value = "/getAreaTree")
	public String getAreaTree() {
		Search search = new Search();
		List<Area> areas = areaService.searchAll(search);
		List<Map<String, Object>> areaList = new ArrayList<Map<String, Object>>();
		if (null != areas) {
			for (int i = 0; i < areas.size(); i++) {
				Area area = areas.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", area.getAreaID());
				row.put("pId", area.getParentID());
				row.put("name", area.getAreaName());
				areaList.add(row);
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", areaList);
		JSONObject json = new JSONObject(result);
		try {
			httpServletResponse.getWriter().write(json.toString());
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*
	 * public String addUser() { User user1 = new User(); user1 = user; MD5 md5
	 * = new MD5();
	 * user1.setUserPassword(md5.getMD5ofStr(user.getUserPassword()));
	 * user1.setEnable("启用"); userService.save(user1); return SUCCESS; }
	 */
	

	public String addOrUpdate() {
		MD5 md5 = new MD5();
		if (!isUpdate()) {//新增
			user.setEnable("启用");
			user.setUserPassword(md5.getMD5ofStr(user.getUserPassword()));
		} else {//修改
			User olduser = userService.findById(user.getUserID());
			user.setEnable(olduser.getEnable());
			if (!"*****".equals(user.getUserPassword())) {//判断密码是否修改过
				user.setUserPassword(md5.getMD5ofStr(user.getUserPassword()));
			} else {
				user.setUserPassword(olduser.getUserPassword());
			}
			user.setRole(olduser.getRole());
		}
		
		userService.save(user);

		return SUCCESS;
	}

	/**
	 * 初始化新增修改
	 * 
	 * @return
	 */
	public String initAddOrUpdate() throws Exception {
		if (isUpdate()) {
			user = userService.findById(user.getUserID());
			user.setUserPassword("*****");
			
		} else {
			user = new User();
		}

		return "userForm";
	}

	/**
	 * 是否更新
	 * 
	 * @return
	 */
	private boolean isUpdate() {
		if (user == null)
			return false;
		if (user.getUserID() <= 0)
			return false;
		return true;
	}

	/**
	 * 判断用户登录账号是否唯一
	 * 
	 * @return
	 * @throws Exception
	 */
	public String checkUserCode() throws Exception {
		String msg = "";
		try {
			String userCode = StringUtil.isNull(httpServletRequest
					.getParameter("userCode"));
			String oldUserCode = StringUtil.isNull(httpServletRequest
					.getParameter("ouc"));
			if (userCode.equals(oldUserCode)) {
				msg = "noUse";
			} else {
				Search search = new Search();
				search.addFilterEqual("userCode", userCode);
				User user = userService.searchUnique(search);
				if (null != user) {
					msg = "exist";
				} else {
					msg = "noUse";
				}
			}
		} catch (Exception e) {
			msg = "err";
		}
		sendMessages(httpServletResponse, msg);

		return null;
	}

	/**
	 * 更新用户状态
	 * 
	 * @return
	 */
	public String updateStatus() {
		String status = "启用";
		if ("0".equals(user.getEnable())) {
			status = "禁用";
		} else {
			status = "启用";
		}
		String hql = "update User user set user.enable = '" + status
				+ "' where user.id in (" + ids + ")";
		userService.updateStatus(hql);
		return null;
	}
	
	/**
	 * 根据ID获取用户信息
	 * */
	public String getUserByID() {
		try {
			String userid = StringUtil.isNull(httpServletRequest
					.getParameter("userid"));
			User user = userService.findById(Integer.parseInt(userid));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", user.getUserID());
			jsonObject.put("userName", user.getUserName());
			jsonObject.put("userCode", user.getUserCode());
			jsonObject.put("password", "*****");
			jsonObject.put("phone", user.getPhone());
			httpServletResponse.getWriter().write(jsonObject.toString());
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 跳转配置角色页面
	 * 
	 * @return
	 */
	public String configRoles() {
		String cksids = "";
		user = userService.findById(user.getUserID());
		Search search = new Search();
		List<Role> roles = roleService.searchAll(search);
		Role checkedRole = user.getRole();
		for (Role role : roles) {
			if (checkedRole != null && checkedRole.getRoleid()==role.getRoleid())
				cksids += "row" + role.getRoleid() + ",";
		}
		httpServletRequest.setAttribute("cksids", cksids);
		return "showRole";
	}

	/**
	 * 保存角色
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configRolesubmit() throws Exception {
		String ids = httpServletRequest.getParameter("ids");
		
		user = userService.findById(user.getUserID());

		boolean rlt = userService.saveConfigs(user, ids);
		JSONMessage json = new JSONMessage();
		if (rlt) {
			json.setFlag(JSONMessage.Flag.SUCCESS);
			json.setMsg("保存成功");
		} else {
			json.setFlag(JSONMessage.Flag.SUCCESS);
			json.setMsg("保存成功");
		}

		return sendMessages(httpServletResponse, json.toString());
	}
	
	/**
	 * 跳转到配置部门页面
	 * */
	public String configDept() {
		httpServletRequest.setAttribute("ids", ids);
		return "setDept";
	}
	
	public String getDept_pass() throws Exception{
		Search search = new Search();
		
		List<Area> depts = areaService.searchAll(search);
		List<ZTreeObject> nList = new ArrayList<ZTreeObject>();
		
		
		if (null != depts) {
			for (int i = 0; i < depts.size(); i++) {
				Area dept = depts.get(i);
				ZTreeObject node = new ZTreeObject();
				node.setId(dept.getAreaID()+"");
				node.setPid(dept.getParentID()+"");
				node.setName(dept.getAreaName());
				node.setOpen(true);
				nList.add(node);
			}
		}
		JSON json = JSONSerializer.toJSON(nList);
		return sendMessages(httpServletResponse, json.toString());
	}
	
	/**
	 * 提交用户对应的部门
	 * */
	public String configSubmit() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		String node = StringUtil.isNull(httpServletRequest
				.getParameter("node"));
		String[] idArr = ids.split(",");
		Area dept = areaService.findById(Long.parseLong(node));
		for (String userid : idArr) {
			User u = userService.findById(Long.parseLong(userid));
			u.setArea(dept);
			userService.save(u);
		}
		result.put("stat", "1");
		result.put("msg", "设置成功");
		JSONObject json = new JSONObject(result);
		out.print(json.toString());

		out.flush();
		out.close();
		return null;
	}

	/**
	 * 加载角色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configRoles_pass() throws Exception {
		user = userService.findById(user.getUserID());
		Search search = new Search();
		List<Role> roles = roleService.searchAll(search);

		List<Map<String, Object>> rolelist = new ArrayList<Map<String, Object>>();

		if (null != roles) {
			for (Role role : roles) {
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", role.getRoleid());
				row.put("cell",
						new Object[] { role.getRoleid(), role.getRolename(),
								role.getRoledesc() });
				rolelist.add(row);
			}

		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", 1);
		result.put("total", roles.size());
		result.put("rows", rolelist);
		JSONObject json = new JSONObject(result);

		return sendMessages(httpServletResponse, json.toString());
	}

	/**
	 * 初始化修改密码数据
	 * 
	 * @return action result
	 */
	public String initChangePwd_pass() {
		user = (User) session.get(Constant.USER_SESSION_KEY);
		return "changePwd";
	}

	/**
	 * 修改密码
	 * 
	 * @return action result
	 * @throws Exception
	 */
	public String changePwd_pass() throws Exception {

		String oldPwd = httpServletRequest.getParameter("oldPwd");
		String message = ERROR;

		//Search search = new Search(User.class);
		//search = this.getSearch(search);

		User sessionUser = (User) session.get(Constant.USER_SESSION_KEY);
		MD5 md5 = new MD5();

		//search.addFilterEqual("userCode", sessionUser.getUserCode());

		User userEntity = userService.findById(sessionUser.getUserID());

		if (null != userEntity) {

			if (md5.getMD5ofStr(oldPwd).equals(userEntity.getUserPassword())) {

				userEntity.setUserPassword(md5.getMD5ofStr(user
						.getUserPassword()));

				userService.save(userEntity);

				message = SUCCESS;
			} else {
				message = "oldPwdError";
			}
		} else {
			message = "entityNull";
		}

		sendMessages(httpServletResponse, message);

		return null;
	}

	/**
	 * 验证原密码是否合法
	 * 
	 * @return action result.
	 * @throws Exception
	 */
	public String checkOldPwd_pass() throws Exception {

		String oldPwd = httpServletRequest.getParameter("oldPwd");
		String message = ERROR;

		Search search = new Search(User.class);
		search = this.getSearch(search);

		User sessionUser = (User) session.get(Constant.USER_SESSION_KEY);
		MD5 md5 = new MD5();

		search.addFilterEqual("userName", sessionUser.getUserName());

		User userEntity = userService.searchUnique(search);

		if (null != userEntity
				&& md5.getMD5ofStr(oldPwd).equals(userEntity.getUserPassword())) {
			message = SUCCESS;
		}

		sendMessages(httpServletResponse, message);

		return null;
	}

	public User getUser() {
		return user;
	}

	/**
	 * 获取企业供页面显示列表
	 * */
	public String getEnterpriseList() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		try {
			String ids = StringUtil.isNull(httpServletRequest.getParameter("ids"));
			Search s = new Search(Enterprise.class);
			//s.addFilterEqual("", );
			List<Enterprise> enterpriselist = enterpriseService.searchAll(s);
			String msg = "<table cellspacing='0' cellpadding='0' border='0' width='100%' class='tab2'>" +
			"<tr><td align='center' valign='top'><div>选择企业：</div>"+
			"<div id='enterprisediv'><input type='hidden' name='ids' id='ids' value='" + ids + "' />";
			for (Enterprise e : enterpriselist) {
				msg += "<input type='radio' name='enterprisecheck' value='" + e.getEnterpriseID() + "'>"
				+ e.getEnterpriseName() + "<br/>";
			}
			msg += "</div></td></tr></table>";

			result.put("stat", "1");
			result.put("msg", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject(result);

		out.print(json.toString());

		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 设置用户所属的企业
	 * */
	public String setEnterprise() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		try {
			String ids = StringUtil.isNull(httpServletRequest.getParameter("ids"));
			String enterpriseID = StringUtil.isNull(httpServletRequest.getParameter("para1"));
			boolean r = userService.saveUserEnterprise(ids, enterpriseID);
			if (r) {
				result.put("stat", "1");
				result.put("msg", "设置完成");
			} else {
				result.put("stat", "0");
				result.put("msg", "设置失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject(result);
		out.print(json.toString());

		out.flush();
		out.close();
		return null;
	}
}
