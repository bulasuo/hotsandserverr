package com.blinkserver.test;

/**
 * Created by abu on 2016/8/29 17:11.
 */
public class TopicImgDaoTest {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");


        /**
         * query
         */
        /*for(TopicImgHS topicImgHS: TopicImgDao.queryByTopicId(4, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(topicImgHS.toString());*/

        /**
         * delete
         */
       /* System.out.println("result:"+ TopicImgDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*TopicImgHS topicImgHS = new TopicImgHS();
        topicImgHS.setTc_id(4);
        topicImgHS.setTImg_img("www");
        for(int i =0;i<4;i++)
        System.out.println("result:"+ TopicImgDao.insert(topicImgHS, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
