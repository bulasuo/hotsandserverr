package test;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;


public class RAS_AESTest {
	
	public static final String AES = "AES"; 
	public static final String RSA = "RSA"; 
    /**
     * class 生成RSA秘钥对
     */
	public static class RSAKeyParMaker{
    	private RSAPrivateKey privateKey;
    	private RSAPublicKey publicKey;
    	private int KEY_SIZE = 1024;
    	
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
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] RSAEncode(byte[] data, Key key) throws Exception {  
        Cipher cipher = Cipher.getInstance(RSA);  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
        return cipher.doFinal(data);  
    }
    
    /**
     * RSA解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] RSADecode(byte[] data, Key key) throws Exception {  
        Cipher cipher = Cipher.getInstance(RSA);  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        return cipher.doFinal(data);  
    }
    
    /**
     * @param keyBytes
     * @return RSA公钥
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static Key formRSAPublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);  
    	return keyFactory.generatePublic(x509KeySpec);
    }
    
    /**
     * @param keyBytes
     * @return RSA私钥
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static Key formRSAPrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException{
    	PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);  
        return keyFactory.generatePrivate(pkcs8KeySpec);   
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
		
		/**
		 * AES加密解密
		 */
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
			/**RSA
			 * 公钥加密,私钥解密
			 */
			String message = "bulasuo:腰包满是银子,米加德遍地鲜花!!";//UUID.randomUUID().toString();  
			RSAKeyParMaker mRSAKeyParMaker = new RSAKeyParMaker();
			byte[] encodeB = RSAEncode(message.getBytes(), formRSAPublicKey(mRSAKeyParMaker.publicKey.getEncoded()));
			byte[] decodeB = RSADecode(encodeB, formRSAPrivateKey(mRSAKeyParMaker.privateKey.getEncoded()));
			System.out.println("result::"+new String(decodeB));
			
			/**RSA
			 * 私钥加密,公钥解密
			 */
			String message1 = "bulasuo:腰包满是银子,米加德遍地鲜花!!";//UUID.randomUUID().toString();  
			RSAKeyParMaker mRSAKeyParMaker1 = new RSAKeyParMaker();
			byte[] encodeB1 = RSAEncode(message1.getBytes(), formRSAPrivateKey(mRSAKeyParMaker1.privateKey.getEncoded()));
			byte[] decodeB1 = RSADecode(encodeB1, formRSAPublicKey(mRSAKeyParMaker1.publicKey.getEncoded()));
			System.out.println("result::"+new String(decodeB1));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final long endTime = System.currentTimeMillis();
		System.out.println("end  :"+endTime+"\nuse time:"+(endTime - startTime));
		
	}

}
