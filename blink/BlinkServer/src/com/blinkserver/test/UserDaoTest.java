package com.blinkserver.test;

import com.blinkserver.dao.UserDao;
import com.blinkserver.exception.OnExceptionListener;

import java.sql.SQLException;

/**
 * Created by abu on 2016/8/29 15:14.
 */
public class UserDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");


        /*UserHS user = new UserHS();
        user.setUId(30);
        user.setUPhone("15062239789");
        user.setUPassword("111111");
        user.setU_nickName("布拉索123666");
        user.setUSex((byte)0x01);
        user.setUBirth(Timestamp.valueOf("2016-9-15 20:20:3"));
        user.setUAffective((byte)0x11f);
        user.setU_headImg("https://www.baidu.com");
        user.setUSign("腰包满是银子,米加德遍地鲜花");
        user.setUOccupation("南京艺厘米文化科技有限公司");
        user.setU_sealUp((byte)0x00);
        user.setU_sealUpReason("出轨啦,要死啦!");
        user.setU_createDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        user.setU_blinkerId(111);
        System.out.println("result:"+ UserDao.updateById(user, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * user query
         */
        System.out.println("result:"+ UserDao.queryByPhone("15062239788", "111111", new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }).toString());
        /**
         * user insert
         */
       /* UserHS user1 = new UserHS();
        user1.setUPhone("15062239789");
        user1.setUPassword("111111");
        user1.setU_nickName("苏拉底");
        user1.setUSex((byte)0x01);
        user1.setUBirth(Timestamp.valueOf("2016-9-15 20:20:3"));
        user1.setUAffective((byte)0x11f);
        user1.setU_headImg("https://www.baidu.com");
        user1.setUSign("腰包满是银子,米加德遍地鲜花");
        user1.setUOccupation("南京艺厘米文化科技有限公司");
        user1.setU_sealUp((byte)0x00);
        user1.setU_sealUpReason("出轨啦,要死啦!");
        user1.setU_createDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        user1.setU_blinkerId(111);
        System.out.println("result:"+ UserDao.insert(user1, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        })+(byte)0x1f);*/


        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
