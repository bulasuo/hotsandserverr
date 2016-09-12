package com.blinkserver.server;


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
    private OutputThreadMap map;
    private DataOutputStream dos;
    private ArrayList<TranProtocol> tranProtocolList = new ArrayList<>();
    public boolean tryDestroy = false;
    private Socket socket;
    public byte[] keyBytesAES;//AES口令bytes 用于加密数据
    public boolean isLogin = false;//记录用户是否有个人权限

    public void tryDestroy() {
        try {
            tryDestroy = true;
            if (dos != null)
                dos.close();
            if (socket != null)
                socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public OutputThread(Socket socket, OutputThreadMap map) {
        try {
            this.socket = socket;
            this.map = map;
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
        try {
            while (true) {
                synchronized (this) {
                    while(tranProtocolList.size() <= 0){
                        this.wait();//释放锁并且睡眠
                        if(socket.isClosed() || tryDestroy)
                            tryDestroy();
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
            try {
                // TODO: 2016/9/5 map去除当前outStream
                // map.remove();
                if (dos != null)
                    dos.close();
                if (socket != null)
                    socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
