package com.blinkserver.server;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 写消息线程
 *@author   abu   2016/9/6   10:06
 */
public class OutputThread extends Thread {
	private OutputThreadMap map;
	private DataOutputStream dos;
	private TranProtocol tranProtocol;
	private boolean tryDestroy = false;
	private Socket socket;
	public byte[] keyBytesAES;//AES口令bytes 用于加密数据
	public boolean isLogin = false;//记录用户是否有个人权限


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
			while (!socket.isClosed() && !tryDestroy) {
				synchronized (this) {
					if (tranProtocol != null) {
						if(keyBytesAES != null)
							tranProtocol.keyBytesAES = this.keyBytesAES;
						tranProtocol.sendData(dos);
						dos.flush();
					}
					this.wait();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// TODO: 2016/9/5 map去除当前outStream
				// map.remove();
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
