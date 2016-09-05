package com.blinkserver.dao;

import com.blinkserver.bean.DynamicHS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/24 17:37.
 */
public class DynamicDao extends BaseDao{

    public static int insert(DynamicHS dynamic, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO dynamic(u_id,dnc_describe,dnc_date" +
                        ") VALUES (?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dynamic.getU_id());
                ps.setString(2, dynamic.getDncDescribe());
                ps.setTimestamp(3, dynamic.getDncDate());
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

    public static int deleteById(int dnc_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from dynamic where dnc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dnc_id);
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

    public static int update(DynamicHS dynamic, OnExceptionListener exceptionInterface){
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " update dynamic set dnc_describe=? " +
                        "where dnc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, dynamic.getDncDescribe());
                ps.setInt(2, dynamic.getDncId());
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

    public static ArrayList<DynamicHS> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<DynamicHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from dynamic where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsDynamicList(rs);
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

    public static DynamicHS paseAsDynamic(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final DynamicHS dynamic = new DynamicHS(rs.getInt("dnc_id"),
                rs.getTimestamp("dnc_date"),
                rs.getString("dnc_describe"),
                rs.getInt("u_id"));
        return dynamic;
    }

    public static ArrayList<DynamicHS> paseAsDynamicList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<DynamicHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsDynamic(rs));
            while(rs.next()){
                list.add(paseAsDynamic(rs));
            }
        }
        return list;
    }
}
