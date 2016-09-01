import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Test {
	
	//inputStream2String
	public final static String dealResponseResult(InputStream inptStream) {
		String resultData = null;      //存储处理结果
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		try {
			while((len = inptStream.read(data)) != -1) {
				byteArrayOutputStream.write(data, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultData = new String(byteArrayOutputStream.toByteArray());
					return resultData;
				}
	
	//参数转StringBuilder
	public final static StringBuilder getRequestData(Map<String, String> params,String encode) {
		StringBuilder sb = new StringBuilder();//非线程安全
		try {
			for(Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey())
						.append("=")
						.append(URLEncoder.encode(entry.getValue(), encode))
						.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);    //删除最后的一个"&"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	//打印所有头文件
	private static void getthefiled2(int code, HttpURLConnection hc) {

		String keys[] = { "Content-Language", "Date", "Transfer-Encoding",
				"Expires", "Keep-Alive", "Via", "Set-Cookie", "Connection",
				"Content-Type", "Server", "Cache-Control" ,"Pragma"};
		if (code == HttpURLConnection.HTTP_OK) {
			Map<String, List<String>> maps = hc.getHeaderFields();
			for (String ky : keys) {
				List<String> values = maps.get(ky);
				System.out.print(ky + ":");
				if (values != null)
					for (String str : values) {
						System.out.println(str);
					}
				else
					System.out.print("value is null");
				System.out.println();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("202cb962ac59075b964b07152d234b70".length());
		
		String strUrl = "http://192.168.1.121:8000/api/v1/category/";
//		String strUrl = "http://192.168.1.121:8000/customer/register/smssend/";
	
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("username", "bulasuo");
//		params.put("password", "111111");
//		params.put("password_repeat", "111111");
		
//		params.put("username", "13814057793");
//		params.put("password", "111111");
//		JSONObject json = new JSONObject();
//		try {
//			json.put("username", "bulasuo");
//			json.put("password", "111111");
//			json.put("password_repeat", "111111");
//			System.out.println("start:"+json.toString());
//			
//			
//			
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		
		
//		System.out.println("start:"+json.toString());
		
//		byte[] data = getRequestData(params, "UTF-8").toString().getBytes();//获得请求体的二进制
		byte[] data = "{\"parent_name\":\"derivative\"}".getBytes();//获得请求体的二进制
//		byte[] data = "{\"username\": \"13814057793\",\"password\": \"I2brxrF/FFvKsNr+JnMAoKhyxYZSHWp5P2B8kmzWvZZBM6M3NzVEe997pamXfozLTxExFq80xeLtb++uj6+THg8mhEiiTO+7EBCCsM+V1NsFBjYuck1tAbB20ypO8L1K9Mw70Ey8QRA9n2v9YqY2MBOx1Rn5yv+zOhSFnSiP3eg=\"}".getBytes();
		
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setReadTimeout(6000);
			httpURLConnection.setConnectTimeout(6000);           //设置连接超时时间
			httpURLConnection.setDoInput(true);                  //打开输入流，以便从服务器获取数据
			httpURLConnection.setDoOutput(true);                 //打开输出流，以便向服务器提交数据
			httpURLConnection.setRequestMethod("POST");     	 //设置以Post方式提交数据
//			httpURLConnection.setRequestMethod("GET"); //get请求参数写在url里并且要URLEncoder.encode(param.value, "utf-8")编译一下码
			httpURLConnection.setUseCaches(false);               //不使用缓存

//			httpURLConnection.setRequestProperty("Charset", encode); // 设置编码
//			httpURLConnection.setRequestProperty("connection", "keep-alive");
//			httpURLConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
//			httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + UUID.randomUUID().toString());//内容类型;边界标识符随机生成(多种数据传输使能)

			//设置请求体的类型是文本类型
//	            //text/xml -> xml数据       application/json -> json对象       application/x-www-form-urlencoded -> 表单数据       multipart/form-data -> 多种数据
//	            httpURLConnection.setRequestProperty("Content-Type", "application/x-javascript; charset="+ encode);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			httpURLConnection.setRequestProperty("user-agent", "ArtCMP/1.3.0 (iPhone; iOS 9.3; Scale/2.00)");
			httpURLConnection.setRequestProperty("Client-Agent", "device:iPhone;os:iOS9.3;version:1.3.0");
			//设置请求体的长度
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
			//获得输出流，向服务器写入数据
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(data);
			int responseCode = httpURLConnection.getResponseCode();            //获得服务器的响应码
			
			System.out.println(":::::responseCode-"+responseCode);
			if(responseCode == HttpURLConnection.HTTP_OK) {
				/////////print cookie/////////打印cookie////////可以改session的时间防止失效了///////////////////////////////////////
				
				Map<String, List<String>> maps = httpURLConnection.getHeaderFields();
				System.out.println("maps-"+maps.size());
				List<String> coolist = maps.get("Set-Cookie");
				System.out.println("coolist-"+coolist.size());
				for(String str : coolist){
					System.out.println("\n-"+str);
				}
				getthefiled2(200, httpURLConnection);
				httpURLConnection.setRequestProperty("Cookie",coolist.get(0));//下次请求带上cookie
				/////////////////////////////////////////////////////
				final InputStream inptStream = httpURLConnection.getInputStream();
				System.out.println(":::::\n"+dealResponseResult(inptStream));
			} 
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			
		}

	}

}
