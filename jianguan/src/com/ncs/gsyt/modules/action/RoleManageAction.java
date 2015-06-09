package com.ncs.gsyt.modules.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.core.util.JSONMessage;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.service.MenuService;
import com.ncs.gsyt.modules.service.RoleService;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Action(value = "/roleNamage", results = {
		@Result(name = "success", location = "/admin/role/rolelist.jsp"),
		@Result(name = "form", location = "/admin/role/roleedit.jsp"),
		@Result(name = "showahor", location = "/admin/role/ahorconfig.jsp"),
		@Result(name = "showDept", location = "/admin/role/deptconfig.jsp")})
@Controller
public class RoleManageAction extends BaseAction implements ModelDriven<Role> {

	private static final long serialVersionUID = 1L;

	private Role role = new Role();
	
	private String ids;
	
	public String getIds() {
		return ids;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	@Resource
	private RoleService roleService;

	@Resource
	private MenuService menuService;
	

	@Override
	public String execute() {

		return SUCCESS;
	}

	/**
	 * 初始化新增
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initAdd() throws Exception {
		return "form";
	}

	/**
	 * 初始化修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initUpdate() throws Exception {
		role = roleService.findRoleById(role.getRoleid());
		return "form";
	}

	public String submit_pass() throws Exception {
		roleService.save(role);
		return SUCCESS;
	}

	/**
	 * 配置角色权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configAhor() throws Exception {
		role = roleService.findRoleById(role.getRoleid());
		return "showahor";
	}
	
	/**
	 * 配置角色管理范围
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configDept() throws Exception {
		role = roleService.findRoleById(role.getRoleid());
		return "showDept";
	}

	/**
	 * 查看角色权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configAhor_pass() throws Exception {
		String contexPath = httpServletRequest.getContextPath();
		role = roleService.findRoleById(role.getRoleid());
		JSON json = menuService.findMenuTreeAhor(contexPath, role);
		return sendMessages(httpServletResponse, json.toString());
	}
	
	

	/**
	 * 
	 * 提交角色权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String configAhorsubmit() throws Exception {
		try {
			Map parameterMap = httpServletRequest.getParameterMap();
			String roleid[] = (String[]) parameterMap.get("roleid");
			String nodecodes[] = (String[]) parameterMap.get("nodeCodes[]");
			role = roleService.findRoleById(Integer.parseInt(roleid[0]));
			role.setNodeCodes(nodecodes);
			boolean rlt = roleService.saveConfigs(role);
			JSONMessage json = new JSONMessage();
			if (rlt) {
				json.setFlag(JSONMessage.Flag.SUCCESS);
				json.setMsg("保存成功");
			} else {
				json.setFlag(JSONMessage.Flag.SUCCESS);
				json.setMsg("保存成功");
			}

			return sendMessages(httpServletResponse, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	
	
	/**
	 * 更新用户状态
	 * 
	 * @return
	 */
	public String updateStatus() {
		String status = "启用";
		if ("0".equals(role.getRolestatus())) {
			status = "禁用";
		} else {
			status = "启用";
		}
		String hql = "update Role role set role.rolestatus = '" + status
				+ "' where role.roleid in (" + ids + ")";
		roleService.updateStatus(hql);
		return null;
	}


	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {

		return SUCCESS;
	}

	/**
	 * 加载列表数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getList_pass() throws Exception {
		Search search = new Search(Role.class);
		search = this.getSearch(search);
		if (role.getRolename() != null && !"".equals(role.getRolename())) {
			search.addFilterILike("rolename", "%" + role.getRolename() + "%");
		}
		if (null != role.getRolestatus() && !"".equals(role.getRolestatus())) {
			search.addFilterEqual("rolestatus", role.getRolestatus());
		}

		int count = roleService.count(search);
		List<Role> list = roleService.searchAll(search);
		List<Map<String, Object>> roleList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Role r = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", r.getRoleid());
				row.put("cell", new Object[] { r.getRoleid(), r.getRolename(),
						r.getRoledesc(), r.getRolestatus() });
				roleList.add(row);
			}
		}

		com.json.util.JSONObject json = resultTOJson(search, count, roleList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}

	@Override
	public Role getModel() {
		return role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
