package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.URLEncodedUtils;
import org.bouncycastle.util.encoders.UrlBase64Encoder;
import org.eclipse.jetty.util.UrlEncoded;

public class GetRequest {

	public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	
            e.printStackTrace();
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String params = "key=55e358f3198e46a4840c02f10fd4cb6d&mobile=15062239769&tpl_id=1975&tpl_value="+URLEncoder.encode("#code#=123!!455", "utf-8");
		System.out.println(sendGet("http://apis.haoservice.com/sms/send", params)+"\n"+params);
//		{"error_code":0,"reason":"成功","result":"2911809"}
//		{"error_code":0,"reason":"成功","result":"2911811"}
//		{"error_code":201708,"reason":"模板参数没有全部生效,短信内容不能包含特殊字符#,请检查参数重试","result":null}

	}
}
