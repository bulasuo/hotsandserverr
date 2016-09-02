package test;

import java.util.UUID;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte b1 = (byte)11;
		byte b2 = (byte)0xa1;
		System.out.println(b1 == b2);
		
		final byte[] boundaryBytes = UUID.randomUUID().toString().getBytes();
		System.out.println(boundaryBytes.length);
	}

}
