package test;

import java.sql.Timestamp;

import com.blink.bean.Blinker;
import com.blink.dao.BlinkerDao;
import com.blink.exception.OnExceptionListener;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class javaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start");


        Blinker blinker = new Blinker();
        blinker.setBk_blinkeredId(30);
        blinker.setBk_blinkerId(26);
        blinker.setBk_createDate(Timestamp.valueOf("2016-9-15 20:20:3"));
        System.out.println("::"+ BlinkerDao.insert(blinker, new OnExceptionListener() {
            @Override
            public void onMySQLIntegrityConstraintViolationException(MySQLIntegrityConstraintViolationException e) {
                System.out.println("Exception:"+e.getErrorCode());//1452/1062
            }
        }));


        /**
         * user query
         */
//        System.out.println("::"+ UserDao.queryByPhone("15062239788", "111111").toString());
        /**
         * user insert
         */
//        User user = new User();
//        user.setUPhone("15062239789");
//        user.setUPassword("111111");
//        user.setU_nickName("苏拉底");
//        user.setUSex((byte)0x01);
//        user.setUBirth(Timestamp.valueOf("2016-9-15 20:20:3"));
//        user.setUAffective((byte)0x11f);
//        user.setU_headImg("https://www.baidu.com");
//        user.setUSign("腰包满是银子,米加德遍地鲜花");
//        user.setUOccupation("南京艺厘米文化科技有限公司");
//        user.setU_sealUp((byte)0x00);
//        user.setU_sealUpReason("出轨啦,要死啦!");
//        user.setU_createDate(Timestamp.valueOf("2016-9-15 20:20:3"));
//        user.setU_blinkerId(111);
//        System.out.println("insert:"+ UserDao.insert(user)+(byte)0x1f);



        System.out.println("start");
	}

}
