/**
 * 
 */
package com.EnvironmentalMonitoring.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.EnvironmentalMonitoring.bin.User;
import com.EnvironmentalMonitoring.dao.DatabaseUtil;
import com.EnvironmentalMonitoring.listener.myListener;

import com.mrwujay.cascade.model.citys;

import StringUtil.myStringUtil;





/**
 * @author admin
 *
 */
public class myServlet extends HttpServlet {
	
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("************bulasuo&&suladi***********************");
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String submit_type=req.getParameter("submit");
		System.out.println("submit="+submit_type);
			if(submit_type.equals("login")){
				//System.out.println("************bulasuo****************************");
				String user_name=(String)req.getParameter("user_name");
				String user_password=(String)req.getParameter("user_password");
				//System.out.println("user_name="+user_name);
				//System.out.println("user_password="+user_password);
				if(user_name.equals("admin")&&user_password.equals("123")){
					
					//跳转到实时显示servlet
//					req.getRequestDispatcher("/myServlet?submit=monitor").forward(req, resp);
//					req.setAttribute("c00", c00);
//					req.setAttribute("c01", c01);
//					req.setAttribute("c02", c02);
//					req.setAttribute("c03", c03);
//					req.setAttribute("c04", c04);
//					req.setAttribute("c05", c05);
					req.getRequestDispatcher("monitor.jsp").forward(req, resp);
				}else{
					req.setAttribute("sure", "用户名错误或密码错误！");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					
				}

			}else
				if(submit_type.equals("monitor")){
					
//					session.setAttribute("jiaquan", jiaquan);
//					resp.sendRedirect("monitor.jsp");
//				//	req.getRequestDispatcher("monitor.jsp").forward(req, resp);
					PrintWriter out=resp.getWriter();
					String str_html="<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>甲醛：</p1>" +
							"<p1 style=' font-size:15px;'>&nbsp;&nbsp;&nbsp;"+myListener.c00+"</p1> " +
							"<p1 style=' font-size:15px;align:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;阀值：0.0~67.0（ppb）</p1></div>"+
							
							"<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>PM2.5：</p1>" +
							"<p1 style=' font-size:15px;'>"+myListener.c01+"</p1> " +
							"<p1 style=' font-size:15px;align:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;阀值：0.0~75.0（ug/m3）</p1></div>"+
							
							"<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>CO2：</p1>" +
							"<p1 style=' font-size:15px;'>&nbsp;&nbsp;&nbsp;"+myListener.c02+"</p1> " +
							"<p1 style=' font-size:15px;align:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;阀值：0.0~0.15(%)</p1></div>"+
							
							"<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>光照：</p1>" +
							"<p1 style=' font-size:15px;'>&nbsp;&nbsp;&nbsp;"+myListener.c03+"</p1> " +
							"<p1 style=' font-size:15px;align:right;'>&nbsp;&nbsp;&nbsp;&nbsp;阀值：150.0~700.0(Lx)</p1></div>"+
							
							"<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>温度：</p1>" +
							"<p1 style=' font-size:15px;'>&nbsp;&nbsp;&nbsp;"+myListener.c04+"</p1> " +
							"<p1 style=' font-size:15px;align:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;阀值：10.0~32.0(℃)</p1></div>"+
							
							"<div class='form-group' style='background-color:#00ff00;width:100%;height:20px'>" +
							"<p1 style=' font-size:15px;'>声音：</p1>" +
							"<p1 style=' font-size:15px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+myListener.c05+"</p1> ";
					out.println(str_html);
					
					
				}else if(submit_type.equals("myweixin")){
						String str = req.getParameter("keyword");
						str=new String(str.getBytes("iso8859-1"),"UTF-8");
						
						 //response
				        String text ="";  
				     if(str.equals("南京晓庄")){
				        text="南晓i社：\n欢迎使用环境监测API接口。\n" +
				        		"当前环境数值如下：\n\n" +
				        		"甲醛：    "+myListener.c00+"(ppb)  阀值：0.0~67.0\n"+
				        		"PM2.5："+myListener.c01+"(ug/m3)  阀值：0.0~75.0\n"+
				        		"CO2：    "+myListener.c02+"(%)  阀值：0.0~0.15\n"+
				        		"光照：    "+myListener.c03+"(Lx)  阀值：150.0~700.0\n"+
				        		"温度：    "+myListener.c04+"(℃)  阀值：10.0~32.0\n"+
				        		"声音：    "+myListener.c05+"";
				     }else {
				    	 text="输入：“南京晓庄”\n可以查看当前环境质量！";
				    	 
				     }
				        //////////////////////////////////////////////////
//				        if(str==null||str.length()!=12)
//				        {
//				        	text = "输入错误！\n#号键+手机号\n获取天气。";
//				        }else {
//				        	String s = str.substring(0, 1);
//					        String phone = str.substring(1,12);
//					        if(!"#".equals(s)){
//					        	text = "输入错误！\n#号键+手机号\n获取天气。";
//					        }else {
//					        	
//					    		ArrayList<String> citylist =new ArrayList<String>();
//					    		ArrayList<citys> weatherlist = new ArrayList<citys>();
//					    		
//					    		String userPhone = phone;	
//					    		System.out.println("str:"+str);
//					    		System.out.println("userPhone:"+userPhone);
//					    		citylist = DatabaseUtil.queryCityWeather(userPhone);
//					    		//用户不存在就注册用户
//					    		if(citylist.size()==0){
//					    			text = "该手机号暂未注册！";
//					    			resp.setContentType("text/html;charset=utf-8");
//									PrintWriter out=resp.getWriter(); 
//									out.println(text);
//									out.flush();
//									out.close();
//					    			return;
//					    		}
//					    		///////////////////////////////////////////////////
//					    		ExecutorService exec = Executors.newCachedThreadPool();	
//					    		ArrayList<Future<citys>> list_future = new ArrayList<Future<citys>>();
//					    		for(int i=0;i<(citylist.size()<=3?citylist.size():3);i++)
//					    		{
//					    			System.out.println("***");
//					    			list_future.add(i,(Future)exec.submit(new Task_getWeather(citylist.get(i))));
//					    		}
//					    		//////////////////////////////////////////////////////
//					    		for(int i=0;i<(citylist.size()<=3?citylist.size():3);i++){			
//					    			citys c;
//									try {
//										c = (citys)(list_future.get(i).get(5000, TimeUnit.MILLISECONDS));
//
//						    			System.out.println("ok:"+c.getSuggest_0());
//						    			weatherlist.add(c);
//									} catch (InterruptedException
//											| ExecutionException
//											| TimeoutException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}			
//					    			}
//					    		///////////////////////////////////////////////////
//					    	
//					    		
//					    		if(weatherlist!=null){
//					    			text = "手机号："+phone;
//					    			for(int i =0;i<weatherlist.size();i++)
//					    			{
//					    				citys c = weatherlist.get(i); 
//					    				text += "\n\n"+c.getCityName()+"天气:\n"+c.getSuggest_0()+"\n"+c.getTitle_0()+"\n"+
//					    				c.getTitle_1()+"\n"+c.getTitle_2();
//					    			}
//					    					
//					    		}
//					    		
//					        	
//					        }
//				        }
				        
				        
				        
				        ///////////////////////////////////////////////////
				        resp.setContentType("text/html;charset=utf-8");
						PrintWriter out=resp.getWriter(); 
						out.println(text);
						out.flush();
						out.close();
				     
				}
				else
					if(submit_type.equals("test")){
//						User user =new User(1,"布拉索","88888888888888","1","123","");
//						int i = DatabaseUtil.insert(user);
//						System.out.println(":"+i);
						
//						 // 读取请求内容
//				        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//				        String line = null;
//				        StringBuilder sb = new StringBuilder();
//				        while((line = br.readLine())!=null){
//				            sb.append(line); 
//				        }
//				        // 将资料解码
//				        String reqBody = sb.toString();  
//				        String body = URLDecoder.decode(reqBody, HTTP.UTF_8);
//				        JSONObject result = null;
//				        try {
//							result = new JSONObject(body);
//							String txt = result.getString("currentValue");
//							myListener.currentValue =StringUtil.string2bytes(txt);
//							//System.out.println("byte[] currentValue:"+StringUtil.Bytes2HexString(currentValue));
//						} catch (JSONException e) {
//							System.out.println("jsonException!!");
//							e.printStackTrace();
//						}
				        
				        
//				        //response
//				        JSONObject result2=new JSONObject();
//						try {
//							result2.put("i", "server2client");
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						resp.setContentType("text/html;charset=utf-8");
//						PrintWriter out=resp.getWriter();
//						out.println(result2.toString());
//						out.flush();
//						out.close();
						
						
				       
				        
						
					}

	
			
		
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
				return myListener.getWeatherByCity(cityName);
			}
			
		}

}
