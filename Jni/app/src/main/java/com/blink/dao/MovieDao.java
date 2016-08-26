package com.blink.dao;

import com.blink.bean.Movie;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/25 15:19.
 */
public class MovieDao extends BaseDao {

    public static int insert(Movie movie, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO movie(u_id,mo_name,mo_img,mo_share,mo_understanding" +
                        ") VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, movie.getU_id());
                ps.setString(2, movie.getMoName());
                ps.setString(3, movie.getMoImg());
                ps.setString(4, movie.getMoShare());
                ps.setString(5, movie.getMoUnderstanding());
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

    public static int deleteById(int mo_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from movie where mo_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, mo_id);
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

    public static ArrayList<Movie> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<Movie> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from movie where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsMovieList(rs);
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

    public static Movie paseAsMovie(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final Movie movie = new Movie(rs.getInt("mo_id"),
                rs.getString("mo_img"),
                rs.getString("mo_name"),
                rs.getString("mo_share"),
                rs.getString("mo_understanding"),
                rs.getInt("u_id"));
        return movie;
    }

    public static ArrayList<Movie> paseAsMovieList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<Movie> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsMovie(rs));
            while(rs.next()){
                list.add(paseAsMovie(rs));
            }
        }
        return list;
    }
}
