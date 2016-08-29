package com.blink.test;

/**
 * Created by abu on 2016/8/29 16:05.
 */
public class MovieDaoTest {

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


        /*for(MovieHS movieHS:MovieDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
        System.out.println("result:"+ movieHS.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ MovieDao.deleteById(3, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*MovieHS movie = new MovieHS();
        movie.setU_id(30);
        movie.setMoImg("www1");
        movie.setMoName("完美世界");
        movie.setMoShare("share:www");
        movie.setMoUnderstanding("nice movie");

        for(int i= 0; i<4;i++)
        System.out.println("result:"+ MovieDao.insert(movie, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
