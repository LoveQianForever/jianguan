package com.ncs.gsyt.core.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.util.StringUtil;

public class PageUserHref {

	/**
	 * 自动为单个地址加上所属菜单的前缀
	 * 
	 * @param param -
	 *            "update&id=1" 是指调用update这个方法,并且id为1
	 */
	public static String getOneHref(HttpServletRequest request,
			HttpServletResponse response) {
		return getOneHref(request, response, null);
	}

	/**
	 * 自动为单个地址加上所属菜单的前缀没有 <code>param=""</code>返回根目录去掉.do
	 * <code>param=null</code>返回根目录<br/>
	 * 
	 * @param param -
	 *            "update&id=1" 是指调用update这个方法,并且id为1
	 */
	public static String getOneHref(HttpServletRequest request,
			HttpServletResponse response, String param) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "";
		}
		if (param == null) {
			return (String) session.getAttribute(Constant.ROOT_MENU_URL);
		}
		String root_menu_url = (String) session
				.getAttribute(Constant.ROOT_MENU_URL);

		root_menu_url = RequestUtil.subActionSuffix(root_menu_url)
				+ Constant.SIGN + StringUtil.getString(param);

		return response.encodeRedirectURL(root_menu_url);
	}

	/**
	 * 循环取出用户的方法列表,并生成相应的HTML值,提供给页面显示.
	 * 以search,init,del,do开头的方法才给予显出出来,反之都不显示在这个循环列表中
	 * 
	 * @param param -
	 *            地址参数
	 */
	public static String getManyHref(HttpServletRequest request,
			HttpServletResponse response, String param) {
		List<String> defaultShow = new LinkedList<String>();
		defaultShow.add("del");
		defaultShow.add("init");
		defaultShow.add("do");
		return iteratorFuncHref(request, response, param, defaultShow);
	}

	/**
	 * 循环取出用户的方法列表,并生成相应的HTML值,提供给页面显示.
	 * 以search,init,del开头的方法才给予显出出来,反之都不显示在这个循环列表中
	 * 
	 * @param param -
	 *            地址参数
	 * @param show -
	 *            要显示的方法名称
	 * @param showAppoint -
	 *            是否是只显示指定show列表,如果为false,则会显示默认的加指定的.如果为true则只显示指定的
	 */
	public static String getManyHref(HttpServletRequest request,
			HttpServletResponse response, String param, String show,
			Boolean showAppoint) {
		LinkedList<String> defaultShow = new LinkedList<String>();
		if (!showAppoint) {
			defaultShow.add("del");
			defaultShow.add("init");
			defaultShow.add("do");
		}
		String[] func = show.split(",");
		if (func != null && func.length != 0) {
			for (int i = 0; i < func.length; i++) {
				if (!StringUtil.isNullValue(func[i]))
					defaultShow.addLast(func[i]);
			}
		}
		return iteratorFuncHref(request, response, param, defaultShow);
	}

	/* 如果方法是以:del或do开头,则会有JS提示确认 */
	private static String iteratorFuncHref(HttpServletRequest request,
			HttpServletResponse response, String param, List<String> show) {

		StringBuffer href = new StringBuffer("");
		String contextPath = request.getContextPath();
		try {
			if (StringUtil.isNullValue(param)) {
				param = StringUtil.getString(param);
			} else {
				param = "?" + param;
			}
			String repURL = request.getContextPath() + Constant.TIME_OUT;

			HttpSession session = request.getSession(false);
			if (session == null) {
				request.getRequestDispatcher(repURL).forward(request, response);
				return href.toString();
			}
			String rootUrl = (String) session
					.getAttribute(Constant.ROOT_MENU_URL);
			String url = "";
			User user = (User) session.getAttribute(Constant.USER_SESSION_KEY);
			if (user == null) {
				request.getRequestDispatcher(repURL).forward(request, response);
				return href.toString();
			}
			Map<String, Menu> menuMap = user.getMenuMap();
			if (menuMap == null) {
				return href.toString();
			}

			Menu menu = menuMap.get(rootUrl.replace(contextPath, ""));
			if (menu == null) {
				return href.toString();
			}
			List<Function> funcList = menu.getMyFuncs();
			if (funcList == null) {
				return href.toString();
			}
			for (int i = 0; i < funcList.size(); i++) {
				Function function = funcList.get(i);
				String f_name = function.getFunctionCode();
				Boolean isConfim = false;// 是否加JS确认提示
				Boolean isShow = false;// 是否显示的标志
				for (int j = 0; show != null && j < show.size(); j++) {
					if (!StringUtil.isNullValue(show.get(j))
							&& f_name.startsWith(show.get(j))) {
						isShow = true;
						break;
					}
				}
				if (!isShow) // 如果列表中没有指定方法,则返回不显示
					continue;
				else if (f_name.startsWith("del") || f_name.startsWith("do")) {
					isConfim = true;
				}
				url = RequestUtil.subActionSuffix(rootUrl) + Constant.SIGN
						+ RequestUtil.addActionSuffix(f_name) + param;
				url = response.encodeRedirectURL(url);
				href.append("<a href='");
				if (isConfim) {
					href.append("javascript:void(0)'");
					href.append(" onclick='return " + f_name + "(\"");
					href.append(url);
					href.append("\");' ");
				} else {
					href.append(url);
					href.append("'");
					if (!StringUtil.isNullValue(function.getFunctionName())) {
						href.append(" title='");
						href.append(function.getFunctionName());
						href.append("' ");
					}
				}
				href.append(">");
				href.append(function.getFunctionName());
				href.append("</font></a>&nbsp;&nbsp;");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return href.toString();
	}

}
