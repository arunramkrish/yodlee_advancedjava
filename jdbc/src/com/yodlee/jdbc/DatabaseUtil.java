package com.yodlee.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.crypto.Data;

public class DatabaseUtil {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(DatabaseUtil.class.getResourceAsStream("/jdbc.properties"));
			//prop.load(ClassLoader.getSystemResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String url = prop.getProperty("url");
	private static String user = prop.getProperty("user");
	private static String password = prop.getProperty("password");
	private static String driver = prop.getProperty("driver");

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void releaseResources(Connection conn, Statement stmt,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {

		}

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {

		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}

	}
}
