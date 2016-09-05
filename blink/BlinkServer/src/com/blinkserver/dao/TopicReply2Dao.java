package com.blinkserver.dao;

import com.blinkserver.bean.TopicReply2HS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 16:56.
 */
public class TopicReply2Dao extends BaseDao {

    public static int insert(TopicReply2HS topicReply2, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO topicreply2(tcR_id,tcR2_u_id" +
                        ",tcR_u_id, tcR2_content,tcR2_date" +
                        ") VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicReply2.getTcR_id());
                ps.setInt(2, topicReply2.getTcR2_u_id());
                ps.setInt(3, topicReply2.getTcR_u_id());
                ps.setString(4, topicReply2.getTcR2_content());
                ps.setTimestamp(5, topicReply2.getTcR2_date());
                i = ps.executeUpdate();
            } catch (SQLException e) {
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

    public static int deleteById(int tcR2_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " delete from topicreply2 where tcR2_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, tcR2_id);
                i = ps.executeUpdate();
            } catch (SQLException e) {
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

    public static ArrayList<TopicReply2HS> queryByTopicReplyId(int topicReplyId, OnExceptionListener exceptionInterface) {
        ArrayList<TopicReply2HS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from topicreply2 where tcR_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicReplyId);
                rs = ps.executeQuery();
                list = paseAsTopicReply2List(rs);
            } catch (SQLException e) {
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

    public static TopicReply2HS paseAsTopicReply2(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        final TopicReply2HS topicReply2 = new TopicReply2HS(
                rs.getInt("tcR2_id"),
                rs.getInt("tcR2_u_id"),
                rs.getInt("tcR_u_id"),
                rs.getString("tcR2_content"),
                rs.getTimestamp("tcR2_date"),
                rs.getInt("tcR_id"));
        return topicReply2;
    }

    public static ArrayList<TopicReply2HS> paseAsTopicReply2List(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        ArrayList<TopicReply2HS> list = null;
        if (rs.next()) {
            list = new ArrayList<>();
            list.add(paseAsTopicReply2(rs));
            while (rs.next()) {
                list.add(paseAsTopicReply2(rs));
            }
        }
        return list;
    }
}
