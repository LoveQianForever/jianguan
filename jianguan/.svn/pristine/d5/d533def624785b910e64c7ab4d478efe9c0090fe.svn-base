package com.ncs.gsyt.core.util;

import javax.servlet.http.HttpServletRequest;

import com.ncs.gsyt.constant.Constant;

public class RequestUtil {

	public static final String ACTION_SUFFIX_PATTERN = ".+[.]do$";// Action结尾
	public static final String ACTION_SUFFIX = ".do";

	/**
	 * 获取请求路径的根目录如/manange/user!add.do 返回为/manange/user.do
	 * 
	 * @param url
	 * @return
	 */
	public static String getRootUrl(String url) {
		if (url.indexOf(".do") != -1) {
			url = url.substring(0, url.indexOf(".do"));
		}

		if (url.indexOf(Constant.SIGN) != -1) {
			url = url.substring(0, url.indexOf(Constant.SIGN));
		}
		return addActionSuffix(url);
	}

	public static String subActionSuffix(String url) {
		if (url.matches(ACTION_SUFFIX_PATTERN)) {
			url = url.substring(0, url.indexOf(".do"));
		}
		return url;
	}

	public static String addActionSuffix(String url) {
		if (!url.matches(ACTION_SUFFIX_PATTERN)) {
			url += ".do";
		}
		return url;
	}

	/**
	 * 获取请求路径的根目录如/manange/user!add.do 返回为add
	 * 
	 * @param url
	 * @return
	 */
	public static String getFunctionName(String url) {

		return url.substring(url.indexOf(Constant.SIGN) + 1, url
				.indexOf(ACTION_SUFFIX));
	}

	/**
	 * 返回全路径url
	 */
	public static String getFullURL(HttpServletRequest request) {
		String uri = getURI(request);
		String queryString = request.getQueryString();
		if (queryString == null)
			return uri;
		return uri + "?" + queryString;
	}

	/** 返回不带参数的URI */
	public static String getURI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String xmlHttpHead = request.getHeader("x-requested-with");
		boolean isAjax = "XMLHttpRequest".equals(xmlHttpHead); // ajax请求标识

		return isAjax;
	}
}
