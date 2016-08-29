package com.blink.dao;

import com.blink.bean.TopicReplyHS;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 16:19.
 */
public class TopicReplyDao extends BaseDao{

    public static int insert(TopicReplyHS topicReply, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO topicreply(tc_id,u_id,tcR_content,tcR_date" +
                        ") VALUES (?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicReply.getTc_id());
                ps.setInt(2, topicReply.getU_id());
                ps.setString(3, topicReply.getTcR_content());
                ps.setTimestamp(4, topicReply.getTcR_date());
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

    public static int deleteById(int tcR_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from topicreply where tcR_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, tcR_id);
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

    public static ArrayList<TopicReplyHS> queryByTopicId(int topicId, OnExceptionListener exceptionInterface) {
        ArrayList<TopicReplyHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from topicreply where tc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicId);
                rs = ps.executeQuery();
                list = paseAsTopicReplyList(rs);
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

    public static TopicReplyHS paseAsTopicReply(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final TopicReplyHS topicReply = new TopicReplyHS(rs.getInt("tcR_id"),
                rs.getString("tcR_content"),
                rs.getTimestamp("tcR_date"),
                rs.getInt("tc_id"),
                rs.getInt("u_id"));
        return topicReply;
    }

    public static ArrayList<TopicReplyHS> paseAsTopicReplyList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<TopicReplyHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsTopicReply(rs));
            while(rs.next()){
                list.add(paseAsTopicReply(rs));
            }
        }
        return list;
    }
}
