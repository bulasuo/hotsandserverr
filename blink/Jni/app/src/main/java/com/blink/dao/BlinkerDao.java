package com.blink.dao;

import com.blink.bean.BlinkerHS;
import com.blink.bean.UserHS;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/24 09:29.
 */
public class BlinkerDao extends BaseDao {


    public static int insert(BlinkerHS blinker, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO blinker(bk_blinkerId,bk_blinkeredId,bk_createDate" +
                        ") VALUES (?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, blinker.getBk_blinkerId());
                ps.setInt(2, blinker.getBk_blinkeredId());
                ps.setTimestamp(3, blinker.getBk_createDate());
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
     * 当bk_id不存在的时候,return 0;
     * 眨眼映射表不允许删除动作,且没有进行数据安全验证
     * @param bk_id
     * @param exceptionInterface
     * @return
     */
    /*public static int deleteById(int bk_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from blinker where bk_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, bk_id);
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
    }*/

    /**
     * 根据被眨眼者id查眨眼者;
     * @param bk_blinkeredId
     * @param exceptionInterface
     * @return
     */
    public static ArrayList<UserHS> queryByBlinkeredId(int bk_blinkeredId, OnExceptionListener exceptionInterface) {
        ArrayList<UserHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from blinker,user where blinker.bk_blinkerId = user.u_id " +
                        "and blinker.bk_blinkeredId=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, bk_blinkeredId);
                rs = ps.executeQuery();
                list = UserDao.paseAsUserList(rs);
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
}
