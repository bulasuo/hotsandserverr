package com.blinkserver.test;

/**
 * Created by abu on 2016/8/29 16:45.
 */
public class MusicDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");


        /**
         * query
         */
        /*for(MusicHS musicHS: MusicDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(musicHS.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ MusicDao.deleteById(3, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*MusicHS musicHS = new MusicHS();
        musicHS.setU_id(30);
        musicHS.setMsName("直到世界尽头");
        musicHS.setMsImg("www");
        musicHS.setMsShare("Share:www");
        musicHS.setMsUnderstanding("很好听");
        for (int i = 0; i < 4 ;i++)
        System.out.println("result:"+ MusicDao.insert(musicHS, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
