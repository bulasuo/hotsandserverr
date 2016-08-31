package com.blinkserver.dao;

import com.blinkserver.bean.TopicImgHS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 16:09.
 */
public class TopicImgDao extends BaseDao {

    public static int insert(TopicImgHS topicImg, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO topicimg(tc_id,tImg_img" +
                        ") VALUES (?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicImg.getTc_id());
                ps.setString(2, topicImg.getTImg_img());
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

    public static int deleteById(int tImg_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from topicimg where tImg_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, tImg_id);
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

    public static ArrayList<TopicImgHS> queryByTopicId(int topicId, OnExceptionListener exceptionInterface) {
        ArrayList<TopicImgHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from topicimg where tc_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, topicId);
                rs = ps.executeQuery();
                list = paseAsTopicImgList(rs);
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

    public static TopicImgHS paseAsTopicImg(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final TopicImgHS topicImg = new TopicImgHS(rs.getInt("tImg_id"),
                rs.getString("tImg_img"),
                rs.getInt("tc_id"));
        return topicImg;
    }

    public static ArrayList<TopicImgHS> paseAsTopicImgList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<TopicImgHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsTopicImg(rs));
            while(rs.next()){
                list.add(paseAsTopicImg(rs));
            }
        }
        return list;
    }
}
