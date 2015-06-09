package com.ncs.gsyt.modules.action;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.json.util.JSONObject;
import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.util.MD5;

@Controller
@Namespace("/admin")
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;
	
	
	

	@Action(value = "/login", results = {
			@Result(name = SUCCESS, location = "/admin/main.jsp"),
			@Result(name = ERROR, location = "/admin/loginError.jsp"),
			@Result(name="to_login",location="/admin/index.jsp")
	})
	@Override
	public String execute() {
		return "to_login";
	}
	
	public String submit(){
		HttpSession session = httpServletRequest.getSession(true);
		if (session.getAttribute("LoginBean") != null)
			session.removeAttribute("LoginBean");
		MD5 md5 = new MD5();
		String userCode = httpServletRequest.getParameter("usercode");
		if(userCode==null){
			return "to_login";
		}
		String password = md5.getMD5ofStr(md5.getMD5ofStr(new String(Base64.encodeBase64(httpServletRequest
				.getParameter("password").getBytes()))).toLowerCase()).toLowerCase();
		User user = new User();
		Search search = new Search();
		search.addFilterEqual("userCode", userCode);
		user = userService.login(search, 7);
		if (null != user) {
			if ("禁用".equals(user.getEnable())) {
				httpServletRequest.setAttribute("showError", "用户被禁用");
				return ERROR;
			} else if (user.getUserPassword().equals(password)) {
				session.setAttribute(Constant.USER_SESSION_KEY, user);
				
				return SUCCESS;
			} else {
				httpServletRequest.setAttribute("showError", "密码错误");
				return ERROR;
			}
		} else {
			httpServletRequest.setAttribute("showError", "用户名不存在");
			return ERROR;
		}
	}
	
	/**
	 * 手机端接口，获取当前版本信息
	 * */
	public String checkVersionCodeByMobile() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		
		try {
			Properties prop = new Properties();
			URL fileURL = this.getClass().getResource("/system.properties");
			FileInputStream fis;
			fis = new FileInputStream(fileURL.getPath());
			prop.load(fis);
			fis.close();
			result.put("android_url", prop.getProperty("android_url"));
			result.put("version_id", prop.getProperty("version_id"));
			result.put("version_code", prop.getProperty("version_code"));
			result.put("min_version_code", prop.getProperty("min_version_code"));
			result.put("update_note", prop.getProperty("update_note"));
			result.put("stat", "1");
			result.put("msg", "ok");
		} catch (NullPointerException npe) {
			result.clear();
			result.put("stat", "101");
			result.put("msg", "缺少必备参数");
		} catch (Exception e) {
			e.printStackTrace();
			String rsult = "其他错误";
			result.clear();
			result.put("stat", "-1");
			result.put("msg", rsult);
		}
		JSONObject json = new JSONObject(result);
		
		out.print(json.toString());
		
		out.flush();
		out.close();
		return null;
	}
}
