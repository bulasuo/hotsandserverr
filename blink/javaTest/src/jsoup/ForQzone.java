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
		 Connection con=Jsoup.connect("http://qzone.qq.com/");//��ȡ����
		    con.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");//����ģ�������
		        Response rs= con.execute();//��ȡ��Ӧ
		 String s = Jsoup.parse(rs.body()).toString();
		 System.out.println("Start:\n"+s);
	}

}
