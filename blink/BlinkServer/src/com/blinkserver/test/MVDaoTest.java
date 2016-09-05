package com.blinkserver.test;

/**
 * Created by abu on 2016/8/29 16:55.
 */
public class MVDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");


        /**
         * query
         */
        /*for(MVHS mvhs: MVDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(mvhs.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ MVDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
       /* MVHS mvhs = new MVHS();
        mvhs.setU_id(30);
        mvhs.setMvImg("www");
        mvhs.setMvName("你和我");
        mvhs.setMvShare("share:www");
        mvhs.setMvUnderstanding("很好看的mv");

        for(int i=0;i<4;i++)
        System.out.println("result:"+ MVDao.insert(mvhs, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
