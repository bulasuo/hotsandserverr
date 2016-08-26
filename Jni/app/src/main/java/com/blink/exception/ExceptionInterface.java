package com.blink.exception;


import java.sql.SQLException;

/**
 * Created by abu on 2016/8/24 11:10.
 */
public interface ExceptionInterface {

    void onException(Exception e);

    void onSQLException(SQLException e);
}
