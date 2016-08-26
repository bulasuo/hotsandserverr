package com.blink.dao;

import com.blink.bean.UserDetail;
import com.blink.db.DbConn;
import com.blink.exception.OnExceptionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by abu on 2016/8/25 17:15.
 */
public class UserDetailDao extends BaseDao {

    public static int insert(UserDetail userDetail, OnExceptionListener exceptionInterface) {
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if (conn != null) {
            try {
                String sql = " INSERT INTO book(u_id, ud_height, ud_weight," +
                        "ud_salary, ud_settlement, ud_liveparents, ud_education," +
                        "ud_hometown, ud_location, ud_virgin, ud_snore, ud_driving," +
                        "ud_bodyOdor, ud_ownHouse, ud_ownCar, ud_states, ud_topics," +
                        "ud_replyTopics, ud_blinks, ud_blinkeds, ud_breaks) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userDetail.getU_id());
                ps.setInt(2, userDetail.getUdHight());
                ps.setInt(3, userDetail.getUdWeight());
                ps.setInt(4, userDetail.getUdSalary());
                ps.setString(5, userDetail.getUdSettlement());
                ps.setByte(6, userDetail.getUdLiveparents());
                ps.setString(7, userDetail.getUdEducation());
                ps.setString(8, userDetail.getUdHometown());
                ps.setString(9, userDetail.getUdLocation());
                ps.setByte(10, userDetail.getUdVirgin());
                ps.setByte(11, userDetail.getUdSnore());
                ps.setString(12, userDetail.getUdDriving());
                ps.setByte(13, userDetail.getUd_bodyOdor());
                ps.setByte(14, userDetail.getUd_ownHouse());
                ps.setString(15, userDetail.getUd_ownCar());
                ps.setInt(16, userDetail.getUdStates());
                ps.setInt(17, userDetail.getUdTopics());
                ps.setInt(18, userDetail.getUd_replyTopics());
                ps.setInt(19, userDetail.getUdBlinks());
                ps.setInt(20, userDetail.getUdBlinkeds());
                ps.setInt(21, userDetail.getUdBreaks());
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

    public static int deleteByUserId(int userId, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from user_detail where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userId);
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

    public static int deleteById(int userDetailId, OnExceptionListener exceptionInterface) {
        int i = 0;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " delete from user_detail where ud_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userDetailId);
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

    public static int updateByUserId(UserDetail userDetail, OnExceptionListener exceptionInterface){
        int i = -1;
        PreparedStatement ps = null;
        Connection conn = DbConn.getConnSql();
        if(conn!=null){
            try {
                String sql = " update book set ud_height=?, ud_weight=?," +
                        "ud_salary=?, ud_settlement=?, ud_liveparents=?, ud_education=?," +
                        "ud_hometown=?, ud_location=?, ud_virgin=?, ud_snore=?, ud_driving=?," +
                        "ud_bodyOdor=?, ud_ownHouse=?, ud_ownCar=?, ud_states=?, ud_topics=?," +
                        "ud_replyTopics=?, ud_blinks=?, ud_blinkeds=?, ud_breaks=? " +
                        "where u_id=? ";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, userDetail.getUdHight());
                ps.setInt(2, userDetail.getUdWeight());
                ps.setInt(3, userDetail.getUdSalary());
                ps.setString(4, userDetail.getUdSettlement());
                ps.setByte(5, userDetail.getUdLiveparents());
                ps.setString(6, userDetail.getUdEducation());
                ps.setString(7, userDetail.getUdHometown());
                ps.setString(8, userDetail.getUdLocation());
                ps.setByte(9, userDetail.getUdVirgin());
                ps.setByte(10, userDetail.getUdSnore());
                ps.setString(11, userDetail.getUdDriving());
                ps.setByte(12, userDetail.getUd_bodyOdor());
                ps.setByte(13, userDetail.getUd_ownHouse());
                ps.setString(14, userDetail.getUd_ownCar());
                ps.setInt(15, userDetail.getUdStates());
                ps.setInt(16, userDetail.getUdTopics());
                ps.setInt(17, userDetail.getUd_replyTopics());
                ps.setInt(18, userDetail.getUdBlinks());
                ps.setInt(19, userDetail.getUdBlinkeds());
                ps.setInt(20, userDetail.getUdBreaks());
                ps.setInt(21, userDetail.getU_id());
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

//    public static ArrayList<Book> queryByUserId(int userId, OnExceptionListener exceptionInterface) {
//        ArrayList<Book> list = null;
//        ResultSet rs = null;
//        PreparedStatement ps = null;
//        Connection conn = DbConn.getConnSql();
//        if (conn != null) {
//            try {
//                String sql = " select * from book where u_id=? ";
//                ps = conn.prepareStatement(sql);
//                ps.setInt(1, userId);
//                rs = ps.executeQuery();
//                list = paseAsBookList(rs);
//            } catch (SQLException e){
//                exceptionInterface.onSQLException(e);
//            } catch (Exception e) {
//                exceptionInterface.onException(e);
//            } finally {
//                DbConn.close(rs);
//                DbConn.close(ps);
//                DbConn.close(conn);
//            }
//        }
//        return list;
//    }
//
//    public static Book paseAsBook(ResultSet rs) throws SQLException {
//        if(rs == null)
//            return null;
//        final Book book = new Book(rs.getInt("bk_id"),
//                rs.getString("bk_img"),
//                rs.getString("bk_name"),
//                rs.getString("bk_share"),
//                rs.getString("bk_understanding"),
//                rs.getInt("u_id"));
//        return book;
//    }
//
//    public static ArrayList<Book> paseAsBookList(ResultSet rs) throws SQLException{
//        if(rs == null)
//            return null;
//        ArrayList<Book> list = null;
//        if(rs.next()){
//            list = new ArrayList<>();
//            list.add(paseAsBook(rs));
//            while(rs.next()){
//                list.add(paseAsBook(rs));
//            }
//        }
//        return list;
//    }
}
