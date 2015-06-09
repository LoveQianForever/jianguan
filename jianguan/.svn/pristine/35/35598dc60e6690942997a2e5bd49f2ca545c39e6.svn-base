package com.ncs.gsyt.modules.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * HTTP工具箱
 * 
 * @author leizhimin 2009-6-19 16:36:18
 */
public class HttpTookit {

	private static Log log = LogFactory.getLog(HttpTookit.class);

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String url, String queryString, String sessionid) {
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			if (StringUtils.isNotBlank(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
			//设置cookie
			HttpState state = new HttpState();
			Cookie cookie = new Cookie();
			cookie.setName("JSESSIONID");
			cookie.setValue(sessionid);
			state.addCookie(cookie);
			client.setState(state);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
		} catch (URIException e) {
			log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e);
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
		return response;
	}
	
	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String firsturl, String secondurl, String firstqueryString, String secondqueryString) {
		Cookie c = new Cookie();
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(firsturl);
		try {
			if (StringUtils.isNotBlank(firstqueryString))
				method.setQueryString(URIUtil.encodeQuery(firstqueryString));
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				Cookie [] cookies = client.getState().getCookies();
				for (Cookie cook : cookies) {
					if ("JSESSIONID".equals(cook.getName())) {
						c = cook;
					}
				}
			}
			
		} catch (IOException e) {
			log.error("执行获取sessionid请求" + firsturl + "时，发生异常！", e);
		} finally {
			//method.releaseConnection();
		}
		String response = null;
		StringBuffer sbf = new StringBuffer();
		method = new GetMethod(secondurl);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			if (StringUtils.isNotBlank(secondqueryString))
				method.setQueryString(secondqueryString);
			//设置cookie
			/*HttpState state = new HttpState();
			c.setDomain(".10.144.181.4");
			c.setPath("/topbirt/");
			state.addCookie(c);
			client.setState(state);*/
			
			//method.getParams().setContentCharset("GB2312");
			client.executeMethod(method);
			
			System.out.println(method.getStatusCode());
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				//response = method.getResponseBodyAsString();
				/*byte[] responseBody = method.getResponseBody();
				response = new String(responseBody);*/
				InputStream ins = method.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(ins,"GB2312"));
				
				String line = null;
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
				br.close();
			}
		} catch (URIException e) {
			log.error("执行HTTP Get请求时，编码查询字符串“" + secondurl + "”发生异常！", e);
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + secondurl + "时，发生异常！", e);
		} finally {
			
			method.releaseConnection();
		}
		return sbf.toString();
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, Map<String, String> params, String sessionid) {
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(url);
		// 设置Http Post数据
		if (params != null) {
			HttpMethodParams p = new HttpMethodParams();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				p.setParameter(entry.getKey(), entry.getValue());
			}
			method.setParams(p);
		}
		//设置cookie
		HttpState state = new HttpState();
		Cookie cookie = new Cookie();
		cookie.setName("JSESSIONID");
		cookie.setValue(sessionid);
		state.addCookie(cookie);
		client.setState(state);
		try {
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
		} catch (IOException e) {
			log.error("执行HTTP Post请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}

		return response;
	}
	
	public static String getsessionid(String url, String queryString) {
		String sessionid = "";
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(url);
		try {
			if (StringUtils.isNotBlank(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				Cookie [] cookies = client.getState().getCookies();
				for (Cookie cook : cookies) {
					if ("JSESSIONID".equals(cook.getName())) {
						sessionid = cook.getValue();
					}
				}
			}
		} catch (IOException e) {
			log.error("执行获取sessionid请求" + url + "时，发生异常！", e);
		} finally {
			method.releaseConnection();
		}
		return sessionid;
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("usercode", "admin");
		map.put("password", "123456");
		String sessionid = getsessionid("http://218.23.42.49:9010/azker/admin/login.do", "");
		String x = doPost("http://218.23.42.49:9010/azker/admin/login!submit.do", map, sessionid);
		System.out.println(x);
	}
}
