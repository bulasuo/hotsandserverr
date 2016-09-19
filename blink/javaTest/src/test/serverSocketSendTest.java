package test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocketSendTest {
	static class MyThread extends Thread{
		
		public MyThread(){}
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(8001);

				while(true){
				Socket socket = serverSocket.accept();
				socket = serverSocket.accept();
			
				if(socket.isConnected()){
					socket.setKeepAlive(true);
					System.out.println("accept one");
				}
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					dos.write((byte)0x00);
					dos.flush();
					System.out.println("write--");
					Thread.sleep(10000);
					dos.write((byte)0x00);
					dos.flush();
					System.out.println("write_end");
				
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread mMyThread = new MyThread();
		mMyThread.start();
		try {
			Thread.sleep(1000*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
