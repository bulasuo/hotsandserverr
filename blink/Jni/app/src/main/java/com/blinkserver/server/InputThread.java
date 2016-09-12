package com.blinkserver.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blinkserver.Config;
import com.blinkserver.security.SecurityHS;
import com.blinkserver.util.XUtil;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Key;
import java.util.ArrayList;


/**
 * 读消息线程和处理方法
 *@author   abu   2016/9/6   10:06
 */
public class InputThread extends Thread {
    private Socket socket;
    private OutputThread out;
    private OutputThreadMap map;
    private DataInputStream dis;
    private FileOutputStream fos;//图片写出流
    private ArrayList<String> fileList;

    private Key keyPrivateRSA;//RSA公钥 用于给客户端
    private byte[] keyBytesAES;//AES口令bytes 用于加密数据

    private boolean tryDestroy = false;
    private static final int BUFFER_MAX_LENGTH = 1024;

    private byte[] buffer = new byte[BUFFER_MAX_LENGTH];
    private int bufferIndex = 0;//buffer实际数据长度,也是实际数据最后一位索引加1


    private int readLength;

    public void tryDestroy(){
        try {
            tryDestroy = true;
            if (fos != null)
                fos.close();
            if (dis != null)
                dis.close();
            if (socket != null)
                socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public InputThread(Socket socket, OutputThread out, OutputThreadMap map, Key keyPrivateRSA) {
        this.socket = socket;
        this.out = out;
        this.map = map;
        this.keyPrivateRSA = keyPrivateRSA;
        try {
            dis = new DataInputStream(socket.getInputStream());// 实例化对象输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed() && !tryDestroy) {
                // TODO: 2016/9/5 心跳包
                //增加一个5分钟没有连接就断开 防止客户端意外断开
                readMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        } finally {
            try {
                out.tryDestroy = true;
                out.tryDestroy();
                out = null;
                if (fos != null)
                    fos.close();
                if (dis != null)
                    dis.close();
                if (socket != null)
                    socket.close();
                if(fileList != null)
                    XUtil.deleteDir(fileList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解析协议类型
     *
     * @param type 第41个字节
     */
    private void goProtocolType(byte type) throws Exception {
        switch (type) {
            case (byte) 0x01:
                if (keyBytesAES == null) {
                    stopConnect();
                    return;
                }
                readData(bufferIndex + 2);
                final int fileCount = buffer[42] & 0xff;
                readData(bufferIndex + 4 + fileCount * 4);
                JSONObject json = readJson(XUtil.byteArray2Int(buffer, 43));
                // TODO: 2016/9/5 先根据json看用户有权限传图片吗
                //如果用户没权限传图片stop连接并且return;

                fileList = new ArrayList<>();
                for (int i = 0; i < fileCount; i++)
                    fileList.add(readImg(XUtil.byteArray2Int(buffer, 47 + i * 4), fileList));
                if (isPackLegal()) {
                    // TODO: 2016/9/5  如果合法则进行接下来的json功能逻辑
                    //json
                    System.out.println("jsonStr:"+json.toJSONString());
                } else {
                    stopConnect();
                }
                break;
            case (byte) 0xff:
                readData(bufferIndex + 4);
                this.keyBytesAES = readAESKey(XUtil.byteArray2Int(buffer, bufferIndex - 4));
                if(isPackLegal()){
                    //AESKeyBytes
                    System.out.println("AESKey:"+XUtil.bytes2HexString(keyBytesAES));
                    out.keyBytesAES = this.keyBytesAES;
                } else {
                    this.keyBytesAES = null;
                    stopConnect();
                }
                break;
        }
    }

    /**
     * 判断数据包是否合法
     *
     * @return
     */
    private boolean isPackLegal() throws Exception {
        readData(bufferIndex + 42);
        if (buffer[bufferIndex - 1] == TranProtocol.LINE[1]
                && buffer[bufferIndex - 2] == TranProtocol.LINE[0]
                && buffer[bufferIndex - 3] == TranProtocol.HEAD[0]
                && buffer[bufferIndex - 4] == TranProtocol.HEAD[0]
                && XUtil.isBytesEqual(buffer, bufferIndex - 40, buffer, 2, 36)
                && buffer[bufferIndex - 41] == TranProtocol.HEAD[0]
                && buffer[bufferIndex - 42] == TranProtocol.HEAD[0])
            return true;
        return false;
    }

    /**
     * use when bufferIndex指向AESKey第一个字节
     *@author   abu   2016/9/5   14:53
     */
    private byte[] readAESKey(int length) throws Exception {
        byte[] temp = new byte[length];
        readDataIntoBuffer(temp, length);
        System.out.println("\nreadAES:"+temp.length+"-"+XUtil.bytes2HexString(temp));
        return SecurityHS.RSADecode(temp, keyPrivateRSA);
    }

    /**
     * use when bufferIndex指向json断第一个字节
     *@author   abu   2016/9/5   14:49
     */
    private JSONObject readJson(int length) throws Exception {
        byte[] jsonBytes = new byte[length];
        readDataIntoBuffer(jsonBytes, length);
        return JSON.parseObject(new String(SecurityHS.AESDecode(jsonBytes, keyBytesAES)));
    }

    /**
     * use when bufferIndex指向img第一个字节
     *@author   abu   2016/9/5   14:50
     */
    private String readImg(int length, ArrayList<String> fileList) throws Exception {
        final int IMG_BUFF_MAX = 1024;
        byte[] imgBuf = new byte[IMG_BUFF_MAX];
        final String filePath = Config.IMG_PATH + SecurityHS.MD5Encode(System.currentTimeMillis() + "");
        fos = new FileOutputStream(new File(filePath));

        int max = 0;
        int readl = 0;
        while (!tryDestroy) {

            if (length >= IMG_BUFF_MAX)
                max = IMG_BUFF_MAX;
            else
                max = length;
            while ((readl = dis.read(imgBuf, 0, max)) > 0) {
                length -= readl;
                System.out.println("readLength:" + readl);
                if(readl == -1){
                    fos.close();
                    throw new IOException();
                }
                fos.write(imgBuf, 0, readl);
                fos.flush();
                if (length <= 0) {
                    fos.close();
                    return filePath;
                }
            }
        }
        return null;
    }

    /**
     * 读取数据到buffer 到buffer长度为length
     *
     * @param length 应该小于等于BUFFER_MAX_LENGTH
     * @throws Exception
     */
    private void readData(int length) throws Exception {
        if (bufferIndex >= length || length > BUFFER_MAX_LENGTH)
            return;
        while (!tryDestroy) {
            while ((readLength = dis.read(buffer, bufferIndex, length - bufferIndex)) > 0) {
                System.out.println("readLength:" + readLength);
                if(readLength == -1)
                    throw new IOException();
                bufferIndex += readLength;
                if (bufferIndex >= length)
                    return;
            }
        }
    }

    /**
     * 把数据读到buffer
     *
     * @param buf
     * @param length 应该小于等于buf的长度
     * @throws IOException
     */
    private void readDataIntoBuffer(byte[] buf, int length) throws Exception {
        int index = 0;
        int readl = 0;
        while (!tryDestroy) {
            while ((readl = dis.read(buf, index, length - index)) > 0) {
                System.out.println("readLength:" + readl);
                if(readl == -1)
                    throw new IOException();
                index += readl;
                if (index >= length)
                    return;
            }
        }
    }

    /**
     * 读消息以及处理消息，抛出异常
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readMessage() throws Exception {
        bufferIndex = 0;//准备读一个完整的包,先指针初始化
        readData(41);//至少读到41个字节
        if (buffer[0] == TranProtocol.HEAD[0] && buffer[1] == TranProtocol.HEAD[0]
                && buffer[38] == TranProtocol.LINE[0] && buffer[39] == TranProtocol.LINE[1]) {
            goProtocolType(buffer[40]);//当有包头后进入协议类型解析
        } else {
            //不是包头,数据错误 断开等待重连
            stopConnect();
        }

    }

    /**
     * 数据协议错误,没有经过三次握手就传数据, 则断开连接
     *@author   abu   2016/9/5   15:15
     */
    private void stopConnect() throws Exception {
        throw new Exception();
    }
}
