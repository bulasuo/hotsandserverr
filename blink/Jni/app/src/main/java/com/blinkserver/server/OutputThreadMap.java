package com.blinkserver.server;

import java.util.HashMap;


/**
 * 存放写线程的缓存器
 * @author   abu   2016/9/5   13:45
 */
public class OutputThreadMap {
	private static HashMap<Integer, OutputThread> id_map = new HashMap<>();//已经登录账户的线程map
	private static HashMap<String, OutputThread> ip_map = new HashMap<>();//正在连接的线程map

	// 添加写线程的方法
	public static OutputThread add(Integer id, OutputThread out) {
		synchronized(id_map) {
			return id_map.put(id, out);
		}
	}

	// 移除写线程的方法
	public static void remove(Integer id) {
		synchronized(id_map) {
			id_map.remove(id);
		}
	}

	// 取出写线程的方法,群聊的话，可以遍历取出对应写线程
	public static OutputThread getById(Integer id) {
		synchronized(id_map) {
			return id_map.get(id);
		}
	}


	// 添加写线程的方法
	public static OutputThread add(String ip, OutputThread out) {
		synchronized(ip_map) {
			return ip_map.put(ip, out);
		}
	}

	// 移除写线程的方法
	public static void remove(String ip) {
		synchronized(ip_map) {
			ip_map.remove(ip);
		}
	}

	// 取出写线程的方法,群聊的话，可以遍历取出对应写线程
	public static OutputThread getByIp(String ip) {
		synchronized(ip_map) {
			return ip_map.get(ip);
		}
	}

}
