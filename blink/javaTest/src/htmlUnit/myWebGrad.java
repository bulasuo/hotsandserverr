package htmlUnit;



import java.io.IOException;

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

public class myWebGrad {
	
	private DefaultHttpClient httpClient=new DefaultHttpClient();
	private HttpResponse httpResponse;
	private HttpGet httpGet = null;
	private Document doc = null;
	private String imgUrlHead = "";
	private String ShopUrl = "";
	
	private String stringTemp = "";
	private String describe = "";//商品描述
	private String mImgLis[] = null;//最终的URL数组
	private String response_string="";
	
	
	/**
	 * 
	 * @param Shop_id 商店id
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public myWebGrad(String Shop_id) throws ClientProtocolException, IOException{
		this.ShopUrl = "https://item.taobao.com/item.htm?id="+Shop_id;
		
		httpGet=new HttpGet(ShopUrl);	                     
		httpResponse = httpClient.execute(httpGet);
		if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			HttpEntity entity = httpResponse.getEntity();
			response_string = EntityUtils.toString(entity,"utf-8");	
		}
		imgUrlHead = "http://"+response_string.substring(response_string.indexOf("tds.alicdn.com/json/item_imgs.htm"), response_string.indexOf("&v=2&m=1")+8);//图片资源head
	}
	
	
	
	
	/**
	 * 
	 * @return 商品描述
	 */
	public String getDescribe(){

			doc = Jsoup.parse(response_string);
			Elements contents = doc.getElementsByClass("attributes-list");
			for(Element content:contents){
			describe = new String(content.text().getBytes()).replace("?", " ");
			System.out.println("商品描述:"+describe);//商品描述
			}
			return describe;	
	}
	
	
	/**
	 * 
	 * @return 商品图片Url数组
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String[] getImgUrls() throws ClientProtocolException, IOException{
		httpGet = new HttpGet(imgUrlHead);
		httpResponse = httpClient.execute(httpGet);
		if(httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
		HttpEntity entity = httpResponse.getEntity();
		response_string = EntityUtils.toString(entity,"utf-8");				
		stringTemp = response_string.substring(87, response_string.lastIndexOf("})"));
		mImgLis=stringTemp.split("},");
		for(int i = 0;i<mImgLis.length;i++){	
			mImgLis[i] =  "https://img.alicdn.com/imgextra/"+mImgLis[i].substring(1,mImgLis[i].indexOf(":")-1);			
		}
	}
		return mImgLis;
	}

}
