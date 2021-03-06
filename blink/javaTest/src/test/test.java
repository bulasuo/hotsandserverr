package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    
    public static test instance;
    
	public static test getInstance(String s){
		synchronized (instance) {
			if(instance == null)
				instance = new test();
			
			System.out.println(s);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return instance;
		}
	}
	
	public static class MyThread extends Thread{
		
		
		@Override
		public void run() {
			super.run();
			
			for(int i = 0;i<5;i++){
				getInstance("aaaT");
			}
		}
	}
	
public static class MyThread1 extends Thread{
		
		
		@Override
		public void run() {
			super.run();
			
			for(int i = 0;i<5;i++){
				getInstance("bbbT");
			}
		}
	}

    private static void f0(String s){
    	try{
    		f1(s);
    	}catch(Exception e){}
    }
    
    private static void f1(String s){
    	if(s == null)
    		throw new IllegalArgumentException("null");
    	System.out.println("f1_end");
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ArrayList<String> list = new ArrayList<String>();
		list.add(null);
		list.add("sss");
		System.out.println("::"+list.toString());
		/*Integer i = null;
		double d = Math.random();
		System.out.println("::"+d+"-"+(int)(d * 1000000));*/
		
		/*final JSONObject json = new JSONObject();
        json.put("ActionInterface.KEY.ACTION", 11);
        json.put("ActionInterface.KEY.TAG", "获取短信验证码");
        System.out.println(":--:"+json.getInteger("ActionInterface.KEY.ACTION"));*/
		
		
		/*f0(null);
		System.out.println("all_end");*/
		
		System.out.println("f8d8d9c653b55175c1aee2ef1a01616297b2a00cc58e47b99b5303ae4dbe67a6d9f60577ecfd8313fe17545bd696e1819302612fd9475c2d6e13b1473801293dc5fea865f8903ec4924fe0f09270c87d"
				   .equals("f8d8d9c653b55175c1aee2ef1a01616297b2a00cc58e47b99b5303ae4dbe67a6d9f60577ecfd8313fe17545bd696e1819302612fd9475c2d6e13b1473801293dc5fea865f8903ec4924fe0f09270c87d"));
		
		
		/*Socket socket = new Socket();
		try {
//			socket.close();
			socket.connect(new InetSocketAddress("192.168.1.1", 8080), 1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("::"+socket.isClosed());*/
		
		/*int i = 0x100001;
		System.out.println("::"+i);
		byte bb = (byte)200 ;
		System.out.println("bb::"+bb);*/
		
		/*JSONObject json = new JSONObject();
		json.put("111", "111");
		System.out.println("::"+json.getIntValue("22"));*/
		
		/*String text = "{\"name\":\"老张头\", \"age\":66}";
				  
		        JSONObject json = JSON.parseObject(text);
		        System.out.println("::"+json.toJSONString()+"\n"+(System.currentTimeMillis()+"").length());
		
		
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
