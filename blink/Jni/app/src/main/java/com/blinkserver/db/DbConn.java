package com.blinkserver.db;

import com.blinkserver.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConn {

	public static Connection getConnSql(){
		Connection conn = null;
		try {
			Class.forName(Config.MYSQL_DRIVER);
			conn = DriverManager.getConnection(Config.MYSQL_URL, Config.MYSQL_USER_NAME,
					Config.MYSQL_PASSWORD);
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blink?user=root&password=bulasuo@0220&useUnicode=true&characterEncoding=utf-8");
////			conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_shiyan10","jwwxxonwyy","kmi1ihw5my11ki53x1y30yxk2myl2wl1w5m4kzwl");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				e.printStackTrace();
			}
		}
	}
}
