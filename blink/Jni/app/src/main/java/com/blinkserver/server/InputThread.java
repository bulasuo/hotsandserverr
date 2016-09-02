package com.blinkserver.server;

import com.blinkserver.dao.UserDao;
import com.blinkserver.util.MyDate;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;


/**
 * 读消息线程和处理方法
 * 
 * @author way
 * 
 */
public class InputThread extends Thread {
	private Socket socket;
	private OutputThread out;
	private OutputThreadMap map;
	private DataInputStream dis;
	private boolean tryDestroy = false;
	private static final int HeadBufferLength = 1024;

	private byte[] headBuffer = new byte[HeadBufferLength];
	private int headBufferIndex = 0;
	private byte[] boundaryBytes = new byte[36];//数据的边界bytes

	private int readLength;


	public InputThread(Socket socket, OutputThread out, OutputThreadMap map) {
		this.socket = socket;
		this.out = out;
		this.map = map;
		try {
			dis = new DataInputStream(socket.getInputStream());// 实例化对象输入流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (!tryDestroy) {
				//增加一个5分钟没有连接就断开 防止客户端意外断开
				readMessage();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 读消息以及处理消息，抛出异常
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void readMessage() throws IOException, ClassNotFoundException {
		while(!tryDestroy) {//数据未和并完整前一直循环,或者数据异常,断开连接
			while ((readLength = dis.read(headBuffer, headBufferIndex, HeadBufferLength - headBufferIndex)) > 0) {
				System.out.println("readLength:" + readLength);
				headBufferIndex += readLength;
				if(headBufferIndex >= 41){//判断有没有包头,大于等于41把协议类型也包含在内
					if(headBuffer[0] == TranProtocol.HEAD[0] && headBuffer[1] == TranProtocol.HEAD[1]
						&& headBuffer[38] == TranProtocol.LINE[0] && headBuffer[39] == TranProtocol.LINE[1]) {
						for(int i = 0; i < 36; i ++)
							boundaryBytes[i] = headBuffer[2+i];
						//有包头
					}
				}else{
					//断开socket,重连
//文件先保存到本地前  要判断数据尾格式对不对
					return;
				}

			}
		}
		System.out.println("完成接收");
		Object readObject = ois.readObject();// 从流中读取对象
		UserDao dao = UserDaoFactory.getInstance();// 通过dao模式管理后台
		if (readObject != null && readObject instanceof TranObject) {
			TranObject read_tranObject = (TranObject) readObject;// 转换成传输对象
			switch (read_tranObject.getType()) {
			case REGISTER:// 如果用户是注册
				User registerUser = (User) read_tranObject.getObject();
				int registerResult = dao.register(registerUser);
				System.out.println(MyDate.getDateCN() + " 新用户注册:"
						+ registerResult);
				// 给用户回复消息
				TranObject<User> register2TranObject = new TranObject<User>(
						TranObjectType.REGISTER);
				User register2user = new User();
				register2user.setId(registerResult);
				register2TranObject.setObject(register2user);
				out.setMessage(register2TranObject);
				break;
			case LOGIN:
				User loginUser = (User) read_tranObject.getObject();
				ArrayList<User> list = dao.login(loginUser);
				TranObject<ArrayList<User>> login2Object = new TranObject<ArrayList<User>>(
						TranObjectType.LOGIN);
				if (list != null) {// 如果登录成功
					TranObject<User> onObject = new TranObject<User>(
							TranObjectType.LOGIN);
					User login2User = new User();
					login2User.setId(loginUser.getId());
					onObject.setObject(login2User);
					for (OutputThread onOut : map.getAll()) {
						onOut.setMessage(onObject);// 广播一下用户上线
					}
					map.add(loginUser.getId(), out);// 先广播，再把对应用户id的写线程存入map中，以便转发消息时调用
					login2Object.setObject(list);// 把好友列表加入回复的对象中
				} else {
					login2Object.setObject(null);
				}
				out.setMessage(login2Object);// 同时把登录信息回复给用户

				System.out.println(MyDate.getDateCN() + " 用户："
						+ loginUser.getId() + " 上线了");
				break;
			case LOGOUT:// 如果是退出，更新数据库在线状态，同时群发告诉所有在线用户
				User logoutUser = (User) read_tranObject.getObject();
				int offId = logoutUser.getId();
				System.out
						.println(MyDate.getDateCN() + " 用户：" + offId + " 下线了");
				dao.logout(offId);
				isStart = false;// 结束自己的读循环
				map.remove(offId);// 从缓存的线程中移除
				out.setMessage(null);// 先要设置一个空消息去唤醒写线程
				out.setStart(false);// 再结束写线程循环

				TranObject<User> offObject = new TranObject<User>(
						TranObjectType.LOGOUT);
				User logout2User = new User();
				logout2User.setId(logoutUser.getId());
				offObject.setObject(logout2User);
				for (OutputThread offOut : map.getAll()) {// 广播用户下线消息
					offOut.setMessage(offObject);
				}
				break;
			case MESSAGE:// 如果是转发消息（可添加群发）
				// 获取消息中要转发的对象id，然后获取缓存的该对象的写线程
				int id2 = read_tranObject.getToUser();
				OutputThread toOut = map.getById(id2);
				if (toOut != null) {// 如果用户在线
					toOut.setMessage(read_tranObject);
				} else {// 如果为空，说明用户已经下线,回复用户
					TextMessage text = new TextMessage();
					text.setMessage("亲！对方不在线哦，您的消息将暂时保存在服务器");
					TranObject<TextMessage> offText = new TranObject<TextMessage>(
							TranObjectType.MESSAGE);
					offText.setObject(text);
					offText.setFromUser(0);
					out.setMessage(offText);
				}
				break;
			case REFRESH:
				List<User> refreshList = dao.refresh(read_tranObject
						.getFromUser());
				TranObject<List<User>> refreshO = new TranObject<List<User>>(
						TranObjectType.REFRESH);
				refreshO.setObject(refreshList);
				out.setMessage(refreshO);
				break;
			default:
				break;
			}
		}
	}
}
