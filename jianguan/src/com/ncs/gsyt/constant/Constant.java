package com.ncs.gsyt.constant;


public class Constant {

	// 动态方法分割符
	public static final String SIGN = "!";
	// 后台登陆用户 session key
	public static final String USER_SESSION_KEY = "ADMIN_USER";
	// 功能action的 跟路径
	public static final String ROOT_MENU_URL = "TOOT_MENU_URL";
	// 后台超时重登页面
	public static final String TIME_OUT = "timeout.jsp";

	// word模板处理文件异常
	public static final String WORD_FILE_IO_ERR = "1";
	// word模板处理模板异常
	public static final String WORD_TEMPLATE_ERR = "2";
	// word模板处理其他异常
	public static final String WORD_OTHER_ERR = "3";

	// 用户的初始化密码
	public static final String INIT_PASSWORD = "111111";

	// 上传路径
	public static final String EXAPREPORT_STOR_PATH = "D:\\gsyt\\tomcat7.0.20\\webapps\\jianguan\\upload";
	//public static final String EXAPREPORT_STOR_PATH = "E:\\apache-tomcat-6.0.41\\webapps\\jianguan\\upload";
	public static final String CONVERT_IMG_PATH = "http://220.179.243.6:9011/";
	
	public static final String UPLOAD_PATH = "upload";

	public static final int MAX_SIZE = 52428800;

	// XML生成文件异常
	public static final String XML_FILE_ERR = "1";
	// XML文件IO异常
	public static final String XML_FILE_IO_ERR = "2";
	
	public final static String DB2DRIVER = "com.ibm.db2.jcc.DB2Driver";

	public final static String MSSQLDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public final static String MSSQL_TYPE = "mssql";

	public final static String DB2_TYPE = "DB2";

	
	//手机发送接口
	public static final String SMS_INTERFACEURL = "http://61.191.26.181:8888/SmsPort.asmx?WSDL";
	public static final String SMS_EPID = "1054";
	public static final String SMS_USERNAME = "niaofeixx";
	public static final String SMS_PASSWORD = "5769fa7361d7ecc6";	//123abc
	public static final String SMS_LABEL = "飞鸟科技";	//短信标签
}
