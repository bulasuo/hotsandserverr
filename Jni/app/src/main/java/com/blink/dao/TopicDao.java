package com.blink.dao;

import com.blink.bean.Topic;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 15:59.
 */
public class TopicDao extends BaseDao {

    public static int insert(Topic topic, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO topic(u_id,tc_type,tc_name,tc_date,tc_describe" +
                        ") VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topic.getU_id());
                ps.setString(2, topic.getTcType());
                ps.setString(3, topic.getTcName());
                ps.setTimestamp(4, topic.getTcDate());
                ps.setString(5, topic.getTcDescribe());
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

    public static int deleteById(int tc_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from topic where tc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, tc_id);
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

    public static ArrayList<Topic> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<Topic> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from topic where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsTopicList(rs);
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

    public static Topic paseAsTopic(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final Topic topic = new Topic(rs.getInt("tc_id"),
                rs.getTimestamp("tc_date"),
                rs.getString("tc_describe"),
                rs.getString("tc_name"),
                rs.getString("tc_type"),
                rs.getInt("u_id"));
        return topic;
    }

    public static ArrayList<Topic> paseAsTopicList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<Topic> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsTopic(rs));
            while(rs.next()){
                list.add(paseAsTopic(rs));
            }
        }
        return list;
    }
}
