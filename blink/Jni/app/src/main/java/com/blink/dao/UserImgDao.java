package com.blink.dao;

import com.blink.bean.UserImg;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/27 10:27.
 */
public class UserImgDao {

    public static int insert(UserImg userImg, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO userimg(u_id,uImg_img" +
                        ") VALUES (?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userImg.getU_id());
                ps.setString(2, userImg.getUImg_img());
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

    public static int deleteById(int uImg_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from userimg where uImg_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, uImg_id);
                i = ps.executeUpdate();
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

    public static ArrayList<UserImg> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<UserImg> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from userimg where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsUserImgList(rs);
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
        return list;
    }

    public static UserImg paseAsUserImg(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final UserImg userImg = new UserImg(rs.getInt("uImg_id"),
                rs.getString("uImg_img"),
                rs.getInt("u_id"));
        return userImg;
    }

    public static ArrayList<UserImg> paseAsUserImgList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<UserImg> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsUserImg(rs));
            while(rs.next()){
                list.add(paseAsUserImg(rs));
            }
        }
        return list;
    }
}
