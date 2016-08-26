package com.blink.test;


import com.blink.bean.Dynamic;

import java.util.ArrayList;

/**
 * Created by abu on 2016/8/24 12:37.
 */
public class javaTest {


    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("start");
        /*System.out.println("::"+ BookDao.insert(book, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/


        /**
         * ArrayList 可以add null
         */
        ArrayList<Dynamic> list = new ArrayList<>();
        list.add(null);
        System.out.println("::"+list.size()+"-"+list.toString());
        /**
         * book query list
         */
//        ArrayList<Book> list;
//        list = BookDao.queryByUserId(30, new OnExceptionListener() {
//            @Override
//            public void onSQLException(SQLException e) {
//                super.onSQLException(e);
//                System.out.println("Exception:" + e.toString());
//            }
//        });
//        if(list != null)
//            for(Book u:list)
//                System.out.println("abu::"+u.toString());
        /**
         * book update
         */
        /*Book book = new Book();
        book.setBkImg("https://www.baidu.com");
        book.setBkName("loveless");
        book.setBkShare("httpjlnkll");
        book.setBkUnderstanding("最终幻想-克劳德");
        book.setU_id(30);
        book.setBkId(3);
        System.out.println("::"+ BookDao.update(book, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * book delete
         */
       /* System.out.println("::"+ BookDao.deleteById(2, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * book insert
         */
       /* Book book = new Book();
        book.setBkImg("https://www.baidu.com");
        book.setBkName("loveless");
        book.setBkShare("httpjlnkll");
        book.setBkUnderstanding("最终幻想-沙菲罗斯");
        book.setU_id(30);
        System.out.println("::"+ BookDao.insert(book, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * blinker query
         */
       /* for(int i = 0; i< 1;i++){
            ArrayList<User> list;
            list = BlinkerDao.queryByBlinkeredId(30, new OnExceptionListener() {
                @Override
                public void onSQLException(SQLException e) {
                    super.onSQLException(e);
                    System.out.println("Exception:" + e.toString());
                }
            });
            if(list != null)
                for(User u:list)
                    System.out.println("abu::"+u.toString());
            System.out.println("\n");
        }*/
        /**
         * blinker delete
         */
        /*System.out.println("::"+ BlinkerDao.deleteById(31, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * blinker insert 30.26.31.32
         */
        /*Blinker blinker = new Blinker();
        blinker.setBk_blinkerId(31);
        blinker.setBk_blinkeredId(30);
        blinker.setBk_createDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        System.out.println("::"+ BlinkerDao.insert(blinker, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/
        /**
         * user query
         */
        /*System.out.println("::"+ UserDao.queryByPhone("15062239788", "111111").toString());*/
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
        System.out.println("insert:"+ UserDao.insert(user)+(byte)0x1f);*/


        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
