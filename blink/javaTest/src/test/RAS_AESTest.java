package test;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;


public class RAS_AESTest {
	
	public static final String AES = "AES"; 
	public static final String RSA = "RSA"; 
    /**
     * class 生成RSA秘钥对
     */
	public static class RSAKeyParMaker{
    	private RSAPrivateKey privateKey;
    	private RSAPublicKey publicKey;
    	private int KEY_SIZE = 512;
    	
    	public RSAKeyParMaker() throws NoSuchAlgorithmException{
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);  
            keyPairGen.initialize(KEY_SIZE);  
            KeyPair keyPair = keyPairGen.generateKeyPair();  
            privateKey = (RSAPrivateKey) keyPair.getPrivate();  
            publicKey = (RSAPublicKey) keyPair.getPublic();  
    	}

		public RSAPrivateKey getPrivateKey() {
			return privateKey;
		}

		public RSAPublicKey getPublicKey() {
			return publicKey;
		}
    }
    
	/**
	 * RSA加密
	 */
    public static byte[] RSAEncode(byte[] data, Key k) throws Exception {  
        Cipher cipher = Cipher.getInstance(RSA);  
        cipher.init(Cipher.ENCRYPT_MODE, k);  
        return cipher.doFinal(data);  
    }  
    
    /**
     * RSA解密
     */
    public static byte[] RSADecode(byte[] data, Key k) throws Exception {  
        Cipher cipher = Cipher.getInstance(RSA);  
        cipher.init(Cipher.DECRYPT_MODE, k);  
        return cipher.doFinal(data);  
    }  

    /**
     * AES加密
     */
    public static byte[] AESEncode(byte[] data, byte[] key) throws Exception {  
    	KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);  
        keyGenerator.init(new SecureRandom(key));  
        Key securekey = keyGenerator.generateKey();  
        SecureRandom sr = new SecureRandom();  
        Cipher cipher = Cipher.getInstance(AES);  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);  
        data = cipher.doFinal(data);  
        return data;  
    }  
      
    /**
     * AES解密
     */
    public static byte[] AESDecode(byte[] data, byte[] key) throws Exception{  
    	KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);  
        keyGenerator.init(new SecureRandom(key));  
        Key securekey = keyGenerator.generateKey();  
        SecureRandom sr = new SecureRandom();  
        Cipher cipher = Cipher.getInstance(AES);  
        cipher.init(Cipher.DECRYPT_MODE, securekey,sr);  
        data = cipher.doFinal(data);  
        return data;  
    }  
    
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();
		System.out.println("start:"+startTime);
		
		/*String message = "布拉索:腰包满是银子,米加德遍地鲜花!布拉索:腰包满是银子,米加德遍地鲜花!!";  
        String key = UUID.randomUUID().toString();  
        byte[] entryptedMsg;
		try {
			System.out.println("result--"+message.getBytes().length);
			entryptedMsg = AESEncode(message.getBytes(),key.getBytes());
	 
	        System.out.println("111::"+entryptedMsg.length);  
	          
	        byte[] decryptedMsg;
		
			decryptedMsg = AESDecode(entryptedMsg,key.getBytes());
			 System.out.println("2222::"+decryptedMsg.length);  
			 
			 System.out.println("result--"+new String(decryptedMsg));  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println("---"+message.length());*/
		
		
		try {
			String message = UUID.randomUUID().toString();  
			System.out.println("messageB.length:"+message.getBytes().length);
			RSAKeyParMaker mRSAKeyParMaker = new RSAKeyParMaker();
			System.out.println("mRSAKeyParMaker.privateKey.size::"+mRSAKeyParMaker.privateKey.getEncoded().length);
			byte[] encodeB = RSAEncode(message.getBytes(), mRSAKeyParMaker.privateKey);
			System.out.println("encodeB.length:"+encodeB.length);
			byte[] decodeB = RSADecode(encodeB, mRSAKeyParMaker.publicKey);
			System.out.println("decodeB.length:"+decodeB.length+"\nresult::"+new String(decodeB));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final long endTime = System.currentTimeMillis();
		System.out.println("end  :"+endTime+"\nuser time:"+(endTime - startTime));
		
	}

}
