package com.blinkserver;

/**
 * Created by abu on 2016/8/31 09:19.
 */
public class Config {

    public static final int SERVER_PORT = 8080;

    public static final int CLIENT_SERVER_PORT = 8081;
    public static final int CLIENT_FILE_TRANSPORT_PORT = 8082;
    public static final int REGISTER_FAIL = 0;

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/blink?useUnicode=true&characterEncoding=utf-8";
    public static final String MYSQL_USER_NAME = "root";
    public static final String MYSQL_PASSWORD = "bulasuo@0220";

    //包含了接口key和短信模板id
    public static final String SMS_API_URL = "http://apis.haoservice.com/sms/send?key=55e358f3198e46a4840c02f10fd4cb6d&tpl_id=1975";

    public static final String IMG_PATH = "D:/img/";

}
