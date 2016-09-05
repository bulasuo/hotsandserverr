package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class test {
	public static String getEncode(String codeType, String content) {
	try {
		MessageDigest digest = MessageDigest.getInstance(codeType);// 获取一个实例，并传入加密方式
		digest.reset();// 清空一下
		digest.update(content.getBytes());// 写入内容,可以指定编码方式content.getBytes("utf-8");
		StringBuilder builder = new StringBuilder();
		for (byte b : digest.digest()) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}
		return builder.toString();
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return null;
}

	public static byte[] intToByteArray(int i) {
        byte[] r = new byte[4];
        r[0] = (byte) ((i >> 24) & 0xFF);
        r[1] = (byte) ((i >> 16) & 0xFF);
        r[2] = (byte) ((i >> 8) & 0xFF);
        r[3] = (byte) (i & 0xFF);
        return r;
    }

    public static int byteArray2Int(byte[] bytes) {
        return ((bytes[0] & 0xff) << 24) + ((bytes[1] & 0xff) << 16) + ((bytes[2] & 0xff) << 8) + (bytes[3] & 0xff);
    }
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*String text = "{\"name\":\"老张头\", \"age\":66}";
				  
		        *//** 将JSON字符串转换为JSON对象 **//*  
		        JSONObject json = JSON.parseObject(text);
		        System.out.println("::"+UUID.randomUUID().toString().getBytes().length);
		
		
		System.out.println(byteArray2Int((intToByteArray(29009))));*/
		/*int i =200;
		byte b = (byte)(i&0xff);
		byte bb = (byte)0xf;
		System.out.println(bb);*/
		
		/*String str = getEncode("MD5", System.currentTimeMillis()+"");// 用MD5方式加密
		System.out.println("MD5:"+str);*/
		
		
		/*int i = 0;
		for(;i<2;i++)
			System.out.println("mm");
//		byte b1 = (byte)11;
		byte b2 = (byte)0xa1;
		int bb = 161;
		System.out.println("::"+b2);
		
//		for(int i = 0;i<11;i++)
//			System.out.println(i);
		
		switch(b2){
		case 11:
			System.out.println("0xa1");
			break;
		case -95:
			System.out.println("0xa2");
			break;
		}*/
		
		
	}

}
