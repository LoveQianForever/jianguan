package com.ncs.gsyt.modules.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.json.util.JSONObject;
import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Enterpriseatta;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.EnterpriseattaService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.util.ImageUtil;
import com.ncs.gsyt.modules.util.UUIDGenerator;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class EnterpriseAction extends BaseAction implements ModelDriven<Enterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private EnterpriseattaService enterpriseattaService;
	
	@Resource
	private UserService userService;
	
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	private Enterprise enterprise = new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}
	
	@Override
	public Enterprise getModel() {
		return enterprise;
	}
	// 附件处理
	private File uploadify;
	private String uploadifyFileName;

	public File getUploadify() {
		return uploadify;
	}

	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}
	
	public String getUploadifyFileName() {
		return uploadifyFileName;
	}

	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}

	@Action(value = "/enterprise", results = {
			@Result(name = SUCCESS, location = "/admin/enterprise/enterpriselist.jsp"),
			@Result(name = "form", location = "/admin/enterprise/enterpriseedit.jsp"),
			@Result(name = "form1", location = "/admin/enterprise/setpic.jsp")
			//@Result(name = SUCCESS, location = "/admin/enterprise/seedEnterpriseedit.jsp")//种子经营者企业 信息展示
	})
	
	@Override
	public String execute() {
		

		HttpSession session=httpServletRequest.getSession(true);
		
		user=(User)session.getAttribute("ADMIN_USER");
		return SUCCESS;
	}
	/**
	 * 初始化增加
	 * @return
	 * @throws Exception
	 */
	private boolean isUpdate() {
		
		if (enterprise == null)
			return false;
		if (enterprise.getEnterpriseID() <= 0)
			return false;
		return true;
	}
	
	public String initAddOrUpdate() throws Exception {
		if (isUpdate()){
			enterprise=enterpriseService.findById(enterprise.getEnterpriseID());
		}else{
			enterprise = new Enterprise();
		}
		return "form";
	}//addOrUpdate
	public String addOrUpdate() throws Exception {
		enterpriseService.save(enterprise);
		return this.execute();
	}
	/**
	 * 设置图片
	 * 
	 * @return
	 */
	public String setpic() throws Exception{
		enterprise = enterpriseService.findById(enterprise.getEnterpriseID());
		String attaStr = "";
		if (null != enterprise.getAttalist() && enterprise.getAttalist().size() > 0) {
			for (Enterpriseatta atta : enterprise.getAttalist()) {
				attaStr += "<div id=\"atta" + atta.getAnnexID() + "\" style=\"width:120px; float:right;\"><a href=\"#\" class=\"track\" ><img src=\"" 
					+ atta.getResizeFile() + "\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='deletepic("
					+ atta.getAnnexID() + ")'>删除</a><p class=\"Product-Name\">"+ atta.getAnnexName() +"</p>";
				attaStr += "<br/><p class=\"Product-Name\">附件类型：" + atta.getAnnexType() + "</p>";
				if ("质量认证".equals(atta.getAnnexType())) {
					attaStr += "<br/><p class=\"Product-Name\">名称：" + atta.getZhiliang1() + "</p>";
					attaStr += "<br/><p class=\"Product-Name\">认证编号：" + atta.getZhiliang2() + "</p>";
					attaStr += "<br/><p class=\"Product-Name\">认证机构：" + atta.getZhiliang3() + "</p>";
					attaStr += "<br/><p class=\"Product-Name\">认证时间：" + atta.getZhiliang4() + "</p>";
				}
				if ("商标注册".equals(atta.getAnnexType())) {
					attaStr += "<br/><p class=\"Product-Name\">名称：" + atta.getShangbiao1() + "</p>";
				}
				if ("荣誉证书".equals(atta.getAnnexType())) {
					attaStr += "<br/><p class=\"Product-Name\">证书名称：" + atta.getZhengshu1() + "</p>";
					attaStr += "<br/><p class=\"Product-Name\">获证时间：" + atta.getZhengshu2() + "</p>";
				}
				if ("包装信息".equals(atta.getAnnexType())) {
					attaStr += "<br/><p class=\"Product-Name\">包装名称：" + atta.getBaozhuang1() + "</p>";
					attaStr += "<br/><p class=\"Product-Name\">包装材料：" + atta.getBaozhuang2() + "</p>";
				}
				attaStr += "</div>";
			}
		}
		enterprise.setAttachStr(attaStr);
		return "form1";
	}
	/**
	 * 保存图片
	 * */
	
	public String savepic() throws Exception{
		enterprise = enterpriseService.findById(enterprise.getEnterpriseID());
		String filePath = Constant.EXAPREPORT_STOR_PATH;
		PrintWriter out = null;
		String annexType = httpServletRequest.getParameter("annexType");
		try {
			out = httpServletResponse.getWriter();
			File path = new File(filePath);
			if (!path.exists()) {
				path.mkdirs();
			}
			String prefix=uploadifyFileName.substring(uploadifyFileName.lastIndexOf("."));
			String filename = UUIDGenerator.getUUID() + prefix;
			String resizefilename = UUIDGenerator.getUUID() + prefix;
			String filePath1 = filePath + File.separator + filename;
			FileUtils.copyFile(uploadify, new File(filePath1));
			String resizefile = filePath + File.separator + resizefilename;
			ImageUtil.saveImageAsJpg(filePath1, resizefile, 100, 100);
			Enterpriseatta atta = new Enterpriseatta();
			atta.setAnnexType(annexType);
			if ("质量认证".equals(annexType)) {
				atta.setZhiliang1(httpServletRequest.getParameter("zhiliang1"));
				atta.setZhiliang2(httpServletRequest.getParameter("zhiliang2"));
				atta.setZhiliang3(httpServletRequest.getParameter("zhiliang3"));
				atta.setZhiliang4(httpServletRequest.getParameter("zhiliang4"));
			}
			if ("商标注册".equals(annexType)) {
				atta.setShangbiao1(httpServletRequest.getParameter("shangbiao1"));
			}
			if ("荣誉证书".equals(annexType)) {
				atta.setZhengshu1(httpServletRequest.getParameter("zhengshu1"));
				atta.setZhengshu2(httpServletRequest.getParameter("zhengshu2"));
			}
			if ("包装信息".equals(annexType)) {
				atta.setBaozhuang1(httpServletRequest.getParameter("baozhuang1"));
				atta.setBaozhuang2(httpServletRequest.getParameter("baozhuang2"));
			}
			atta.setAnnexName(uploadifyFileName);
			atta.setAttaFile(Constant.CONVERT_IMG_PATH + httpServletRequest.getContextPath() + "/" + 
					Constant.UPLOAD_PATH + "/" + filename);
			atta.setResizeFile(Constant.CONVERT_IMG_PATH + httpServletRequest.getContextPath() + "/" + 
					Constant.UPLOAD_PATH + "/" + resizefilename);
			enterprise.addEnterpriseatta(atta);
			
			enterpriseService.save(enterprise);
			String attachStr = "<div id=\"atta" + atta.getAnnexID() + "\" style=\"width:120px; float:right;\"><a href=\"#\" class=\"track\" ><img src=\"" 
				+ atta.getResizeFile() + "\"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='deletepic("
				+ atta.getAnnexID() + ")'>删除</a><p class=\"Enterprise-Name\">"+ atta.getAnnexName() +"</p>";
			attachStr += "<br/><p class=\"Product-Name\">附件类型：" + atta.getAnnexType() + "</p>";
			if ("质量认证".equals(atta.getAnnexType())) {
				attachStr += "<br/><p class=\"Product-Name\">名称：" + atta.getZhiliang1() + "</p>";
				attachStr += "<br/><p class=\"Product-Name\">认证编号：" + atta.getZhiliang2() + "</p>";
				attachStr += "<br/><p class=\"Product-Name\">认证机构：" + atta.getZhiliang3() + "</p>";
				attachStr += "<br/><p class=\"Product-Name\">认证时间：" + atta.getZhiliang4() + "</p>";
			}
			if ("商标注册".equals(atta.getAnnexType())) {
				attachStr += "<br/><p class=\"Product-Name\">名称：" + atta.getShangbiao1() + "</p>";
			}
			if ("荣誉证书".equals(atta.getAnnexType())) {
				attachStr += "<br/><p class=\"Product-Name\">证书名称：" + atta.getZhengshu1() + "</p>";
				attachStr += "<br/><p class=\"Product-Name\">获证时间：" + atta.getZhengshu2() + "</p>";
			}
			if ("包装信息".equals(atta.getAnnexType())) {
				attachStr += "<br/><p class=\"Product-Name\">包装名称：" + atta.getBaozhuang1() + "</p>";
				attachStr += "<br/><p class=\"Product-Name\">包装材料：" + atta.getBaozhuang2() + "</p>";
			}
			attachStr += "</div>";
			out.print(attachStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return null;
	}
	
	
	
	
	
	public String getList_pass() throws Exception {
		Search search = new Search(Enterprise.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/
		/*User sessionUser = (User) session.get(Constant.USER_SESSION_KEY);
		if (null != sessionUser.getEnterprise()) {
			search.addFilterEqual("enterpriseID", sessionUser.getEnterprise().getEnterpriseID());
		}
		if (null != enterprise.getEnterpriseName() && !"".equals(enterprise.getEnterpriseName())) {
			search.addFilterLike("enterpriseName", "%"+enterprise.getEnterpriseName()+"%");
		}
		if (null != enterprise.getCreateTime()) {
			search.addFilterEqual("createTime", enterprise.getCreateTime());
		}*/

		int count = enterpriseService.count(search);
		List<Enterprise> list = enterpriseService.searchAll(search);
		List<Map<String, Object>> enterpriseList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Enterprise obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				String op = "<a href=\"javascript:void(0)\" onclick=\"setpic("+obj.getEnterpriseID()+")\">设置附件</a>";
				String image = "";
				if (null != obj.getAttalist() && obj.getAttalist().size() > 0) {
					for (Enterpriseatta atta : obj.getAttalist()) {
						image += "&nbsp;<img class=\"image1\" width=\"50px\" " +
						"height=\"50px\" src=\"" + atta.getResizeFile() +"\" />&nbsp;";
					}					
				}
				String name = "<a href=\"javascript:void(0)\" onclick=\"doModify("+obj.getEnterpriseID()+")\">"+obj.getEnterpriseName()+"</a>";
				row.put("id", obj.getEnterpriseID());
				row.put("cell",
						new Object[] { obj.getEnterpriseID(),
						name,
						obj.getEmail(),
						obj.getEnterpriseNature(),
						obj.getCreateTime(),
						obj.getHomePage(),
						obj.getBusinessLicense(),
						obj.getLegalPerson(),
						obj.getStatus(),//
						op, image
				});//其他属性需按页面需要填写
				enterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**
	 * 删除图片
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletepic() throws Exception {
		String msg = "";
		int id = Integer.parseInt(httpServletRequest.getParameter("attaID"));
		Enterpriseatta atta = enterpriseattaService.findById(id);
		File f = new File(atta.getAttaFile());
		f.delete();
		enterpriseattaService.removeById(id);
		msg = "ok";
		sendMessages(httpServletResponse, msg);
		return null;
	}
	
	/**-------------函数功能：获取种子经营者的企业基本信息------------------**/
	public String getUserEnterprise()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		
		user=(User)session.getAttribute("ADMIN_USER");
		
		return "seedEnterprise";
		
	}
	
	
}