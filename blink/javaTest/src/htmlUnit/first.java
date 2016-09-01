package htmlUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.BaseFrameElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

import com.gargoylesoftware.htmlunit.util.Cookie;

public class first {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws FailingHttpStatusCodeException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
		java.util.Set<Cookie> cookies_ret = null;
		final WebClient webClient=new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient.getCookieManager().setCookiesEnabled(true);//开启cookie管理
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(true);
		
		final WebClient webClient111=new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		webClient111.getCookieManager().setCookiesEnabled(true);//开启cookie管理
		webClient111.getOptions().setCssEnabled(false);
		webClient111.getOptions().setJavaScriptEnabled(true);
//		// 3 启动客户端重定向
//		webClient.getOptions().setRedirectEnabled(true);
//		webClient.setJavaScriptTimeout(5000);
//		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
		
//		final WebClient webClient2=new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
//		webClient2.getCookieManager().setCookiesEnabled(true);//开启cookie管理
//		webClient2.getOptions().setCssEnabled(false);
//		webClient2.getOptions().setJavaScriptEnabled(true);
		
//		WebRequest request1 = new WebRequest(new URL("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&pt_qr_app=手机QQ空间&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html"),"POST");
//		final HtmlPage page=webClient.getPage(request1);
		final HtmlPage page=webClient.getPage("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&pt_qr_app=手机QQ空间&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html");
		final HtmlPage page111=webClient111.getPage("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&pt_qr_app=手机QQ空间&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html");
		
//		System.out.println("page:\n"+page.asXml());
//		HtmlDivision div=(HtmlDivision)page.getElementById("hed");
		
//		//获取表单 
		final HtmlForm form = page.getFormByName("loginform");
		//获取提交按扭
		final HtmlSubmitInput button = form.getInputByValue("登 录");
		//一会得输入的
		final HtmlTextInput textField_u = form.getInputByName("u");
		textField_u.setValueAttribute("878309402");
		final HtmlPasswordInput textField_p = form.getInputByName("p");
		textField_p.setValueAttribute("abu917802");
		System.out.println(
				textField_u.getText()+"***"+
				textField_p.getText());
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//点击提交表单
		final HtmlPage page2 = button.click();
//		System.out.println("asText:\n"+page2.asText());
		
		
		//获取表单 
				final HtmlForm form1 = page111.getFormByName("loginform");
				//获取提交按扭
				final HtmlSubmitInput button1 = form1.getInputByValue("登 录");
				//一会得输入的
				final HtmlTextInput textField_u1 = form1.getInputByName("u");
				textField_u1.setValueAttribute("1926196598");
				final HtmlPasswordInput textField_p1 = form1.getInputByName("p");
				textField_p1.setValueAttribute("suladi917802");
		final HtmlPage page3 = button1.click();
//		System.out.println("asText:\n"+page3.asText());
		//getCookies
//		CookieManager CM = webClient.getCookieManager(); //WC = Your WebClient's name
//        cookies_ret = CM.getCookies();//返回的Cookie在这里，下次请求的时候可能可以用上啦。       
//        System.out.println("cookie:\n"+cookies_ret.toString());
//        System.out.println("::/n"+page2.asText());
        
//        Map<String, String> map_cookie=null;
//        for(Cookie c:cookies_ret)
//        {
//        	
//        	
//        	System.out.println("c:"+c.toString());
//        	System.out.println("addCook_success");
//        }
      
		
//		/**
//	      * 第二次请求，post表单数据，以及cookie信息
//	      * 
//	      * **/
//	     Connection con2=Jsoup.connect("http://user.qzone.qq.com/1207030553/blog/1347025960");
//		
//	     con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
//	     //设置cookie和post上面的map数据
//	 	   @SuppressWarnings("unchecked")
//		Response login=con2.ignoreContentType(true).method(Method.POST).cookies(map_cookie).execute();
//	 	   //打印，登陆成功后的信息
//	 	   System.out.println(login.body());
		
//        WebRequest request = new WebRequest(new URL("http://user.qzone.qq.com/1207030553/blog/1347025960"),"POST");
        HtmlPage myPage0=null;
        HtmlPage myPage1=null;
        while(true){
        myPage0=webClient.getPage("http://user.qzone.qq.com/1207030553/main");
        System.out.println("asText:\n"+myPage0.asText());
        Thread.sleep(1000);
        myPage1=webClient111.getPage("http://user.qzone.qq.com/1207030553/main");
        System.out.println("asText:\n"+myPage1.asText());
        Thread.sleep(1000);}
        
//		HtmlPage myPage0=webClient.getPage("http://user.qzone.qq.com/1207030553/2");
//		Thread.sleep(3000);
//		myPage0=webClient.getPage("http://user.qzone.qq.com/1207030553/blog/1347025960");
		
//		HtmlPage myIframe = (HtmlPage) ((BaseFrameElement) myPage0.getElementById("tblog")).getEnclosedPage();
		
//		System.out.println("asText:\n"+myPage0.asText());
//		System.out.println("asXml:\n"+myPage0.asXml());
		
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		HtmlPage page3 = myPage0.getAnchorByHref("http://user.qzone.qq.com/1207030553/blog/1347025960").click();
		
		
		
        
//		System.out.println("1form:"+form.asXml());
//		System.out.println("2form:"+form.asText());
//		System.out.println("result1:\n"+myPage.asText());
//		System.out.println("result2:\n"+page3.asXml());
//		webClient.closeAllWindows();
//		webClient111.closeAllWindows();
		
		
		
	}

}
