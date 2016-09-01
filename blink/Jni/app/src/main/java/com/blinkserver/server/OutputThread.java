package com.blinkserver.server;

import com.alibaba.fastjson.JSON;
import com.blinkserver.util.XUtil;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

/**
 * 写消息线程
 */
public class OutputThread extends Thread {
	private OutputThreadMap map;
	private DataOutputStream dos;
	private TranObj tranObj;
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

	public synchronized void sendMessage(TranObj tranObj) {
		this.tranObj = tranObj;
		notifyAll();
	}

	@Override
	public void run() {
		try {
			while (!tryDestroy) {
				synchronized (this) {
					while(tryStop) {
						wait();
					}
					if (tranObj != null) {
						final byte[] boundaryBytes=  UUID.randomUUID().toString().getBytes();
						final byte[] jsonStrBytes
								= JSON.toJSONString(tranObj).getBytes();
						dos.write(Constant.TranProtocol.HEAD.getBytes());
						dos.write(boundaryBytes);
						dos.write(Constant.TranProtocol.LINE.getBytes());
						//jsonStr个数
						dos.write((byte)0x01);
						//jsonStrBytes长度
						dos.write(XUtil.intToByteArray(jsonStrBytes.length));
						//文件个数为0则省略文件长度
						dos.write((byte)0x00);
						dos.write(jsonStrBytes);
						dos.write(Constant.TranProtocol.HEAD.getBytes());
						dos.write(boundaryBytes);
						dos.write(Constant.TranProtocol.HEAD.getBytes());
						dos.write(Constant.TranProtocol.LINE.getBytes());
						dos.flush();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				map.remove();
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
