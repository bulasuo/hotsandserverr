package com.EnvironmentalMonitoring.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.*;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import StringUtil.myStringUtil;

import com.EnvironmentalMonitoring.bin.User;
import com.EnvironmentalMonitoring.dao.DatabaseUtil;
import com.mrwujay.cascade.model.citys;


public class myListener implements ServletContextListener {
	//依次为甲醛、PM2.5、CO2、光照、温度、声音
    public static float c00 =0;
	public static float c01=0;
	public static float c02=0;
	public static float c03=0;
	public static float c04=0; 
    public static String c05="无";
    public static byte currentValue[] = new byte[51];
	private ServerSocket serverSocket = null;
	private ServerSocket gatewayserverSocket = null;
	private Socket clientSocket = null;
	private Socket gatewaySocket = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("listenerStart");
		try {
			serverSocket = new ServerSocket(8010,100);
			gatewayserverSocket = new ServerSocket(8011,100);
		} catch (IOException e) {
			System.out.println(":IOException01!");
			e.printStackTrace();
		}
		//新开一个线程，socket长链接用于web服务器和网关通信
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true)
				{
				try {
					gatewaySocket = gatewayserverSocket.accept();
//					System.out.println("port:8011");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				System.out.println("accept_one_gatewaysocket");
					new Thread(new Runnable(){

						@Override
						public void run() {
							Socket gatewaycurrentsocket = gatewaySocket;
							BufferedReader reader=null;
							try {
								reader = new BufferedReader(new InputStreamReader(gatewaycurrentsocket.getInputStream(),"utf-8"));
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
					while(gatewaycurrentsocket.isConnected()&&!gatewaycurrentsocket.isClosed()&&gatewaycurrentsocket!=null){
						try{
							
						    String text = reader.readLine();
						    if(text==null) return;
							JSONObject json = new JSONObject(text);
							String flag = json.getString("flag");
//							System.out.println("flag:"+flag); 
				//			System.out.println("text.length():"+text.length());
							
if("currentValue".equals(flag)){
	     
		gatewaySocket = gatewaycurrentsocket;//因为网关没有固定ip，记下当前网关Socket，用于web服务器对他的请求。
		if(text.length()!=143){continue;}//(这里一定要注意continue和break的区别！！)这里叫做防断流判断，断流导致数据错误，而导致当前处理体出错
        currentValue =myStringUtil.string2bytes(json.getString("currentValue"));
//        System.out.println("byte[] currentValue:"+myStringUtil.Bytes2HexString(currentValue));
      //6个传感器当前值转换：
//        c00 = (currentValue[3]&0xff)*256+(currentValue[4]&0xff);//甲醛
        c00 = 19;//甲醛
        c01 = (currentValue[5]&0xff)*256+(currentValue[6]&0xff);//PM2.5   
        c02 = (float) (((currentValue[7]&0xff)*256+(currentValue[8]&0xff))*0.0001);//co2
            c02 = new BigDecimal((float)c02).setScale(2, 4).floatValue(); //保留2位小数，四舍五入
        c03 = (currentValue[9]&0xff)*256+(currentValue[10]&0xff);//光照
        c04 = (currentValue[11]&0xff)*256+(currentValue[12]&0xff);
            c04 = (float) (c04<2000?c04*0.1:65536-c04);//温度
        c05 = ((currentValue[13]&0xff)*256+(currentValue[14]&0xff))==1?"有":"无";//声音	
        
}
                        
						} catch (IOException e) {
							System.out.println("IOException033");
							try {
								gatewaycurrentsocket.close();
								break;
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
						}
					
					try {
						reader.close();
						gatewaycurrentsocket.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
						}	
						
					}).start();
				}
			}
			
			
		}).start();
		
		
		
		
		
		//新开一个线程池（100），socket短链接，用于移动端的请求
	for(int i=0;i<100;i++){
		new Thread(new Runnable()
		{
			public void run()
			{
				while(true)
				{	
					try {
						clientSocket = serverSocket.accept();
					} catch (IOException e) {
						System.out.println(":IOException02!");
						e.printStackTrace();
					}
					System.out.println("accept_one_socket");
					//当有一个Socket客户端来 就开启一个线程处理这个客户端的请求
//					new Thread(new Runnable()
//					{
//						@Override
//						public void run() { 
					Socket currentSocket =null;
					BufferedReader reader = null;
							try {
								currentSocket = clientSocket;
								reader=new BufferedReader(new InputStreamReader(currentSocket.getInputStream(),"utf-8"));
								String text = reader.readLine();
								JSONObject json = new JSONObject(text);
								JSONObject send_json =new JSONObject();
								String flag = json.getString("flag");
								System.out.println("flag:"+flag);
								
	 if("ss".equals(flag)){
		 currentValue[4]=0x13;
		currentSocket.getOutputStream().write(currentValue);
//		System.out.println("ip:");
//		System.out.println(currentSocket.getInetAddress());
//		System.out.println(currentSocket.getLocalAddress());
	}else if("switch00".equals(flag)){
		controlDevice(flag);
	}else if("switch01".equals(flag)){
		controlDevice(flag);	
	}else if("switch10".equals(flag)){
		controlDevice(flag);
	}else if("switch11".equals(flag)){
		controlDevice(flag);	
	}else if("switch20".equals(flag)){
		controlDevice(flag);		
	}else if("switch21".equals(flag)){
		controlDevice(flag);		
	}else if("switch30".equals(flag)){
		controlDevice(flag);	
		System.out.println("send_end1");
	}else if("switch31".equals(flag)){
		controlDevice(flag);
		System.out.println("send_end2");
	}else if("regist".equals(flag)){
		//注册 成功返回success 否则 false
		System.out.println("user_name"+json.getString("user_name"));
		System.out.println("user_phone"+json.getString("user_phone"));
		if((DatabaseUtil.queryUser(json.getString("user_name"))==null)&&
				(DatabaseUtil.queryUserbyphone(json.getString("user_phone"))==null)){
		User re_user = new User( 1, json.getString("user_name"), json.getString("user_phone"), "1", json.getString("user_password"), "");
		DatabaseUtil.insert(re_user);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
		writer.write("success\n");//写入信息
		System.out.println("regist_success");
		writer.flush();
		}else{
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
			writer.write("false\n");//写入信息
			writer.flush();
			System.out.println("regist_false");     							
		}
	}else if("login".equals(flag)){
		String login_password=json.getString("user_password");
		User query_user=DatabaseUtil.queryUser(json.getString("user_name"));
		if((query_user!=null)&&(login_password.equals(query_user.getPassword()))){
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
			writer.write("success\n");//写入信息
			writer.flush();
			System.out.println("login_success");
		}else{
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
			writer.write("false\n");//写入信息
			writer.flush(); 
			System.out.println("login_false");
		}
	}else if("reset".equals(flag)){
			String reset_phone = json.getString("user_phone");
			if(DatabaseUtil.queryUserbyphone(reset_phone)!=null){
//			if(true){//
				int reset_code = -1;
				reset_code = sendsms.sendShortMessage(reset_phone);
					User reset_user=DatabaseUtil.queryUserbyphone(reset_phone);
					send_json.put("user_name",reset_user.getName());
					
					//暂时改一下
					send_json.put("user_code", reset_code);
//					send_json.put("user_code", 1234);
					
					if(reset_code>=0){
						send_json.put("isok", "success");
						}else{send_json.put("isok", "false");}
					String send_txt = send_json.toString();
					BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
		    		writer.write(send_txt+"\n");//写入信息
		    		writer.flush();
			}else{
			send_json.put("isok", "false");
			String send_txt = send_json.toString();
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
			writer.write(send_txt+"\n");//写入信息
			writer.flush();
			}
	}else if("update".equals(flag)){
			User update_user = new User( -1, json.getString("user_name"), json.getString("user_phone"), "1", json.getString("user_password"), "");
			DatabaseUtil.UserUpdate(update_user);
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream()));//创建输出流
			writer.write("success\n");//写入信息
			writer.flush();
	}else if("getCityWeather".equals(flag)){
//		new Thread (new Runnable(){
//
//			@Override
//			public void run() {
				try{
					String s="南京";
					HttpPost httpPost=new HttpPost( "http://apix.sinaapp.com/weather/?appkey=bulasuo&city="+s);
					HttpClient httpClient=new DefaultHttpClient();
					HttpResponse httpResponse=httpClient.execute(httpPost);
					if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
						HttpEntity entity = httpResponse.getEntity();
						String response_string = EntityUtils.toString(entity,  
								"utf-8");	
						JSONArray json1=new  JSONArray(response_string); 
						System.out.println("tostring:"+json1.toString());
						System.out.println("suggest0:"+(((JSONObject) json1.get(2))).getString("Title"));
						System.out.println("title0"+(((JSONObject) json1.get(3))).getString("Title"));
						System.out.println("picurl0"+(((JSONObject) json1.get(3))).getString("PicUrl"));
						System.out.println("title1"+(((JSONObject) json1.get(4))).getString("Title"));
						System.out.println("picurl1"+(((JSONObject) json1.get(4))).getString("PicUrl"));
						System.out.println("title2"+(((JSONObject) json1.get(5))).getString("Title"));
						System.out.println("picurl2"+(((JSONObject) json1.get(5))).getString("PicUrl"));
						
						

						}
					}catch(Exception e){
						System.out.println(e.toString());
						e.printStackTrace();
						
					}
				
//			}
//			
//			
//		}).start();
	}else if("weather_login".equals(flag)){
		ArrayList<String> mylist = new ArrayList<String>();
		ArrayList<String> citylist =new ArrayList<String>();
		ArrayList<citys> weatherlist = new ArrayList<citys>();
		ArrayList<Future<citys>> list_future = new ArrayList<Future<citys>>();
		mylist.add("北京");
		mylist.add("南京");
		mylist.add("上海");
		mylist.add("深圳");
		mylist.add("贵阳");
		mylist.add("哈尔滨");
		String userPhone = json.getString("user_phone");	
		citylist = DatabaseUtil.queryCityWeather(userPhone);
		//用户不存在就注册用户
		if(citylist.size()==0){
			DatabaseUtil.saveCityWeather(userPhone, mylist);
			citylist=mylist;
		}
		//////////////////////////////////////////////
		ExecutorService exec = Executors.newCachedThreadPool();	
		for(int i=0;i<citylist.size();i++)
		{
		System.out.println("***");
		list_future.add(i,(Future)exec.submit(new Task_getWeather(citylist.get(i))));
		}
		//////////////////////////////////////////////////////
		for(int i=0;i<citylist.size();i++){			
		citys c = (citys)(list_future.get(i).get());			
		if(c!=null){
		System.out.println("ok:"+c.getSuggest_0());
		weatherlist.add(c);}}
		//////////////////////////////////////////////////////////////
	
		
		if(weatherlist!=null){
			ObjectOutputStream ois = new ObjectOutputStream(currentSocket.getOutputStream());
			ois.writeObject(weatherlist);
			ois.flush();		
		}
	}else if("weather_update".equals(flag)){
		ArrayList<String> mylist = new ArrayList<String>();
		ArrayList<citys> weatherlist = new ArrayList<citys>();
		ArrayList<Future<citys>> list_future = new ArrayList<Future<citys>>();	
		
		mylist = (ArrayList<String>) myObjectReceive(currentSocket);
		String user_phone = json.getString("user_phone");
		System.out.println("mylist:"+mylist.toString());
		//////////////////////////////////////////////
		ExecutorService exec = Executors.newCachedThreadPool();	
		for(int i=0;i<mylist.size();i++)
		{
			System.out.println("***");
			list_future.add(i,(Future)exec.submit(new Task_getWeather(mylist.get(i))));
		}
		//////////////////////////////////////////////////////
		for(int i=0;i<mylist.size();i++){			
			citys c = (citys)(list_future.get(i).get());			
			if(c!=null){
			System.out.println("ok:"+c.getSuggest_0());
			weatherlist.add(c);
			}else {
				weatherlist.clear();
				citys c1 = new citys();
				c1.setCityName(mylist.get(i));
				c1.setSuggest_0("error");
				weatherlist.add(c1);
				System.out.println("weatherList:"+weatherlist.get(0).toString());
				myObjectSend(weatherlist,currentSocket);
				reader.close();
				currentSocket.close();
				return;
			}	
		}
		myObjectSend(weatherlist,currentSocket);
		DatabaseUtil.saveCityWeather(user_phone, mylist);
		
	}else if("myTest".equals(flag)){
		System.out.println("myTest::");
		User user =new User();
		user.setClass_id(99);
		user.setEmail("15062239769@@@");
		user.setName("suladi");
		DatabaseUtil.insert(user);
		System.out.println("user.toString:"+user.toString());
		
	}else if("weather_update_o".equals(flag)){
		ArrayList<String> mylist = new ArrayList<String>();
		ArrayList<Future<citys>> list_future = new ArrayList<Future<citys>>();
		ArrayList<citys> weatherlist = new ArrayList<citys>();		
		mylist = (ArrayList<String>) myObjectReceive(currentSocket);
//		System.out.println("mylist:"+mylist.toString());
		//////////////////////////////////////////////
		ExecutorService exec = Executors.newCachedThreadPool();	
		for(int i=0;i<mylist.size();i++)
		{
		System.out.println("***");
		list_future.add(i,(Future)exec.submit(new Task_getWeather(mylist.get(i))));
		}
		//////////////////////////////////////////////////////
		for(int i=0;i<mylist.size();i++){			
		citys c = (citys)(list_future.get(i).get());			
			if(c!=null){
			System.out.println("ok:"+c.getSuggest_0());
			weatherlist.add(c);
			}else {
				weatherlist.clear();
				citys c1 = new citys();
				c1.setCityName(mylist.get(i));
				c1.setSuggest_0("error");
				weatherlist.add(c1);
				
				myObjectSend(weatherlist,currentSocket);
				reader.close();
				currentSocket.close();
				return;
			}	
		}
		myObjectSend(weatherlist,currentSocket);
		System.out.println("::"+weatherlist.get(0).toString());
		
	}else if("weather_city_delete".equals(flag)){
		//写一个删除dao  返回success  dao返回数字
		String userPhone = json.getString("user_phone");
		String cityName = json.getString("cityName");
		System.out.println("delete?:"+cityName+"\nuserPhone"+userPhone);
		int ps = DatabaseUtil.weather_delete(userPhone,cityName);
		JSONObject json_d = new JSONObject();
		if(ps>0){
			json_d.put("result", "success");
		}else{
			json_d.put("result", "fail");
		}
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(currentSocket.getOutputStream(),"utf-8"));//创建输出流	
		writer.write(json_d.toString()+"\n");//写入信息
		writer.flush();
	}
					
					
								reader.close();
								currentSocket.close();
							} catch (IOException e) {
								e.printStackTrace();
								System.out.println("IOException003");
//								try {
//									reader.close();
//									currentSocket.close();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								
//								continue;
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ExecutionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("currentSocketEnd");
//						} 
//
//						
//					}).start();
					System.out.println("begin_one_Socket_thread");
					
				}
				
			}
			
		}).start();
		System.out.println("ok，servletListenerEnd");
	}
	}
	private void controlDevice(String flag) throws JSONException, IOException {
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(gatewaySocket.getOutputStream(),"utf-8"));//创建输出流
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		writer.write(json.toString()+"\n");//写入信息
		writer.flush();
		System.out.println("send_com");
	}	
	//用于加载每个城市的天气，这些加载是异步加载的
	class Task_getWeather implements Callable<citys>
	{
		private String cityName=null;
		public Task_getWeather(String cityName)
		{
			this.cityName=cityName;
		}

		@Override
		public citys call() throws Exception {		
			return getWeatherByCity(cityName);
		}
		
	}
	
	public static String getWeatherByCity_test(String cityName){
		citys city = new citys();
		try{
			
			HttpPost httpPost=new HttpPost( "http://apix.sinaapp.com/weather/?appkey=bulasuo&city="+cityName);
			HttpClient httpClient=new DefaultHttpClient();
			HttpResponse httpResponse=httpClient.execute(httpPost);
			if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				HttpEntity entity = httpResponse.getEntity();
				String response_string = EntityUtils.toString(entity,  
						"utf-8");	
				if(response_string.length()<10){
					return null;
				}
				JSONArray json1=new  JSONArray(response_string); 
				
				city.setCityName(cityName);
				city.setSuggest_0((((JSONObject) json1.get(2))).getString("Title"));
				city.setTitle_0((((JSONObject) json1.get(3))).getString("Title"));
				city.setPicUrl_0((((JSONObject) json1.get(3))).getString("PicUrl"));
				city.setTitle_1((((JSONObject) json1.get(4))).getString("Title"));
				city.setPicUrl_1((((JSONObject) json1.get(4))).getString("PicUrl"));
				city.setTitle_2((((JSONObject) json1.get(5))).getString("Title"));
				city.setPicUrl_2((((JSONObject) json1.get(5))).getString("PicUrl"));

				}
			}catch(Exception e){
				System.out.println(e.toString());
				e.printStackTrace();
				
			}
		return city.getSuggest_0();
	}
	
	public static citys getWeatherByCity(String cityName){
		citys city = new citys();
		try{
			
			HttpPost httpPost=new HttpPost( "http://apix.sinaapp.com/weather/?appkey=bulasuo&city="+cityName);
			HttpClient httpClient=new DefaultHttpClient();
			HttpResponse httpResponse=httpClient.execute(httpPost);
	//		Thread.yield(); //同优先级的线程之间对cpu资源的让步 
			if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				HttpEntity entity = httpResponse.getEntity();
				String response_string = EntityUtils.toString(entity,  
						"utf-8");	
				if(response_string.length()<10){
					return null;
				}
				JSONArray json1=new  JSONArray(response_string); 
				
				city.setCityName(cityName);
				city.setSuggest_0((((JSONObject) json1.get(2))).getString("Title"));
				city.setTitle_0((((JSONObject) json1.get(3))).getString("Title"));
				city.setPicUrl_0((((JSONObject) json1.get(3))).getString("PicUrl"));
				city.setTitle_1((((JSONObject) json1.get(4))).getString("Title"));
				city.setPicUrl_1((((JSONObject) json1.get(4))).getString("PicUrl"));
				city.setTitle_2((((JSONObject) json1.get(5))).getString("Title"));
				city.setPicUrl_2((((JSONObject) json1.get(5))).getString("PicUrl"));

				}
			}catch(Exception e){
				System.out.println(e.toString());
				e.printStackTrace();
				
			}
		return city;
	}
	
	public void myObjectSend(Object o,Socket socket) throws IOException{
		ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream());
		ois.writeObject(o);
		ois.flush();
	}
	
	public static Object myObjectReceive(Socket socket) throws OptionalDataException, ClassNotFoundException, IOException{
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		return (ArrayList<Object>) ois.readObject();
	}
	
}
