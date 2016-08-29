package com.blink.test;

/**
 * Created by abu on 2016/8/29 17:26.
 */
public class TopicReply2DaoTest {

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
         * insert
         */
        /*TopicReply2HS topicReply2HS = new TopicReply2HS();
        topicReply2HS.setTcR2_content("不,这话题不low啊");
        topicReply2HS.setTcR2_date(Timestamp.valueOf("2016-9-15 20:20:3"));
        topicReply2HS.setTcR2_u_id(31);
        topicReply2HS.setTcR_id(1);
        topicReply2HS.setTcR_u_id(30);

        for(int i=0;i<4;i++)
            System.out.println("result:"+ TopicReply2Dao.insert(topicReply2HS, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            }));*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }

}
