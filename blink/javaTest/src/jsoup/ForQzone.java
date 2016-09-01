package jsoup;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ForQzone {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 Connection con=Jsoup.connect("http://qzone.qq.com/");//获取连接
		    con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//配置模拟浏览器
		        Response rs= con.execute();//获取响应
		 String s = Jsoup.parse(rs.body()).toString();
		 System.out.println("Start:\n"+s);
	}

}
