package htmlUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;


public class myTest01 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 */
	public static void main(String[] args) throws  MalformedURLException, IOException {

		
		new Thread(new Runnable(){
			
			public void run() {
				try {
				ExecutorService exec = Executors.newCachedThreadPool();	
				DefaultHttpClient httpClient=new DefaultHttpClient();
				HttpResponse httpResponse;
				HttpGet httpGet = null;
				Document doc = null;
				String imgUrlHead = "";
				
				
				String stringTemp = "";
				String describe = "";//商品描述
				String mImgLis[] = null;//最终的URL数组
				String response_string="";
				
				//第一次请求
				httpGet=new HttpGet("https://item.taobao.com/item.htm?id=42621923769");	                     
				httpResponse = httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					HttpEntity entity = httpResponse.getEntity();
					response_string = EntityUtils.toString(entity,"utf-8");	
					
//					System.out.println("response_string111::"+response_string);//。。。。。。。。。。。。。。。。。。
					
					doc = Jsoup.parse(response_string);
					Elements contents = doc.getElementsByClass("attributes-list");
					for(Element content:contents){
					
					describe = new String(content.text().getBytes()).replace("?", " ");
					System.out.println("商品描述:"+describe);//商品描述
					}
					
//					Element content1 = doc.getElementById("promote");
//					imgUrlHead = "https"+content1.attr("data-default");//图片资源head
//					System.out.println("url111:"+content1.toString());
					
					imgUrlHead = "http://"+response_string.substring(response_string.indexOf("tds.alicdn.com/json/item_imgs.htm"), response_string.indexOf("&v=2&m=1")+8);//图片资源head
					
					
					System.out.println("imgUrlHead:"+imgUrlHead);				
				}
				
				//第二次请求
				httpGet = new HttpGet(imgUrlHead);
				httpResponse = httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					HttpEntity entity = httpResponse.getEntity();
					response_string = EntityUtils.toString(entity,"utf-8");	
					
					stringTemp = response_string.substring(87, response_string.lastIndexOf("})"));

				
				mImgLis=stringTemp.split("},");
//				System.out.println("wwwwwwwwwww:"+mImgLis.length);
				
				for(int i = 0;i<mImgLis.length;i++){
					
					mImgLis[i] =  "https://img.alicdn.com/imgextra/"+mImgLis[i].substring(1,mImgLis[i].indexOf(":")-1);
					
					System.out.println("图片:"+mImgLis[i]);//图片URL
					
//					new DisplayImageIcon(mImgLis[i]);
					//一种是类里异步
					//一种是把类异步
					exec.execute(new Task_displayImg(mImgLis[i]));////////////////////////////////////////////////////////////////////////////看看看看
					
				}
					
					
					
				}
				
				
				
				
				System.out.println("::End!");
				
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			}).start();
			
			System.out.println(":::Start!");
			
		}
	
	static class Task_displayImg implements Runnable
	{
		private String myurl="";
		public Task_displayImg(String myurl)
		{
			this.myurl=myurl;
		}

		public void run() {
			new DisplayImageIcon(myurl);
			
		}

		
		
	}
	

		

	}
