package com.ncs.gsyt.core.base.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.core.base.search.Sort;
import com.ncs.gsyt.modules.util.StringUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletContextAware,
		ServletResponseAware, ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 1L;

	protected ServletContext servletContext;

	protected HttpServletRequest httpServletRequest;

	protected HttpServletResponse httpServletResponse;

	protected HttpSession httpSession;

	protected Map<String, Object> session;

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
		this.httpSession = request.getSession();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 
	 * sendMes(组装删除是发送信息) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @param state
	 * @param msg
	 * @return
	 * @throws Exception
	 *             String
	 * @exception
	 * @since 1.0.0
	 */
	public String sendMessages(HttpServletResponse response, String json)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		return null;
	}

	protected Search getSearch(Search search) {

		String strpage = StringUtil.isNull(httpServletRequest
				.getParameter("page"));
		String strrp = StringUtil.isNull(httpServletRequest.getParameter("rp"));
		int page, rp;
		if (!"".equals(strpage)) {
			page = Integer.valueOf(strpage);
		} else {
			page = 1;
		}
		if (!"".equals(strrp)) {
			rp = Integer.valueOf(strrp);
		} else {
			rp = 15;
		}
		String sortName = httpServletRequest.getParameter("sortname");
		String sortOrder = httpServletRequest.getParameter("sortorder");

		search.setPage(page - 1);
		search.setFirstResult(rp * (page - 1));
		search.setMaxResults(rp);

		Sort sort = new Sort();
		sort.setProperty(sortName);
		if ("asc".equalsIgnoreCase(sortOrder)) {
			sort.setDesc(false);
		} else if ("desc".equalsIgnoreCase(sortOrder)) {
			sort.setDesc(true);
		}
		search.addSorts(sort);
		return search;
	}

	protected JSONObject resultTOJson(Search search, int count,
			List<Map<String, Object>> userList) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("page", search.getPage() + 1);
		result.put("total", count);
		result.put("rows", userList);
		JSONObject json = new JSONObject(result);
		return json;
	}
}
