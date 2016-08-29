package com.blink.test;

import com.blink.bean.UserDetailHS;
import com.blink.dao.BookDao;
import com.blink.dao.UserDetailDao;
import com.blink.exception.OnExceptionListener;

import java.sql.SQLException;

/**
 * Created by abu on 2016/8/29 17:40.
 */
public class UserDetailDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");
        /*System.out.println("result:"+ BookDao.insert(book, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/


        UserDetailHS userDetailHS = new UserDetailHS();
        userDetailHS.setU_id(30);
        userDetailHS.setUd_bodyOdor(0);
//        userDetailHS.setUd_ownCar(1);
        for(int i=0;i<4;i++)
            System.out.println("result:"+ UserDetailDao.insert(book, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            }));

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
