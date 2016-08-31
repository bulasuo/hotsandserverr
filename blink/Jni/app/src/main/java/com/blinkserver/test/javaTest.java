package com.blinkserver.test;


/**
 * Created by abu on 2016/8/24 12:37.
 */
public class javaTest {


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
         * ArrayList 可以add null
         */
        /*ArrayList<DynamicHS> list = new ArrayList<>();
        list.add(null);
        System.out.println("::"+list.size()+"-"+list.toString());*/

        System.out.println("end\ntime consuming:"+(System.currentTimeMillis()-startTime));
    }
}
