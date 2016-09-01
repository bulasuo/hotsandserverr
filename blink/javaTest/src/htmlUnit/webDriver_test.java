package htmlUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class webDriver_test {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
		//模拟一个浏览器
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		//设置webClient的相关参数
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(false);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		webClient.getOptions().setTimeout(35000);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
//		webClient.waitForBackgroundJavaScript(600*1000);  
		//模拟浏览器打开一个目标网址
		HtmlPage rootPage= webClient.getPage("https://item.taobao.com/item.htm?id=42621923769");

		int count = 60;
			while(count > 0){
			if(Jsoup.parse(rootPage.asXml()).getElementById("J_DivItemDesc").toString().length()>100){//判断有没有完全加载，完全加载后才退出，并且取得想要的html代码
			break;
			}else{
			Thread.sleep(1000);
			count--;
			}
			}

            System.out.println(Jsoup.parse(rootPage.asXml()).getElementById("J_DivItemDesc").toString());
         
		
//		testSelenium("42621923769");

	}
	
	 public static void testSelenium(String shop_id) throws InterruptedException {
	        System.getProperties().setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	        WebDriver webDriver = new ChromeDriver();
	        webDriver.get("https://item.taobao.com/item.htm?id="+shop_id);
	        WebElement webElement = webDriver.findElement(By.xpath("/html"));
	        System.out.println(Jsoup.parse(webElement.getAttribute("outerHTML")).getElementById("J_DivItemDesc").toString()); 
	        webDriver.close();
//	        
//	        webDriver.get("https://item.taobao.com/item.htm?id=521119526235");
//	        
//	        WebElement webElement1 = webDriver.findElement(By.xpath("/html"));
//	        System.out.println(Jsoup.parse(webElement1.getAttribute("outerHTML")).getElementById("J_DivItemDesc").toString()); 
//	        
//	        webDriver.quit();
		 
		 
		 
		 
		 	System.out.println("::");
		 	
		 	Selenium selenium = new DefaultSelenium("localhost", 4444, 
		 			"*firefox", "https://apps.na.collabserv.com/");
		 			// 启动 selenium session
		 			selenium.start();
		 			// 打开测试网页
		 			selenium.open("https://item.taobao.com/item.htm?id=521119526235");
		 			
		 			System.out.println(selenium.getHtmlSource());
		 			// 登录
		 			selenium.click("//input[@id='submit_form']");
		 			// 等待直到页面出现 Mail 链接
		 			int count = 60;
		 			while(count > 0){
		 			if(selenium.isElementPresent("//a[contains(text(),'Mail')]")){
		 			break;
		 			}else{
		 			Thread.sleep(1000);
		 			count--;
		 			}
		 			}
	 }

}
