package com.blinkserver.exception;

import java.sql.SQLException;

/**
 * Created by abu on 2016/8/24 11:26.
 */
public abstract class OnExceptionListener implements ExceptionInterface {

    @Override
    public void onException(Exception e) {
        // TODO: 2016/8/24
    }

    @Override
    public void onSQLException(SQLException e) {
        // TODO: 2016/8/24 后期共性处理 比如记录日志
    }
}
