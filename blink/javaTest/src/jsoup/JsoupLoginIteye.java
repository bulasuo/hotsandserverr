package jsoup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 使用Jsoup模拟登陆Iteye
 * 
 * 
 * 大体思路如下:
 * 
 * 第一次请求登陆页面，获取页面信息，包含表单信息，和cookie（这个很重要），拿不到，会模拟登陆不上
 * 
 * 
 * 第二次登陆，设置用户名，密码，把第一次的cooking，放进去，即可
 * 
 * 怎么确定是否登陆成功？
 * 
 * 登陆后，打印页面，会看见欢迎xxx，即可证明
 * 
 * 
 * @date 2014年6月27日
 * @author qindongliang
 * 
 * 
 * **/
public class JsoupLoginIteye {
  
  public static void main(String[] args)throws Exception {
    
    JsoupLoginIteye jli=new JsoupLoginIteye();
    jli.login("878309402", "");//输入Iteye的用户名，和密码
    
  }
  /**
   * 模拟登陆Iteye
   * 
   * @param userName 用户名
   * @param pwd 密码
   * 
   * **/
  public void login(String userName,String pwd)throws Exception{
    
    //第一次请求
    Connection con=Jsoup.connect("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&pt_qr_app=手机QQ空间&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html");//获取连接
//    Document doc = Jsoup.connect("http://qzone.qq.com/").get();
//    System.out.println("Element:\n"+doc.toString());
    
    con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//配置模拟浏览器
        Response rs= con.execute();//获取响应
        
        System.out.println("response.toString\n"+Jsoup.parse(rs.body()).toString());
        
        Document d1=Jsoup.parse(rs.body());//转换为Dom树
//        System.out.println("Element:\n"+d1.toString());
 	    List<Element> et= d1.getElementsByTag("_self");//获取form表单，可以通过查看页面源码代码得知
 	    System.out.println("List.size:\n"+et.size());
 	   //获取，cooking和表单属性，下面map存放post时的数据 
       Map<String, String> datas=new HashMap<String, String>();
     for(Element e:et.get(0).getAllElements()){
       if(e.attr("name").equals("u")){
         e.attr("value", userName);//设置用户名
       }
       
       if(e.attr("name").equals("p")){
         e.attr("value",pwd); //设置用户密码
       }
       
       if(e.attr("name").length()>0){//排除空值表单属性
         datas.put(e.attr("name"), e.attr("value"));  
       }
     }
 	    
     
     /**
      * 第二次请求，post表单数据，以及cookie信息
      * 
      * **/
     Connection con2=Jsoup.connect("http://ptlogin2.qq.com/login?u=878309402");
//     								http://ptlogin2.qq.com/login?u=878309402&verifycode=!RZA&pt_vcode_v1=0&pt_verifysession_v1=a4d568c512fe9cf7931e9bf08cf7b2be68686618735221e637672e7ca3a4089f07a20ca7c196f5de0db481b8cdb26cefb6afd074a6ae862a&p=hBoSEy8RQVW4iSiYh9sUcIfqWWFZEPQEPooaAW0jn1XRjptN2rOU9D17rLlI2pbCDyEP4u3LbH*UUORSlYUmmo8ZNBnfkMxioDp7rWDVTzee5b91qv6QY9czzul11zmY6Ahbr3MYgk3dsFh3A7wczyVX-lyxBsjpMjC991mwUioSbg0xts0bcjBvJOdsDD1cEIqF1GNmv9OgwiPNaLKgug__&pt_randsalt=0&u1=http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dizone&ptredirect=0&h=1&t=1&g=1&from_ui=1&ptlang=2052&action=4-0-1442131944853&js_ver=10034&js_type=1&login_sig=CO2KnALLyIhO4*mOie6690dxxNUr3-nCS7iI1gv9S3XpGR6JxIDj2Wq5pKxAffXL&pt_uistyle=32&aid=549000912&daid=5&pt_qzone_sig=1&
     con2.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
     //设置cookie和post上面的map数据
 	   Response login=con2.ignoreContentType(true).method(Method.POST).data(datas).cookies(rs.cookies()).execute();
 	   //打印，登陆成功后的信息
 	   System.out.println(login.body());
 	   
 	   //登陆成功后的cookie信息，可以保存到本地，以后登陆时，只需一次登陆即可
 	   Map<String, String> map=login.cookies();
 	   for(String s:map.keySet()){
 		   System.out.println(s+":"+map.get(s));
 	   }
 	
  }
  
  
  

  
  
}