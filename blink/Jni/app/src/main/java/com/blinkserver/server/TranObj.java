package com.blinkserver.server;

/**
 * Created by abu on 2016/8/31 15:32.
 */
public class TranObj<T> {


    private int code;
    private byte file;
    private T obj;

    public TranObj(T obj){
        this.obj = obj;
    }



}
