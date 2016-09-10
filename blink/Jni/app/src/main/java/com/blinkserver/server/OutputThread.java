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
        synchronized (tranProtocolList) {
            tranProtocolList.add(tranProtocol);
            this.notifyAll();
        }
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed() && !tryDestroy) {
                synchronized (tranProtocolList) {
                    if (tranProtocolList.size() > 0) {
                        for (TranProtocol tranProtocol : tranProtocolList) {
                            if (keyBytesAES != null)
                                tranProtocol.keyBytesAES = this.keyBytesAES;
                            tranProtocol.sendData(dos);
                            dos.flush();
                            tranProtocolList.remove(tranProtocol);
                        }
                    }
                    this.wait();
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
