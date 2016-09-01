package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StreamTest {
	
	public final static byte[] hex = "0123456789ABCDEF".getBytes();

	public static String Bytes2HexString(byte[] bb)
	{
		int i,len;
		len=bb.length;
		byte[] b=new byte[len];
		for (i=0;i<len;i++)
			b[i]=bb[len-i-1];

		byte[] buff = new byte[2 * b.length];

		for ( i = 0; i < b.length; i++) {

			buff[2 * i] = hex[(b[b.length - i - 1] >> 4) & 0x0f];
			buff[2 * i + 1] = hex[b[b.length - i - 1] & 0x0f];
		}
		return new String(buff);
	}
	public static byte[] string2bytes(String s){
		String ss = s.replace(" ", "");
		int string_len = ss.length();
		int len = string_len/2;
		if(string_len%2 ==1){
			ss = "0"+ss;
			string_len++;
			len++;
		}
		byte[] a = new byte[len];
		for(int i=0;i<len;i++){
			a[i] = (byte)Integer.parseInt(ss.substring(2*i,2*i+2), 16);
		}
		return a;
	}
	
	static class Student {
		String name;
		int age;
		public Student(String s, int a){
			name = s;age = a;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	public static void main(String[] args) {
//		Student s1 = new Student("bulasuo", 23);
//		Student s2 = new Student("bulasuo", 23);
//		s2 = s1;s2.setAge(11);
//		
//		System.out.println("::"+s1.equals(s2)+"--"+(s1.hashCode()== s2.hashCode())+"--"+(s1==s2));
//		
//		ArrayList<String> s = new ArrayList<String>();
//		s.add("ss");
//		s.add("abu");
//		s.add("ss");
////		s.remove("ss");
//		s.remove("kk");
//		System.out.println(":"+s.indexOf("ss"));
		System.out.println("start");
		File file = new File("D:/myapk");
		HttpURLConnection urlConnection = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		if(!file.exists())
			file.mkdirs();
		File apkFile = new File(file, "artcmHtml.apk");
		if(!apkFile.exists()){
			try {
				apkFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(apkFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			final URL url = new URL("http://apk.r1.market.hiapk.com/data/upload/marketClient/HiMarket7.1.0.81_1464768459094.apk");
			urlConnection = (HttpURLConnection) url.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream(), 8 * 1024);
			out = new BufferedOutputStream(outputStream, 8 * 1024);
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			out.flush();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
//		
		System.out.println("end");
	}
	
}
