package com.blink.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbConn {

	public static Connection getConnSql(){
		Properties pro = new Properties();
		String driver = null;
		String url = null;
		String username = null;
		String password = null;
		Connection conn = null;
		try {
			/*InputStream is = DbConn.class.getClassLoader()
					.getResourceAsStream("DB.properties");
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username,
					password);*/
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blink?user=root&password=bulasuo@0220&useUnicode=true&characterEncoding=utf-8");
//			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shiyan10","jwwxxonwyy","kmi1ihw5my11ki53x1y30yxk2myl2wl1w5m4kzwl");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		/*catch (IOException e) {
			e.printStackTrace();
		}*/
		return conn;	
	}

	/**
	 * 关闭Connection
	 * @param conn
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭PreparedStatement
	 * @param sm
	 */
	public static void close(PreparedStatement  sm){
		if(sm!=null){
			try {
				sm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭ResultSet
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
