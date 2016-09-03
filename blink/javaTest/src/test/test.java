package test;

import java.util.UUID;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		byte b1 = (byte)11;
		byte b2 = (byte)129;
		int bb = 161;
		System.out.println("::"+b2);
		
//		for(int i = 0;i<11;i++)
//			System.out.println(i);
		
		switch(bb){
		case ((byte)0xa1)&0xff:
			System.out.println("0xa1");
			break;
		case (byte)0xa2:
			System.out.println("0xa2");
			break;
		}
		
		
	}

}
