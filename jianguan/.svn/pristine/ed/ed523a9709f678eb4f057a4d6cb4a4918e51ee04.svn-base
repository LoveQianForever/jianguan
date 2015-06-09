package com.ncs.gsyt.core.trans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransInit extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1640802828384991205L;

	static final private String CONTENT_TYPE = "text/html; charset=UTF8";
	
	private TransferServer ts;

	/**
	 * 功能名称：Web服务器初始化 功能说明：对此方法的调用可以完成对Web服务器的初始化设置。
	 *
	 * @exception ServletException
	 */
	public void init() throws ServletException {

		new TransferServer();
	}

	//	Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>initServer</title></head>");
		out.println("<body>");
		out
				.println("<p>The servlet has received a GET. This is the reply.</p>");
		out.println("</body></html>");
	}

	//Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>initServer</title></head>");
		out.println("<body>");
		out
				.println("<p>The servlet has received a POST. This is the reply.</p>");
		out.println("</body></html>");
	}

	public void destroy() {
		ts.destroy();
		System.out.println("监听服务关闭");
	}
}
