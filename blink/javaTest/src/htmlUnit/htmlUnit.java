package htmlUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class htmlUnit {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",    "org.apache.commons.logging.impl.NoOpLog");
		 
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
		    .setLevel(Level.OFF);
		 
//		java.util.logging.Logger.getLogger("org.apache.commons.httpclient")
//		    .setLevel(Level.OFF);
		System.out.println(":Start!");
		//模拟一个浏览器
				WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
				//设置webClient的相关参数
				webClient.getOptions().setJavaScriptEnabled(true);
				webClient.getOptions().setCssEnabled(false);
				webClient.setAjaxController(new NicelyResynchronizingAjaxController());
				webClient.getOptions().setTimeout(35000);
				webClient.getOptions().setThrowExceptionOnScriptError(false);
//				webClient.waitForBackgroundJavaScript(600*1000);  
				//模拟浏览器打开一个目标网址
				HtmlPage rootPage= webClient.getPage("https://item.taobao.com/item.htm?id=42621923769");
				System.out.println("加载中...");
				int count = 100;//最多等待10秒
					while(count > 0){
					if(Jsoup.parse(rootPage.asXml()).getElementById("J_DivItemDesc").toString().length()>100){//判断有没有完全加载，完全加载后才退出，并且取得想要的html代码
					break;
					}else{
					Thread.sleep(100);
					count--;
					}
					}
					if(count<=0){System.out.println("没有在10秒内加载完全！");}
		            System.out.println(Jsoup.parse(rootPage.asXml()).getElementById("J_DivItemDesc").toString());

	}

}
