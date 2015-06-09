package com.ncs.gsyt.modules.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSON;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.MenuService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

	private static final long serialVersionUID = 1L;

	private List<Menu> menus;

	private Menu menu = new Menu();

	private Function[] func;

	@Resource
	private MenuService menuService;

	@Action(value = "/menu", results = {
			@Result(name = "success", location = "/admin/leftmenu.jsp"),
			@Result(name = "index", location = "/admin/menu/index.jsp"),
			@Result(name = "toedit", location = "/admin/menu/menuedit.jsp"),
			@Result(name = "toform", location = "/admin/menu/menuform.jsp") })
	@Override
	public String execute() {

		return "index";
	}

	public String viewTree_pass() throws Exception {

		String contexPath = httpServletRequest.getContextPath();

		JSON json = menuService.findMenuTreeJSON(contexPath);
		
		return sendMessages(httpServletResponse, json.toString());
	}

	public String initUpdate() {
		menu = menuService.findById(menu.getNodeCode());
		return "toedit";

	}

	public String initAdd() {
		menu = this.getModel();

		return "toform";

	}

	public String submit_pass() {
		if (isUpdate()) {// 修改

		} else {

		}

		return "index";
	}

	private boolean isUpdate() {
		if (menu == null)
			return false;
		if (menu.getNodeCode() == null)
			return false;
		if ("".equals(menu.getNodeCode()))
			return false;
		return true;
	}

	public String getChildMenu() {

		String pid = httpServletRequest.getParameter("parentId");
		User user = (User) httpServletRequest.getSession().getAttribute(
				Constant.USER_SESSION_KEY);
		if (null != user && null != user.getMenuList()) {
			List<Menu> muenList = user.getMenuList();
			menus = new ArrayList<Menu>();
			for (Menu menu : muenList) {
				if (pid.equals(menu.getParentNode())) {
					menus.add(menu);
				}
			}
		}

		return "success";

	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu getModel() {
		return menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public Function[] getFunc() {
		return func;
	}

	public void setFunc(Function[] func) {
		this.func = func;
	}

}
