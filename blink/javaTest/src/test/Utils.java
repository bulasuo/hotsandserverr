package test;

public class Utils {
	private static final int BASELENGTH = 128;
	private static final int LOOKUPLENGTH = 64;
	private static final int TWENTYFOURBITGROUP = 24;
	private static final int EIGHTBIT = 8;
	private static final int SIXTEENBIT = 16;
	private static final int FOURBYTE = 4;
	private static final int SIGN = -128;
	private static char PAD = '=';
	private static byte[] base64Alphabet = new byte[BASELENGTH];
	private static char[] lookUpBase64Alphabet = new char[LOOKUPLENGTH];
	
	public static String encode(byte[] binaryData) {

		if (binaryData == null) {
			return null;
		}

		int lengthDataBits = binaryData.length * EIGHTBIT;
		if (lengthDataBits == 0) {
			return "";
		}

		int fewerThan24bits = lengthDataBits % TWENTYFOURBITGROUP;
		int numberTriplets = lengthDataBits / TWENTYFOURBITGROUP;
		int numberQuartet = fewerThan24bits != 0 ? numberTriplets + 1
				: numberTriplets;
		char encodedData[] = null;

		encodedData = new char[numberQuartet * 4];

		byte k = 0, l = 0, b1 = 0, b2 = 0, b3 = 0;

		int encodedIndex = 0;
		int dataIndex = 0;

		for (int i = 0; i < numberTriplets; i++) {
			b1 = binaryData[dataIndex++];
			b2 = binaryData[dataIndex++];
			b3 = binaryData[dataIndex++];

			l = (byte) (b2 & 0x0f);
			k = (byte) (b1 & 0x03);

			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);
			byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4)
					: (byte) ((b2) >> 4 ^ 0xf0);
			byte val3 = ((b3 & SIGN) == 0) ? (byte) (b3 >> 6)
					: (byte) ((b3) >> 6 ^ 0xfc);

			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[(l << 2) | val3];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[b3 & 0x3f];
		}

		// form integral number of 6-bit groups
		if (fewerThan24bits == EIGHTBIT) {
			b1 = binaryData[dataIndex];
			k = (byte) (b1 & 0x03);
			
			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[k << 4];
			encodedData[encodedIndex++] = PAD;
			encodedData[encodedIndex++] = PAD;
		} else if (fewerThan24bits == SIXTEENBIT) {
			b1 = binaryData[dataIndex];
			b2 = binaryData[dataIndex + 1];
			l = (byte) (b2 & 0x0f);
			k = (byte) (b1 & 0x03);

			byte val1 = ((b1 & SIGN) == 0) ? (byte) (b1 >> 2)
					: (byte) ((b1) >> 2 ^ 0xc0);
			byte val2 = ((b2 & SIGN) == 0) ? (byte) (b2 >> 4)
					: (byte) ((b2) >> 4 ^ 0xf0);

			encodedData[encodedIndex++] = lookUpBase64Alphabet[val1];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[val2 | (k << 4)];
			encodedData[encodedIndex++] = lookUpBase64Alphabet[l << 2];
			encodedData[encodedIndex++] = PAD;
		}

		return new String(encodedData);
	}
	
	public final static byte[] hex = "0123456789ABCDEF".getBytes();
	
	public static String Bytes2HexString(byte[] bb)
	{
		int i,len;
		len=bb.length;
		byte[] b=new byte[len];
		for (i=0;i<len;i++)
			b[i]=bb[len-i-1];

		byte[] buff = new byte[2 * b.length];

		for ( i = 0; i < b.length; i++) {

			buff[2 * i] = hex[(b[b.length - i - 1] >> 4) & 0x0f];
			buff[2 * i + 1] = hex[b[b.length - i - 1] & 0x0f];
		}
		return new String(buff);
	}
	
	private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是" +
				"ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是" +
				"ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是" +
				"ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是" +
				"ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是ajsfba;j爱上邓丽君阜南爱上了奋斗呢啊实打实地方 是否都是";
		
		for(int i=0;i<4;i++){
			s+=s;
		}
		System.out.println(""+System.currentTimeMillis());
		System.out.println("-"+encode(s.getBytes()));
//		System.out.println("-"+Bytes2HexString(s.getBytes()));
//		System.out.println("-"+bytesToHexString(s.getBytes()));
		System.out.println(""+System.currentTimeMillis());
	}

}
