package com.blinkserver.server;

/**
 * Created by abu on 2016/8/31 15:32.
 * 传输协议的需要转成Json string格式的对象
 */
public class TranObj<T> {


    private int code;
    private T obj;

    public TranObj(T obj){
        this.obj = obj;
    }



}
