package com.blink.test;

/**
 * Created by abu on 2016/8/29 15:14.
 */
public class UserDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");


        /*User user = new User();
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
        /*System.out.println("result:"+ UserDao.queryByPhone("15062239788", "111111").toString());*/
        /**
         * user insert
         */
       /* User user = new User();
        user.setUPhone("15062239789");
        user.setUPassword("111111");
        user.setU_nickName("苏拉底");
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
        System.out.println("result:"+ UserDao.insert(user)+(byte)0x1f);*/


        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
