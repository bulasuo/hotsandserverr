package com.blinkserver.server;

import com.alibaba.fastjson.JSON;

/**
 * Created by abu on 2016/8/31 15:32.
 * 封装传输协议类
 * 0到1个string 和 0到n个文件
 * 服务端的图片发给客户端另开一个服务
 * 这里只传jsonStr给客户端
 */
public class TranObj {

    private static final String HEAD = "--";
    private static final String LINE = "\r\n";

    private String jsonStr;
    private JSON json;

    public TranObj(JSON json){
        this.json = json;
    }

   /**
     * 这个在outputThread里面写协议封装
     * @return
     */
   /*
   public byte[] getByteArray(){
       final String BOUNDARY =  UUID.randomUUID().toString();
       return (HEAD+BOUNDARY+LINE+json.toString()+)
   }*/

}
