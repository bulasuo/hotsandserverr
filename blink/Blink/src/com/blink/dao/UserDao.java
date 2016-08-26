package com.blink.dao;

import com.blink.bean.User;
import com.blink.db.DbConn;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao extends BaseDao{

    /**
     * @author abu   2016/8/23   16:50
     * user表不允许删除数据,正确删除是要先删除和user关联的子表才能删除user,
     * 但是实际上没必要删除user表的数据
     */
    public static int insert(User user) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO user(u_phone,u_password,u_nickName" +
                        ",u_sex,u_birth,u_affective,u_headImg,u_sign" +
                        ",u_occupation,u_sealUp,u_sealUpReason" +
                        ",u_createdate,u_blinkerId,u_lat,u_lng) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUPhone());
                ps.setString(2, user.getUPassword());
                ps.setString(3, user.getU_nickName());
                ps.setInt(4, user.getUSex());
                ps.setTimestamp(5, user.getUBirth());
                ps.setInt(6, user.getUAffective());
                ps.setString(7, user.getU_headImg());
                ps.setString(8, user.getUSign());
                ps.setString(9, user.getUOccupation());
                ps.setInt(10, user.getU_sealUp());
                ps.setString(11, user.getU_sealUpReason());
                ps.setTimestamp(12, user.getU_createDate());
                ps.setInt(13, user.getU_blinkerId());
                ps.setDouble(14, user.getULat());
                ps.setDouble(15, user.getULng());
                i = ps.executeUpdate();
            } catch (MySQLIntegrityConstraintViolationException e) {

            } catch (Exception e) {
                i = -1;
                e.printStackTrace();
            } finally {
                DbConn.close(conn);
                DbConn.close(ps);
            }
        }
        return i;
    }

    /**
     * user 的 u_phone不能为空
     * @param user
     * @return
     */
	public static int update(User user){
		int i = -1;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
			try {
				String sql = " update user set u_nickName=?,u_sex=?" +
                        ",u_birth=?,u_affective=?,u_headImg=?,u_sign=? " +
                        ",u_occupation=?,u_sealUp=?,u_sealUpReason=?,u_createdate=? " +
                        ",u_blinkerId=?,u_lat=?,u_lng=? " +
                        "where u_phone=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getU_nickName());
				ps.setByte(2, user.getUSex());
				ps.setTimestamp(3, user.getUBirth());
				ps.setByte(4, user.getUAffective());
				ps.setString(5, user.getU_headImg());
				ps.setString(6, user.getUSign());
                ps.setString(7, user.getUOccupation());
                ps.setByte(8, user.getU_sealUp());
                ps.setString(9, user.getU_sealUpReason());
                ps.setTimestamp(10, user.getU_createDate());
                ps.setInt(11, user.getU_blinkerId());
                ps.setDouble(12, user.getULat());
                ps.setDouble(13, user.getULng());
                ps.setString(14, user.getUPhone());
				i=ps.executeUpdate();
			} catch (Exception e) {
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
     * @author abu   2016/8/23   16:50
     * 根据phone和password查询 密码错误即返回null
     */
    public static User queryByPhone(String phone, String password) {
        User user = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from user where u_phone=? and u_password=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, phone);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt("u_id"),
                            rs.getByte("u_affective"),
                            rs.getTimestamp("u_birth"),
                            rs.getInt("u_blinkerId"),
                            rs.getTimestamp("u_createDate"),
                            rs.getString("u_headImg"),
                            rs.getDouble("u_lat"),
                            rs.getDouble("u_lng"),
                            rs.getString("u_nickName"),
                            rs.getString("u_occupation"),
                            rs.getString("u_phone"),
                            rs.getByte("u_sealUp"),
                            rs.getString("u_sealUpReason"),
                            rs.getByte("u_sex"),
                            rs.getString("u_sign"));
                }
            } catch (Exception e) {
                user = null;
                e.printStackTrace();
            } finally {
                DbConn.close(conn);
                DbConn.close(ps);
                DbConn.close(rs);
            }
        }
        return user;
    }
}
