package com.blinkserver.test;

import com.blinkserver.bean.DynamicHS;
import com.blinkserver.dao.DynamicDao;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by abu on 2016/8/29 15:43.
 */
public class DynamicDaoTest {
    public static void main(String[] args) {
        /**
         * update
         */
        DynamicHS dynamic = new DynamicHS();
        dynamic.setDncId(3);
        dynamic.setU_id(26);
        dynamic.setDncDescribe("苏拉底");
        dynamic.setDncDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        System.out.println("::"+ DynamicDao.update(dynamic, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
        /**
         * query
         */
        for(DynamicHS dynamic1: DynamicDao.queryByUserId(26, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
        System.out.println("::"+ dynamic1.toString());
        /**
         *  delete
         */
        System.out.println("::"+ DynamicDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
        /**
         * insert
         */
        DynamicHS dynamic2 = new DynamicHS();
        dynamic2.setU_id(26);
        dynamic2.setDncDescribe("呵呵哒bulasuo");
        dynamic2.setDncDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        System.out.println("::"+ DynamicDao.insert(dynamic2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));
    }
}
