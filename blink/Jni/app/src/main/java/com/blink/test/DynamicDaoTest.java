package com.blink.test;

/**
 * Created by abu on 2016/8/29 15:43.
 */
public class DynamicDaoTest {

    /**
     * update Dynamic
     */
        /*Dynamic dynamic = new Dynamic();
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
        }));*/
    /**
     * query Dynamic
     */
        /*for(Dynamic dynamic: DynamicDao.queryByUserId(26, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
        System.out.println("::"+ dynamic.toString());*/
    /**
     * Dynamic delete
     */
        /*System.out.println("::"+ DynamicDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
    /**
     * Dynamic insert
     */
        /*Dynamic dynamic = new Dynamic();
        dynamic.setU_id(26);
        dynamic.setDncDescribe("呵呵哒bulasuo");
        dynamic.setDncDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        System.out.println("::"+ DynamicDao.insert(dynamic, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
}
