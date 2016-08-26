package com.blink.exception;


import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Created by abu on 2016/8/24 11:10.
 */
public interface ExceptionInterface {

    public void onException(Exception e);

    public void onMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException e);
}
