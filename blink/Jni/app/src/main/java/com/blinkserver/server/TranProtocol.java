package com.blinkserver.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blinkserver.security.SecurityHS;
import com.blinkserver.util.XUtil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.UUID;

/**
 * Created by abu on 2016/9/2 11:09.
 * 传输协议类,,可以根据此类封装传输data
 */
public class TranProtocol {
    public static final byte[] HEAD = "--".getBytes();
    public static final byte[] LINE = "\r\n".getBytes();
    public static final byte TP_JSONSTR = (byte)0x01;
    public static final byte TP_SSH = (byte)0xff;

    private byte protocolType;//协议类型
    private Key keyPublicRSA;//RSA公钥 用于给客户端
    public byte[] keyBytesAES;//AES口令bytes 用于加密数据

    private TranObj<JSONObject> tranObj;//传输数据格式,比如json

    private byte fileCounts = (byte)0x00;

    private String[] filePatch;

    public TranProtocol(byte protocolType, Key keyPublicRSA){
        this.protocolType = protocolType;
        this.keyPublicRSA = keyPublicRSA;
    }


    public void sendData(DataOutputStream dos) throws Exception {
        switch(protocolType) {
            case TP_JSONSTR:
                sendJsonStr(dos);
                break;
            case TP_SSH:
                sendRSAPublicKey(dos);
                break;
            default:
                break;


        }
    }

    public final void sendRSAPublicKey(DataOutputStream dos) throws Exception {
        final byte[] RSAPublicKeyBytes = keyPublicRSA.getEncoded();
        final byte[] boundaryBytes = UUID.randomUUID().toString().getBytes();
        dos.write(HEAD);
        dos.write(boundaryBytes);
        dos.write(LINE);
        //协议类型 0xff服务端给客户端的RSA公钥
        dos.write(TP_SSH);
        dos.write(XUtil.int2ByteArray(RSAPublicKeyBytes.length));
        dos.write(RSAPublicKeyBytes);
        dos.write(HEAD);
        dos.write(boundaryBytes);
        dos.write(HEAD);
        dos.write(LINE);
    }

    /**
     * 协议类型0x00:JsonStr 和 0个img 文件
     *
     * @param dos
     * @throws IOException
     */
    public final void sendJsonStr(DataOutputStream dos) throws Exception {
        if(keyBytesAES == null)
            return;
        final byte[] boundaryBytes = UUID.randomUUID().toString().getBytes();
        final byte[] jsonStrEncodeBytes
                = SecurityHS.AESEncode(JSON.toJSONString(tranObj).getBytes(), keyBytesAES);
        dos.write(HEAD);
        dos.write(boundaryBytes);
        dos.write(LINE);
        //协议类型 0x01
        dos.write(TP_JSONSTR);
        //jsonStr个数
        dos.write((byte) 0x01);
        //文件个数为0,
        dos.write((byte) 0x00);
        //jsonStr 长度,单位字节
        dos.write(XUtil.int2ByteArray(jsonStrEncodeBytes.length));
        //省略文件长度和文件
        dos.write(jsonStrEncodeBytes);
        dos.write(HEAD);
        dos.write(boundaryBytes);
        dos.write(HEAD);
        dos.write(LINE);
    }

}
