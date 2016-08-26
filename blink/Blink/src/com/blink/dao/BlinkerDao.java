package com.blink.dao;

import com.blink.bean.Blinker;
import com.blink.db.DbConn;
import com.blink.exception.ExceptionInterface;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by abu on 2016/8/24 09:29.
 */
public class BlinkerDao extends BaseDao {

    public static int insert(Blinker blinker, ExceptionInterface exceptionInterface) {
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
            } catch (MySQLIntegrityConstraintViolationException e) {
                exceptionInterface.onMySQLIntegrityConstraintViolationException(e);
            } catch (Exception e) {
                exceptionInterface.onException(e);
            } finally {
                DbConn.close(conn);
                DbConn.close(ps);
            }

        }
        return i;
    }

}
