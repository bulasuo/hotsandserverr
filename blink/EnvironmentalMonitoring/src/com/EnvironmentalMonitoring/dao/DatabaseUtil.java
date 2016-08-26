package com.EnvironmentalMonitoring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blink.db.DbConn;

import com.EnvironmentalMonitoring.bin.User;



public class DatabaseUtil {
	/**
	 * 向数据库中插入一条用户记录
	 * @param username	用户名
	 * @param password	密码
	 * @param email		注册邮箱
	 * @return	the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public static int insert(User user) {
		int i = -1;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " INSERT INTO user(my_name,my_password,my_phone,my_right,my_class_id,my_email) VALUES (?,?,?,?,?,?) ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getRight());
			ps.setInt(5, user.getClass_id());
			ps.setString(6, user.getEmail());
		    i=ps.executeUpdate();
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
		}
		}
		return i;
	}

	/**
	 * 通过用户名和密码，验证某个用户是否存在数据库中
	 * @param username	用户名
	 * @param pwd	密码
	 * @param context	数据库上下文
	 * @return	如果存在，返回true,如果不存在，返回false
	 */
	public static boolean query(String name, String password) {
		boolean b=false;
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_name=? and my_password=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 while(rs.next()){
					b=true;
			 }
		} catch (SQLException e) {
			b=false;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return b;
	}
	
	/**
	 * 通过用户名查找该用户的注册邮箱
	 * @param username	用户名
	 * @param context	数据库上下文
	 * @return 如果找到则返回该用户的注册邮箱，如果没找到则返回null
	 */
	public static String queryUserEmail(String name) 
	{
		String res=null;
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_name=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 while(rs.next()){
					res=rs.getString("my_email");
			 }	
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return res;
	}
	
	/**
	 * 通过用户名查找该用户的密码
	 * @param username	用户名
	 * @param context	数据库上下文
	 * @return 如果找到则返回该用户的密码，如果没找到则返回null
	 */
	public static String queryUserPassword(String name) 
	{
		String res=null;
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_name=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 while(rs.next()){
					res=rs.getString("my_password");
			 }	
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return res;
	}
	
	/**
	 * 通过用户名查找该用户的手机号
	 * @param username	用户名
	 * @param context	数据库上下文
	 * @return 如果找到则返回该用户的手机号，如果没找到则返回null
	 */	
	public static String queryUserPhone(String name) 
	{
		String res=null;
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_name=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 while(rs.next()){
					res=rs.getString("my_phone");
			 }	
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return res;
	}
	/**
	 * 
	 * @param name
	 * @param context
	 * @return <User>
	 */
	@SuppressWarnings("null")
	public static User queryUser(String name) 
	{
		User res = new User();
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_name=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
		    rs = ps.executeQuery(); //创建数据对象   
			 if(rs.next()){
					res.setName(rs.getString("my_name"));
					res.setPassword(rs.getString("my_password"));
					res.setPhone(rs.getString("my_phone"));
					res.setRight(rs.getString("my_right"));
					res.setClass_id(rs.getInt("my_class_id"));
					res.setEmail(rs.getString("my_email"));
			 }else{res=null;}	
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return res;	
	}
	/**
	 * 通过手机号查找该用户的信息User对象
	 * @param phone	手机号
	 * @param context	数据库上下文
	 * @return 如果找到则返回该用户的一个对象，如果没找到则返回null
	 */	
	public static User queryUserbyphone(String user_phone) 
	{
		User res=new User();
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from user where my_phone=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_phone);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 if(rs.next()){
					res.setName(rs.getString("my_name"));
					res.setPassword(rs.getString("my_password"));
					res.setPhone(rs.getString("my_phone"));
					res.setRight(rs.getString("my_right"));
					res.setClass_id(rs.getInt("my_class_id"));
					res.setEmail(rs.getString("my_email"));
			 }else{res=null;}	
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return res;
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	public static int UserUpdate(User user){
		int i = -1;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " update user set my_password=?,my_phone=?,my_right=?,my_class_id=?,my_email=? where my_name=? "; 
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getRight());
			ps.setInt(4, user.getClass_id());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getName());
		    i=ps.executeUpdate();
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
		}
		}
		return i;
		
	}
	/**
	 * 查询该手机号用户的citylist
	 * @author bulasuo
	 * @param phone
	 * @return
	 */
	public static ArrayList<String> queryCityWeather(String phone){ 
		ArrayList<String> citylist =new ArrayList<String>();
		
		ResultSet rs=null;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			String sql = " select * from cityWeather where userPhone=? ";                        
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
		    rs = ps.executeQuery(); //创建数据对象                                        
			 while(rs.next()){
				 citylist.add(rs.getString("cityName"));
			 }

			 
		} catch (SQLException e) {
			return null;
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
			DbConn.close(rs);
		}
		}
		return citylist;
		
	}
	public static int saveCityWeather(String phone,ArrayList<String> list){
		int i = 0;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
		try {
			//删除
			String sql = " delete from cityWeather where userPhone=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.executeUpdate();
			ps=null;
			//保存
			for(int j=0;j<list.size();j++){
			    sql = " INSERT INTO cityWeather(userPhone,cityName) VALUES (?,?) ";                        
				ps = conn.prepareStatement(sql);
				ps.setString(1, phone);
				ps.setString(2, list.get(j));
				i+=ps.executeUpdate();
			}
		    
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
		}
		}
		return i;
	}

	public static int weather_delete(String userPhone, String cityName) {
		int i = 0;
		PreparedStatement ps = null; 
		Connection conn = DbConn.getConnSql(); 
		if(conn!=null){
		try {
			//删除
			String sql = " delete from cityWeather where userPhone=? and cityName=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPhone);
			ps.setString(2, cityName);
			i = ps.executeUpdate();
			
			
		    
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
		}finally{
			DbConn.close(conn);
			DbConn.close(ps);
		}
		}
		return i;
		
	}
}
