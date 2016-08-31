package com.blinkserver.server;

import com.alibaba.fastjson.JSON;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 写消息线程
 */
public class OutputThread extends Thread {
	private OutputThreadMap map;
	private DataOutputStream dos;
	private JSON json;
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

	public synchronized void sendMessage(JSON json) {
		this.json = json;
		notify();
	}

	@Override
	public void run() {
		try {
			while (!tryDestroy) {
				synchronized (this) {
					wait();
					if (json != null) {
						oos.writeObject(object);
						oos.flush();
					}
				}
			}
			if (oos != null)// 循环结束后，关闭流，释放资源
				oos.close();
			if (socket != null)
				socket.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
