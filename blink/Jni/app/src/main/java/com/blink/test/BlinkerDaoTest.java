package com.blink.test;

/**
 * Created by abu on 2016/8/29 15:41.
 */
public class BlinkerDaoTest {

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
}
