package com.blinkserver.dao;

import com.blinkserver.bean.IPLogHS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by abu on 2016/9/7 15:14.
 */
public class IPLogDao extends BaseDao {

    public static int insert(IPLogHS ipLogHS, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO iplog(ip, sms_time, sms_date) VALUES (?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ipLogHS.getIp());
                ps.setLong(2, ipLogHS.getSms_time());
                ps.setTimestamp(3, ipLogHS.getSms_date());
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

    public static int update(IPLogHS ipLogHS, OnExceptionListener exceptionInterface){
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " update iplog set sms_time=?" +
                        ",sms_date=? where ip=? ";
                ps = conn.prepareStatement(sql);
                ps.setLong(1, ipLogHS.getSms_time());
                ps.setTimestamp(2, ipLogHS.getSms_date());
                ps.setString(3, ipLogHS.getIp());
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

    public static IPLogHS queryByIP(String ip, OnExceptionListener exceptionInterface) {
        IPLogHS ipLogHS = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from iplog where ip=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
                rs = ps.executeQuery();
                if(rs.next())
                    ipLogHS = paseAsIPLog(rs);
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
        return ipLogHS;
    }

    public static IPLogHS paseAsIPLog(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final IPLogHS ipLogHS = new IPLogHS(rs.getInt("iplog_id"),
                rs.getString("ip"),
                rs.getLong("sms_time"),
                rs.getTimestamp("sms_date"));
        return ipLogHS;
    }
}
