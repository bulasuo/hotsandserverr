package htmlUnit;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class myWebGrad_test {

	public static void main(String[] args) {
		try {
			myWebGrad myWebGrad = new  myWebGrad("522189163321");
			System.out.println("商品描述："+myWebGrad.getDescribe());
			
			String imgUrls[] = myWebGrad.getImgUrls();
			for(int i=0;i<imgUrls.length;i++){
				System.out.println("图片Url："+imgUrls[i]);
			}
			
			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
