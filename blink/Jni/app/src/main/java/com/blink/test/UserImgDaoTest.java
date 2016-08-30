package com.blink.test;

/**
 * Created by abu on 2016/8/30 09:58.
 */
public class UserImgDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");

        /**
         * query
         */
        /*for(UserImgHS userImgHS: UserImgDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(userImgHS.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ UserImgDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*UserImgHS userImgHS = new UserImgHS();
        userImgHS.setU_id(30);
        userImgHS.setUImg_img("www.ssssss");
        for(int i=0;i<4;i++)
            System.out.println("result:"+ UserImgDao.insert(userImgHS, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
