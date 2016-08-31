package com.blinkserver.dao;

import com.blinkserver.bean.MusicHS;
import com.blinkserver.db.DbConn;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 15:34.
 */
public class MusicDao extends BaseDao {

    public static int insert(MusicHS music, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO music(u_id,ms_name,ms_img,ms_share,ms_understanding" +
                        ") VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, music.getU_id());
                ps.setString(2, music.getMsName());
                ps.setString(3, music.getMsImg());
                ps.setString(4, music.getMsShare());
                ps.setString(5, music.getMsUnderstanding());
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

    public static int deleteById(int ms_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from music where ms_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, ms_id);
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

    public static ArrayList<MusicHS> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<MusicHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from music where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsMusicList(rs);
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

    public static MusicHS paseAsMusic(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final MusicHS music = new MusicHS(rs.getInt("ms_id"),
                rs.getString("ms_img"),
                rs.getString("ms_name"),
                rs.getString("ms_share"),
                rs.getString("ms_understanding"),
                rs.getInt("u_id"));
        return music;
    }

    public static ArrayList<MusicHS> paseAsMusicList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<MusicHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsMusic(rs));
            while(rs.next()){
                list.add(paseAsMusic(rs));
            }
        }
        return list;
    }
}
