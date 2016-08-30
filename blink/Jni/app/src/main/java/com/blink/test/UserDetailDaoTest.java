package com.blink.test;

/**
 * Created by abu on 2016/8/29 17:40.
 */
public class UserDetailDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");

        /**
         * query
         */
       /* System.out.println("result:"+ UserDetailDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * update
         */
        /*UserDetailHS userDetailHS = new UserDetailHS();
        userDetailHS.setU_id(30);
        userDetailHS.setUd_bodyOdor((byte)0x00);
        userDetailHS.setUd_ownCar("凯迪拉克");
        userDetailHS.setUd_ownHouse((byte)0x01);
        userDetailHS.setUd_replyTopics(10);
        userDetailHS.setUdBlinkeds(10);
        userDetailHS.setUdBlinks(10);
        userDetailHS.setUdBreaks(1);
        userDetailHS.setUdDriving("c1");
        userDetailHS.setUdEducation("学士");
        userDetailHS.setUdHight(182);
        userDetailHS.setUdHometown("索马里");
        userDetailHS.setUdLiveparents((byte)0x00);
        userDetailHS.setUdLocation("南京");
        userDetailHS.setUdSalary(5000);
        userDetailHS.setUdSettlement("生无可恋");
        userDetailHS.setUdSnore((byte)0x00);
        userDetailHS.setUdStates(10);
        userDetailHS.setUdTopics(10);
        userDetailHS.setUdVirgin((byte)0x00);
        userDetailHS.setUdWeight(71);
        System.out.println("result:"+ UserDetailDao.updateByUserId(userDetailHS, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * delete
         */
       /* System.out.println("result:"+ UserDetailDao.deleteByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*UserDetailHS userDetailHS = new UserDetailHS();
        userDetailHS.setU_id(30);
        userDetailHS.setUd_bodyOdor((byte)0x00);
        userDetailHS.setUd_ownCar("凯迪拉克");
        userDetailHS.setUd_ownHouse((byte)0x01);
        userDetailHS.setUd_replyTopics(10);
        userDetailHS.setUdBlinkeds(10);
        userDetailHS.setUdBlinks(10);
        userDetailHS.setUdBreaks(1);
        userDetailHS.setUdDriving("c1");
        userDetailHS.setUdEducation("学士");
        userDetailHS.setUdHight(182);
        userDetailHS.setUdHometown("索马里");
        userDetailHS.setUdLiveparents((byte)0x00);
        userDetailHS.setUdLocation("南京");
        userDetailHS.setUdSalary(5000);
        userDetailHS.setUdSettlement("北海道");
        userDetailHS.setUdSnore((byte)0x00);
        userDetailHS.setUdStates(10);
        userDetailHS.setUdTopics(10);
        userDetailHS.setUdVirgin((byte)0x00);
        userDetailHS.setUdWeight(71);
        for(int i=0;i<4;i++)
            System.out.println("result:"+ UserDetailDao.insert(userDetailHS, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
