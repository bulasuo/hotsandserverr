package com.blinkserver.server;

import com.blinkserver.util.XUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 写消息线程
 *
 * @author abu   2016/9/6   10:06
 */
public class OutputThread extends Thread {
    private DataOutputStream dos;
    private ArrayList<TranProtocol> tranProtocolList = new ArrayList<>();
    //考虑一下上面几个public成员会不会被多线程调用?  这里的几个public都没有被多线程调用先不同步了
    public boolean tryDestroy = false;
    public Socket socket;
    public Integer id;// TODO: 2016/9/18 当用户登录后要给id赋值
    public byte[] keyBytesAES;//AES口令bytes 用于加密数据
    public boolean isLogin = false;//记录用户是否有个人权限

    //短信验证码 和 短信验证码有效时间(ps: 注意这些状态值都会随着连接断开而丢失,即数据失效)
    public long sms_start = 0;
    public String checkCode;
    public String phone;


    public void tryDestroy() {
        tryDestroy = true;
        XUtil.closeDataOutputStream(dos);
        XUtil.closeSocket(socket);
        this.interrupt();
    }


    public OutputThread(Socket socket) {
        try {
            this.socket = socket;
            dos = new DataOutputStream(socket.getOutputStream());// 在构造器里面实例化对象输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(TranProtocol tranProtocol) {
        synchronized (this) {
            tranProtocolList.add(tranProtocol);
            this.notifyAll();//在拥有锁的前提下执行完synchronized语句块后<执行完就是释放了锁>,唤醒在此锁上睡眠的线程
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                synchronized (this) {
                    while(tranProtocolList.size() <= 0){
                        this.wait();//释放锁并且睡眠
                        if(isInterrupted() || socket.isClosed() || tryDestroy)
                            throw new Exception();
                    }
                    TranProtocol tranProtocol;
                    for(int i=0;i<tranProtocolList.size();i++){
                        tranProtocol = tranProtocolList.get(i);
                        if (keyBytesAES != null)
                            tranProtocol.keyBytesAES = this.keyBytesAES;
                        tranProtocol.sendData(dos);
                        dos.flush();
                        tranProtocolList.remove(tranProtocol);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            OutputThreadMap.remove(id, socket.getInetAddress().getHostAddress());
            XUtil.closeDataOutputStream(dos);
            XUtil.closeSocket(socket);
            System.out.println("out_shutdown");
        }
    }
}
