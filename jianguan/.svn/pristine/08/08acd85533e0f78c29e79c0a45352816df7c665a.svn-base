package com.ncs.gsyt.core.db;

import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.util.PropertiesUtil;

public class ConnectionFactory {

	private String dbDriver = "";
	private String url = "";

	public Connection createConnection(URL fileName)
			throws Exception {
		// 初始化配置属性
		Properties props = PropertiesUtil.getProperties(fileName);
		// 返回值
		DbConnection cp = null;
		if (props != null) {
			dbDriver = Constant.MSSQLDRIVER;
			url = ConstructSqlUrl(props, Constant.MSSQL_TYPE);
			cp = new DbConnection(url, dbDriver, props
					.getProperty("user"), props
					.getProperty("password"));
		}

		// 其他数据库用ORACLE的连接池

		// 返回
		if (cp != null) {
			return cp.getConnection();
		}
		return null;
	}

	private String ConstructSqlUrl(Properties props, String dbType) {
		String newUrl = null;
		if (dbType != null && dbType.equals(Constant.MSSQL_TYPE)) {
			newUrl = "jdbc:sqlserver://"
					+ props.getProperty("dbIP") + ":"
					+ props.getProperty("dbPort") + ";DatabaseName="
					+ props.getProperty("dbName");
			return newUrl;
		}
		if (dbType != null && dbType.equals(Constant.DB2_TYPE)) {

			newUrl = "jdbc:db2://" + props.getProperty("dbIP") + ":"
					+ props.getProperty("dbPort") + "/"
					+ props.getProperty("dbName");
			return newUrl;
		}
		
		return null;
	}
}
