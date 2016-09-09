package test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import utill.XUtil;

public class testServerSocket {

static class MyThread extends Thread{
	
	public DataInputStream dis;
		
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(8001);
				Socket socket = serverSocket.accept();
				if(socket.isConnected()){
					socket.setKeepAlive(true);
					System.out.println("accept one");
				}
				dis = new DataInputStream(socket.getInputStream());
				int readLength = 0;
				byte[] buf = new byte[1024];
				int count = 0;
				while(true){
					System.out.println("start");
					while((readLength = dis.read(buf, 0, 1024))>0){
						System.out.println("read-"+readLength+":\n"+XUtil.bytes2HexString(buf));
					}
					if(readLength == -1)
						throw new IOException("suladi??");
					
					System.out.println("end request:readLength::"+readLength);
				}
				
			} catch (IOException e) {
				System.out.println("!!!!"+e);
				e.printStackTrace();
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程尝试退出!"); 
		try {
			t.dis.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t.stop();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程已经退出!"+(t==null)); 

	}

}
