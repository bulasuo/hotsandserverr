package com.blinkserver.server;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 写消息线程
 */
public class OutputThread extends Thread {
	private OutputThreadMap map;
	private DataOutputStream dos;
	private TranProtocol tranProtocol;
	private boolean tryDestroy = false;
	private boolean tryStop = false;
	private Socket socket;

	public OutputThread(Socket socket, OutputThreadMap map) {
		try {
			this.socket = socket;
			this.map = map;
			dos = new DataOutputStream(socket.getOutputStream());// 在构造器里面实例化对象输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void sendMessage(TranProtocol tranProtocol) {
		this.tranProtocol = tranProtocol;
		this.notifyAll();
	}

	@Override
	public void run() {
		try {
			while (!tryDestroy) {
				synchronized (this) {
					while(tryStop) {
						this.wait();
					}
					if (tranProtocol != null) {
						tranProtocol.sendData(dos);
						dos.flush();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				map.remove();
				if (dos != null)
					dos.close();
				if (socket != null)
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
