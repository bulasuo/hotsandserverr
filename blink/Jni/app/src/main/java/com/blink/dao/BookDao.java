package com.blink.dao;

import com.blink.bean.BookHS;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by abu on 2016/8/24 15:09.
 */
public class BookDao extends BaseDao {

    public static int insert(BookHS book, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO book(u_id, bk_name, bk_img," +
                        "bk_share, bk_understanding) VALUES (?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, book.getU_id());
                ps.setString(2, book.getBkName());
                ps.setString(3, book.getBkImg());
                ps.setString(4, book.getBkShare());
                ps.setString(5, book.getBkUnderstanding());
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

    public static int deleteById(int bk_id, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from book where bk_id=? ";
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
    }

    public static int update(BookHS book, OnExceptionListener exceptionInterface){
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " update book set bk_name=?" +
                        ",bk_img=?,bk_share=?,bk_understanding=? " +
                        "where bk_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, book.getBkName());
                ps.setString(2, book.getBkImg());
                ps.setString(3, book.getBkShare());
                ps.setString(4, book.getBkUnderstanding());
                ps.setInt(5, book.getBkId());
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

    public static ArrayList<BookHS> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
        ArrayList<BookHS> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " select * from book where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                list = paseAsBookList(rs);
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

    public static BookHS paseAsBook(ResultSet rs) throws SQLException {
        if(rs == null)
            return null;
        final BookHS book = new BookHS(rs.getInt("bk_id"),
                rs.getString("bk_img"),
                rs.getString("bk_name"),
                rs.getString("bk_share"),
                rs.getString("bk_understanding"),
                rs.getInt("u_id"));
        return book;
    }

    public static ArrayList<BookHS> paseAsBookList(ResultSet rs) throws SQLException{
        if(rs == null)
            return null;
        ArrayList<BookHS> list = null;
        if(rs.next()){
            list = new ArrayList<>();
            list.add(paseAsBook(rs));
            while(rs.next()){
                list.add(paseAsBook(rs));
            }
        }
        return list;
    }
}
