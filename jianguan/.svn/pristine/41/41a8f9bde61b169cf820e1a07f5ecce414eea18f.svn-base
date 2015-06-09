package com.ncs.gsyt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.util.JSONMessage;
import com.ncs.gsyt.core.util.RequestUtil;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.User;

/**
 * 以{@link SecurityFilter#IGNORE_AUTH_PATTERN} 结尾的方法不进行鉴权, 直接通过.
 * 
 * @author
 * 
 */
public class SecurityFilter implements Filter {

	public static final String IGNORE_AUTH_PATTERN = ".+[_]pass$";// 不要验证的action方法名模式

	private static final Log log = LogFactory.getLog(SecurityFilter.class);

	private static final List<String> NoFilterUrl = new ArrayList<String>();

	private static final List<String> NoFilterUrlDependOnSession = new ArrayList<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		initNoFilterUrln(arg0);
		initNoFilterUrlDependOnSession(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = ((HttpServletRequest) (arg0));
		HttpServletResponse response = ((HttpServletResponse) arg1);
		boolean isAjax = RequestUtil.isAjaxRequest(request); // ajax请求标识
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String requestPath = RequestUtil.getFullURL(request);
		if (requestPath.indexOf(".jsp")>0&& !requestPath.endsWith(Constant.TIME_OUT)  
				|| requestPath.equals("/jianguan/") || requestPath.indexOf("ByMobile")>0
				|| requestPath.indexOf("login!reg")>0 || requestPath.indexOf(".html")>0 ) {
			HttpSession session = request.getSession(false);
			if (requestPath.indexOf("/alipay/")>0) {
				if (log.isDebugEnabled())
					log.debug("网站支付接口，不需鉴权! IP:" + request.getRemoteAddr());
				arg2.doFilter(arg0, arg1);
				return;
			}
			if (requestPath.indexOf("reg.jsp")>0 || requestPath.indexOf("ByMobile")>0
					|| requestPath.indexOf("login!reg")>0 || requestPath.indexOf("/html/")>0) {
				arg2.doFilter(arg0, arg1);
				return;
			}
			if (requestPath.indexOf(".html")>0) {
				arg2.doFilter(arg0, arg1);
				return;
			}
			if (session != null && null != session.getAttribute(Constant.USER_SESSION_KEY)) {
				arg2.doFilter(arg0, arg1);
				return;
			}
			/*if (requestPath.indexOf("indexM.jsp") > 0) {
				response.sendRedirect(request.getContextPath() + "/mobile/login.do");
				return;
			}*/
			String repURL = request.getContextPath() + "/admin/login.do";
			response.sendRedirect(repURL);
			return;
		}
		
		if (log.isDebugEnabled())
			log.debug("请求路径：" + requestPath);
		/** 权限拦截 */
		int flag = interceptor(request, response);
		
		if (requestPath.indexOf("/alipay/")>0) {
			if (log.isDebugEnabled())
				log.debug("手机端访问，不需鉴权! IP:" + request.getRemoteAddr());
			arg2.doFilter(arg0, arg1);
			return;
		}
		if (flag == -1) {
			if (log.isDebugEnabled())
				log.debug("不需鉴权! IP:" + request.getRemoteAddr());
			arg2.doFilter(arg0, arg1);
			return;
		} else if (flag == 0) {
			if (log.isDebugEnabled())
				log.debug("session超时! IP:" + request.getRemoteAddr());
			if (isAjax) {
				JSONMessage m = new JSONMessage();
				m.setFlag(JSONMessage.Flag.TIMEOUT);
				m.setMsg("您好，操作超时，请重新登录!");
				response.setContentType("application/json;");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print(m);
				out.close();
			} else {
				String repURL = request.getContextPath() + "/admin/"
						+ Constant.TIME_OUT;
				response.sendRedirect(repURL);
			}
			return;
		} else if (flag == 1) {
			if (log.isDebugEnabled())
				log.debug("通过正常拦截! IP:" + request.getRemoteAddr());
			arg2.doFilter(arg0, arg1);
			return;
		} else if (flag == 2) {
			if (log.isDebugEnabled())
				log.debug("通过方法拦截! IP:" + request.getRemoteAddr());
			arg2.doFilter(arg0, arg1);
			return;
		} else if (flag == 3) {
			if (log.isDebugEnabled())
				log.debug("用户没有该权限功能，禁止访问! IP:" + request.getRemoteAddr());
			
			if (isAjax) {
				response.setContentType("application/json;");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				JSONMessage m = new JSONMessage();
				m.setFlag(JSONMessage.Flag.FAIL);
				m.setMsg("您好，你没有该项操作的权限!\n如有疑问请联系管理员!");
				out.print(m);
				out.close();
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out
						.println("alert('您好，你没有该项操作的权限!\\n如有疑问请联系管理员!');history.go(-1);");
				out.println("</script>");
				out.close();
			}
			
			return;
		}
	}

