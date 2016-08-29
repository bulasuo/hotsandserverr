package com.blink.test;

/**
 * Created by abu on 2016/8/29 17:04.
 */
public class TopicDaoTest {

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


        /**
         * query
         */
       /* for(TopicHS topicHS: TopicDao.queryByUserId(30, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(topicHS.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ TopicDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*TopicHS topicHS = new TopicHS();
        topicHS.setU_id(30);
        topicHS.setTcDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        topicHS.setTcDescribe("这个话题很有意思");
        topicHS.setTcName("话题标题");
        topicHS.setTcType("type1");

        for(int i=0;i<4;i++)
        System.out.println("result:"+ TopicDao.insert(topicHS, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
