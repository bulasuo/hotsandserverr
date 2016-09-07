package com.blinkserver.test;

/**
 * Created by abu on 2016/9/7 15:41.
 */
public class IPDaoTest {

    public static void main(String[] args){
        long time_start = System.currentTimeMillis();
        System.out.println("start:"+time_start);



        /*IPLogHS ipLogHS = new IPLogHS();
        ipLogHS.setIp("192.168.1.1");
        long time = System.currentTimeMillis();
        ipLogHS.setSms_time(time);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(time);
        ipLogHS.setSms_date(Timestamp.valueOf(d));
        System.out.println("ww::" + IPLogDao.update(ipLogHS, new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }));*/

        /*System.out.println("ww::" + IPLogDao.queryByIP("192.168.10.1", new OnExceptionListener() {
            @Override
            public void onSQLException(SQLException e) {
                super.onSQLException(e);
                System.out.println("Exception:" + e.toString());
            }
        }).toString());*/

        long time_end = System.currentTimeMillis();
        System.out.println("end  :"+time_end+"\ntime cost:"+(time_end-time_start));


    }
}