	/**
	 * 拦截用户的URL和功能方法<br/>
	 * 
	 * @param request -
	 *            请求对象
	 * @return 没通过验证返回0 <br/> 通过根菜单验证或通过不需要会话的URL验证或通过不需要会话的URL难的都返回1 <br/>
	 *         通过方法名称验证返回2<br/>
	 * @throws IOException
	 * @throws ServletException
	 */
	public static int interceptor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int flag = 0;
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		// 不拦截并不需要会话的URL
		for (String p : NoFilterUrl) {
			p = contextPath + p;
			if (url.startsWith(p)) {
				if (log.isDebugEnabled()) {
					log.debug("不需要拦截的url: " + url);
				}
				return flag = 1;
			}
		}
		// 不拦截并需要会话的URL
		for (String p : NoFilterUrlDependOnSession) {
			p = contextPath + p;
			if (url.startsWith(p)) {
				if (log.isDebugEnabled()) {
					log.debug("会话中,但不需要拦截的url:" + url);
				}
				return flag = 1;
			}
		}
		HttpSession session = request.getSession(false);
		if (session == null) {
			log.info("会话超时!");
			return flag = 0;
		}
		User user = (User) session.getAttribute(Constant.USER_SESSION_KEY);
		if (user == null) {
			if (log.isDebugEnabled())
				log.debug("会话中用户对象为空!");
			return flag = 0;
		}

		Map<String, Menu> menuMap = user.getMenuMap();
		if (menuMap == null) {
			log.info("会话中菜单对象为空!");
			return flag = 0;
		}
		String rootUrl = RequestUtil.getRootUrl(url);
		/** 暂存根目录 * */
		session.setAttribute(Constant.ROOT_MENU_URL, rootUrl);
		rootUrl = rootUrl.replace(contextPath, "");
		Menu menu = menuMap.get(rootUrl);// 尝试直接取菜单
		if (menu == null) {
			log.info("请求的路径不存在！");
			return flag = 3;
		}

		/** 如果是根目录进行放行 * */
		String methodName = null;
		if (url.indexOf(Constant.SIGN) != -1) {
			methodName = RequestUtil.getFunctionName(url);
		} else {
			return flag = 1;
		}
		// menu = menuMap.get(rootUrl);// 取出根菜单
		List<Function> function = menu.getMyFuncs();
		if (function == null) {
			log.info("请求的功能路径为空!");
			return flag = 3;
		}
		if (methodName.matches(IGNORE_AUTH_PATTERN)) {// 无需进行权限控制的路径
			if (log.isDebugEnabled()) {
				log.debug("不需要拦截的url:" + url);
			}
			return flag = -1;
		}
		int i = 0;
		int count = function.size();
		for (; i < count; i++) {
			Function f = function.get(i);
			if (f != null) {
				if (methodName.equals(f.getFunctionCode())) {// 检查方法名称是否存在该菜单中
					return 2;
				}
			}
		}
		if (i == function.size()) {
			log.info("该用户没有指定的功能权限:" + methodName);
			flag = 3;
		}
		return flag;
	}

	/** 初始化不过滤的URL,但需要会话 */
	private void initNoFilterUrlDependOnSession(FilterConfig arg0) {
		String temp = arg0.getInitParameter("NoFilterUrlDependOnSession");
		if (temp != null) {
			String[] nfu = temp.split(",");
			for (int i = 0; nfu != null && i < nfu.length; i++) {
				String url = nfu[i].trim();
				NoFilterUrlDependOnSession.add(url);
			}
		}
	}

	/** 初始化不过滤的URL */
	private void initNoFilterUrln(FilterConfig arg0) {
		String temp = arg0.getInitParameter("NoFilterUrl");
		if (temp != null) {
			String[] nfu = temp.split(",");
			for (int i = 0; nfu != null && i < nfu.length; i++) {
				String url = nfu[i].trim();
				NoFilterUrl.add(url);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}
}
