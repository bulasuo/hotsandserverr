package com.blink.dao;

import com.blink.bean.DynamicImgHS;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 14:37.
 */
public class DynamicImgDao extends BaseDao {

    public static int insert(DynamicImgHS dynamicImg, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO dynamicimg(dnc_id,dImg_img" +
                        ") VALUES (?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dynamicImg.getDnc_id());
                ps.setString(2, dynamicImg.getDImg_img());
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

    public static int deleteById(int dImg_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from dynamicimg where dImg_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dImg_id);
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

    public static ArrayList<DynamicImgHS> queryByDynamicId(int dynamicId, OnExceptionListener exceptionInterface) {
        ArrayList<DynamicImgHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from dynamicimg where dnc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, dynamicId);
                rs = ps.executeQuery();
                list = paseAsDynamicImgList(rs);
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

    public static DynamicImgHS paseAsDynamicImg(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final DynamicImgHS dynamicImg = new DynamicImgHS(rs.getInt("dImg_id"),
                rs.getString("dImg_img"),
                rs.getInt("dnc_id"));
        return dynamicImg;
    }

    public static ArrayList<DynamicImgHS> paseAsDynamicImgList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<DynamicImgHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsDynamicImg(rs));
            while(rs.next()){
                list.add(paseAsDynamicImg(rs));
            }
        }
        return list;
    }
}
