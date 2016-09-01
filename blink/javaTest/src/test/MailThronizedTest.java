package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.json.JSONObject;

public class MailThronizedTest {
	static MyThread thread00 = new MyThread();
	private static String encodeStr(String str){
        final int length = str.length();
        char[] c = str.toCharArray();
        return ""+(c[length - 4]*3+c[length - 4]*c[length - 6]*3);
    }
	public static class Say{
		int id = 1;
		private String content = "hello word";
		@Override
		public String toString() {
			return "Say [id=" + id + ", content=" + content + "]";
		}
		
		public void sayStr(String s){
			System.out.println("sayStr:"+s);
		}
		
	}
	
	public static class MyThread extends Thread{
		public  synchronized void m1(){
//			synchronized(this){
				for(int i=0;i<255;i++)
					for(int j=0;j<2550;j++)
							System.out.println("m1");
//			}
		}
		
		public synchronized void m2(){
//			synchronized(this){
			int s=0;
			for(int i=0;i<255;i++)
				for(int j=0;j<2550;j++)
			System.out.println("m2"+j);
//			}
		}
	

		public void run() {
			synchronized(this){
				
				
				int s=0;
				for(int i=0;i<255;i++)
					for(int j=0;j<25;j++)
				System.out.println("final"+j);
			}
			
		}
	}
	
	public static class MyThread2 extends Thread{
	
		
	
	

		public void run() {
			
			MyThread tt = new MyThread();
			thread00.m1();
			
		}
	}
	
	public static class MyThread3 extends Thread{
		
		
		
		

		public void run() {
			
			MyThread tt = new MyThread();
			thread00.m2();
			
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		System.out.println("start");
		
		
//		thread.m2();
		
		MyThread3 tt = new MyThread3();
		tt.start();
		
		MyThread2 t = new MyThread2();
		t.start();
		
		
		
		/*String BOUNDARY =  UUID.randomUUID().toString();
		System.out.println("::"+"--".length());
		System.out.println("::"+BOUNDARY.length());
		System.out.println("::"+"\r\n".length());
		System.out.println(BOUNDARY+"all::"+("--"+BOUNDARY+"\r\n").length());
		String s = "92c364bb-0de5-4e3f-8448-4c2e554b8b85all";
		String s1 = "92c364bb-0de5-4e3f-8448-4c2e554b8b85all";
		System.out.println(s.hashCode() == s1.hashCode());*/
		
//		Say say = new Say();
//		Class sayClass = say.getClass();
//		 Field[] fields = sayClass.getDeclaredFields(); //获取属性集合
//		 Object[] name = new Object[fields.length]; //存储变量名
//	        Object[] value = new Object[fields.length]; //存储变量值
//	        Object[] type = new Object[fields.length]; //存储变量类型
//		 for (int i = 0; i < fields.length; i++) { //设置数组的值
////			 fields[i].setAccessible(true);   
////			 name[i] = fields[i].getName();
////				value[i] = fields[i].get(say);
////	            type[i] = fields[i].getType();
////	            System.out.println(":"+name[i]+":"+value[i]+":"+type[i]);
//	        }
//		 System.out.println("0:"+say.toString());
//		 System.out.println("type:"+type[1]);
////		 value[1] = "xxx";
//		 Field field = sayClass.getDeclaredField("content");
//		 field.setAccessible(true);
//		 field.set(say, "小公举");
//		 System.out.println("22331:"+say.toString());
//		 Class<?> mmsayClass = Class.forName("test.Say0");
//		 mmsayClass.getDeclaredMethod("sayStr", String.class).invoke(mmsayClass.newInstance(), "hellow 小公举");
		
//		 String fileName = "crash-"  + "111112222-1470194984574"  + ".log";
//         fileName = encodeStr(fileName)+fileName;
//         System.out.println("fileName_"+fileName.substring(0, fileName.indexOf("crash"))+"**"+fileName.substring(fileName.indexOf("crash")));
//         
//         
//		
//		
//		String name = "ssscrash-1470194678422";
//		name.indexOf("crash");
//		System.out.println("name.indexOf);-"+name.indexOf("crash"));
//		System.out.println("name.indexOf);-"+name.substring(0, 3));
//		
//		
//		
//		Long l =System.currentTimeMillis();
//		String s = l.toString();
//		char[] c = s.toCharArray();
//		System.out.println(s+"l.byteValue()-"+(c[11]*3+c[11]*c[8]*3));
//		System.out.println("::"+"/	    Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename);  ".hashCode()+"-"+"sss".hashCode()+"-"+"".hashCode()+"-"+"ddd".hashCode());
		
//		s.getBytes().
		
//		String smtp = "smtp.qq.com";  
//	    String from = "bulasuo@foxmail.com";  
//	    String to = "bulasuo@foxmail.com";  
//	    String copyto = "bulasuo@foxmail.com";//"抄送人";  
//	    String subject = "邮件主题";  
//	    String content = "邮件内容";  
//	    String username="878309402";  
//	    String password="";  
//	    String filename = "E:\\mymanifest.mf";//"附件路径，如：F:\\笔记<a>\\struts2</a>与mvc.txt";  
//	    Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename); 
		
		/*String smtp = "smtp.qq.com";  
	    String from = "2431007646@qq.com";  
	    String to = "bulasuo@foxmail.com";  
	    String copyto = "bulasuo@foxmail.com";//"抄送人";  
	    String subject = "邮件主题";  
	    String content = "邮件内容";  
	    String username="2431007646";  
	    String password="axhcyvuavgeieccb";  
	    String filename = "E:\\mymanifest.mf";//"附件路径，如：F:\\笔记<a>\\struts2</a>与mvc.txt";  
	    Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename); */
		
//		String smtp = "smtp.qq.com";  
//	    String from = "1926196598@qq.com";  
//	    String to = "bulasuo@foxmail.com";  
//	    String copyto = "bulasuo@foxmail.com";//"抄送人";  
//	    String subject = "邮件主题";  
//	    String content = "邮件内容";  
//	    String username="1926196598";  
//	    String password="suladi@917802";  
//	    String filename = "E:\\mymanifest.mf";//"附件路径，如：F:\\笔记<a>\\struts2</a>与mvc.txt";  
//	    Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename); 
		
		
	    
//		String s = "ssjhlkjasdj";
//        String ss = "snbdfkj";
//        s = null;
//        try{
//
//        System.out.println("::"+s.indexOf("ww"));
//        }catch(Exception e){
//        	System.out.println("::"+e.toString());
//        }
//        
//        System.out.println("::11");
//        
//        
//		
//		JSONObject json = new JSONObject();
//		String s11 = "ss";
//		String ss11 = null;
//		if(!s11.equals(ss11))
//			System.out.println("inin"+json.toString()+"-");

        System.out.println("end");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
