package com.blink.exception;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Created by abu on 2016/8/24 11:26.
 */
public abstract class OnExceptionListener implements ExceptionInterface {


    public void onException(Exception e) {

    }

    public void onMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException e) {

    }
}
