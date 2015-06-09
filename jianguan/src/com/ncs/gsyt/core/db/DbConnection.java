package com.ncs.gsyt.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	//private PrintWriter log;
	private String DBDriver = null;
	private String url = null;
	private String userName = null;
	private String password = null;
	private Connection conn = null;

	public DbConnection(String url, String dbDriver, String userName,
			String password) {
		this.DBDriver = dbDriver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public Connection getConnection() {
		try {
			Class.forName(DBDriver).newInstance();
			conn = DriverManager.getConnection(this.url, this.userName,
					this.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.conn;
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void release(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void release(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void release(Connection conn) {
		try {
			if (conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
