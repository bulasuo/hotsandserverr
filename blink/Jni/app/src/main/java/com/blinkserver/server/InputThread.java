package com.blinkserver.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blinkserver.Config;
import com.blinkserver.security.SecurityHS;
import com.blinkserver.util.XUtil;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    private DataInputStream dis;
    private FileOutputStream fos;
    private ArrayList<String> fileList;

    private Key keyPrivateRSA;//RSA公钥 用于给客户端
    private byte[] keyBytesAES;//AES口令bytes 用于加密数据

    private boolean tryDestroy = false;
    private static final int BUFFER_MAX_LENGTH = 1024;
    private static final int IMG_BUFF_MAX = 1024;


    private byte[] buffer = new byte[BUFFER_MAX_LENGTH];
    private int bufferIndex = 0;//buffer实际数据长度,也是实际数据最后一位索引加1

    
    private int readLength;

    public void tryDestroy(){
        tryDestroy = true;
        XUtil.closeFileOutputStream(fos);
        XUtil.closeDataInputStream(dis);
        XUtil.closeSocket(socket);
        this.interrupt();
    }


    public InputThread(Socket socket, OutputThread out, Key keyPrivateRSA) {
        this.socket = socket;
        this.out = out;
        this.keyPrivateRSA = keyPrivateRSA;
        try {
            dis = new DataInputStream(socket.getInputStream());// 实例化对象输入流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            while (!isInterrupted() && !socket.isClosed() && !tryDestroy) {
                readMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        } finally {
            out.tryDestroy = true;
            out.tryDestroy();
            out = null;
            XUtil.closeFileOutputStream(fos);
            XUtil.closeDataInputStream(dis);
            XUtil.closeSocket(socket);
            XUtil.deleteDir(fileList);
            System.out.println("in_shutdown");
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
                fos.write(imgBuf, 0, readl);
                fos.flush();
                if (length <= 0) {
                    fos.close();
                    return filePath;
                }
            }
            if(readl == -1){
                fos.close();
                throw new Exception();
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
            throw new Exception();
        while (!tryDestroy) {
            while ((readLength = dis.read(buffer, bufferIndex, length - bufferIndex)) > 0) {
                System.out.println("readLength:" + readLength);
                bufferIndex += readLength;
                if (bufferIndex >= length)
                    return;
            }
            if(readLength == -1)
                throw new Exception();
        }
    }

    /**
     * 把数据读到buffer
     *
     * @param buf
     * @param length 应该小于等于buf的长度
     */
    private void readDataIntoBuffer(byte[] buf, int length) throws Exception {
        int index = 0;
        int readl = 0;
        while (!tryDestroy) {
            while ((readl = dis.read(buf, index, length - index)) > 0) {
                System.out.println("readLength:" + readl);
                index += readl;
                if (index >= length)
                    return;
            }
            if(readl == -1)
                throw new Exception();
        }
    }

    /**
     * 读消息以及处理消息，抛出异常
     *
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
