package com.blinkserver.dao;

import com.blinkserver.bean.MVHS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 15:50.
 */
public class MVDao extends BaseDao {

    public static int insert(MVHS mv, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO mv(u_id,mv_name,mv_img,mv_share,mv_understanding" +
                        ") VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, mv.getU_id());
                ps.setString(2, mv.getMvName());
                ps.setString(3, mv.getMvImg());
                ps.setString(4, mv.getMvShare());
                ps.setString(5, mv.getMvUnderstanding());
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

    public static int deleteById(int mv_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from mv where mv_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, mv_id);
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

    public static ArrayList<MVHS> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<MVHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from mv where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsMVList(rs);
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

    public static MVHS paseAsMV(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final MVHS mv = new MVHS(rs.getInt("mv_id"),
                rs.getString("mv_img"),
                rs.getString("mv_name"),
                rs.getString("mv_share"),
                rs.getString("mv_understanding"),
                rs.getInt("u_id"));
        return mv;
    }

    public static ArrayList<MVHS> paseAsMVList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<MVHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsMV(rs));
            while(rs.next()){
                list.add(paseAsMV(rs));
            }
        }
        return list;
    }
}
