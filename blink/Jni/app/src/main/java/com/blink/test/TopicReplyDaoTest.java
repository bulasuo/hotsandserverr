package com.blink.test;

/**
 * Created by abu on 2016/8/29 17:19.
 */
public class TopicReplyDaoTest {

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
       /* for(TopicReplyHS topicReplyHS: TopicReplyDao.queryByTopicId(4, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }))
                System.out.println(topicReplyHS.toString());*/

        /**
         * delete
         */
        /*System.out.println("result:"+ TopicReplyDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /**
         * insert
         */
        /*TopicReplyHS topicReplyHS = new TopicReplyHS();
        topicReplyHS.setTc_id(4);
        topicReplyHS.setTcR_content("这个话题好low");
        topicReplyHS.setTcR_date(Timestamp.valueOf("2016-9-15 20:20:3"));
        topicReplyHS.setU_id(30);
        for(int i=0;i<4;i++)
            System.out.println("result:"+ TopicReplyDao.insert(topicReplyHS, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
