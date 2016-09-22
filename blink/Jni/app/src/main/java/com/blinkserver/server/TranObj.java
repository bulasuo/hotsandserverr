package com.blinkserver.server;

/**
 * Created by abu on 2016/8/31 15:32.
 * 传输协议的需要转成Json string格式的对象
 */
public class TranObj<T> {

    public String tag;//请求tag,客户端写的tag服务器会在回应报文的json里写相同的tag.来标示一问一答.(建议用时间值唯一标示)
    public int action;
    public int code;
    public String message;//当code不为200 即请求失败的时候,会在这里写异常信息
    public T obj;

    public TranObj(T obj){
        this.obj = obj;
    }


    public TranObj() {

    }

    /**
     * 传输协议: TranProtocol.TP_JSONSTR
     * @return
     */
    public TranProtocol formDefTranProtocol(){
        return new TranProtocol(TranProtocol.TP_JSONSTR, this);
    }
}
