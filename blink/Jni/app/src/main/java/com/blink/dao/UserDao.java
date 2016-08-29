package com.blink.dao;

import com.blink.bean.UserHS;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends BaseDao{

    /**
     * @author abu   2016/8/23   16:50
     * user表不允许删除数据,正确删除是要先删除和user关联的子表才能删除user,
     * 但是实际上没必要删除user表的数据
     */
    public static int insert(UserHS user, OnExceptionListener exceptionInterface) {
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
            } catch (SQLException e){
                exceptionInterface.onSQLException(e);
            } catch (Exception e) {
                exceptionInterface.onException(e);
            } finally {
                DbConn.close(ps);
                DbConn.close(conn);
            }
        }
        return i;
    }

    /**
     * user 的 u_phone不能为空
     * @param user
     * @return
     */
	public static int updateByPhone(UserHS user, OnExceptionListener exceptionInterface){
		int i = -1;
		PreparedStatement ps = null;
		Connection conn = DbConn.getConnSql();
		if(conn!=null){
			try {
				String sql = " update user set u_nickName=?,u_sex=?" +
                        ",u_birth=?,u_affective=?,u_headImg=?,u_sign=? " +
                        ",u_occupation=?,u_sealUp=?,u_sealUpReason=? " +
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
                ps.setInt(10, user.getU_blinkerId());
                ps.setDouble(11, user.getULat());
                ps.setDouble(12, user.getULng());
                ps.setString(13, user.getUPhone());
				i=ps.executeUpdate();
            } catch (SQLException e){
                exceptionInterface.onSQLException(e);
            } catch (Exception e) {
                exceptionInterface.onException(e);
			}finally{
				DbConn.close(ps);
                DbConn.close(conn);
			}
		}
		return i;
	}

    public static int updateById(UserHS user, OnExceptionListener exceptionInterface){
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " update user set u_nickName=?,u_sex=?" +
                        ",u_birth=?,u_affective=?,u_headImg=?,u_sign=? " +
                        ",u_occupation=?,u_sealUp=?,u_sealUpReason=? " +
                        ",u_blinkerId=?,u_lat=?,u_lng=? " +
                        "where u_id=? ";
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
                ps.setInt(10, user.getU_blinkerId());
                ps.setDouble(11, user.getULat());
                ps.setDouble(12, user.getULng());
                ps.setInt(13, user.getUId());
                i=ps.executeUpdate();
            } catch (SQLException e){
                exceptionInterface.onSQLException(e);
            } catch (Exception e) {
                exceptionInterface.onException(e);
            }finally{
                DbConn.close(ps);
                DbConn.close(conn);
            }
        }
        return i;
    }

    /**
     * @author abu   2016/8/23   16:50
     * 根据phone和password查询 密码错误即返回null
     */
    public static UserHS queryByPhone(String phone, String password, OnExceptionListener exceptionInterface) {
        UserHS user = null;
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
                user = paseAsUser(rs);
            } catch (SQLException e){
                exceptionInterface.onSQLException(e);
            } catch (Exception e) {
                exceptionInterface.onException(e);
            } finally {
                DbConn.close(rs);
                DbConn.close(ps);
                DbConn.close(conn);
            }
        }
        return user;
    }

    public static UserHS paseAsUser(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final UserHS user = new UserHS(rs.getInt("u_id"),
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
        return user;
    }

    public static ArrayList<UserHS> paseAsUserList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<UserHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsUser(rs));
            while(rs.next()){
                list.add(paseAsUser(rs));
            }
        }
        return list;
    }
}
