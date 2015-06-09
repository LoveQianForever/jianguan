package com.ncs.gsyt.modules.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpToolOnce {

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String username, String password, String checkCode, String sessionid) {
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod("http://123.126.93.134/appraise/login.do");
		String querystr = "HeloDoc-inputEl=4&password="+password+"&username="+username+"&checkCode="+checkCode;
		StringBuffer sbf = new StringBuffer();
		try {
			method.setQueryString(querystr);
			client.executeMethod(method);
			Cookie [] cookies = client.getState().getCookies();
			for (Cookie cook : cookies) {
				if ("JSESSIONID".equals(cook.getName())) {
					cook.setValue(sessionid);
				}
			}
			client.executeMethod(method);
			InputStream ins = method.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(ins,"UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}
			br.close();
			System.out.println(sbf.toString());
		} catch (URIException e) {
			//log.error("执行HTTP Get请求时，编码查询字符串“" + secondurl + "”发生异常！", e);
		} catch (IOException e) {
			//log.error("执行HTTP Get请求" + secondurl + "时，发生异常！", e);
		} finally {
			
			method.releaseConnection();
		}
		return "";
	}
	
	public static void main(String[] args) {
		String usercode = "";
		
		doGet("admin","bbbb","g2dkd","CBF991C6E76E3C2DF26780894B10E3C3");
	}
}
