package com.blinkserver.server;

import com.blinkserver.Config;
import com.blinkserver.util.MyDate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abu on 2016/8/31 09:14.
 */
public class Server {

    private ExecutorService executorService;
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private boolean isStarted = true;

    public Server() {
        try {
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                    .availableProcessors() * 50);
            serverSocket = new ServerSocket(Config.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            quit();
        }
    }

    public void start() {
        try {
            while (isStarted) {
                System.out.println(MyDate.getDateCN() + " 服务器已启动...");
                socket = serverSocket.accept();
                socket.setKeepAlive(true);
                System.out.println("客户端连接:");
                String ip = socket.getInetAddress().toString();
                System.out.println(MyDate.getDateCN() + " 用户：" + ip + " 已建立连接");
                if (socket.isConnected())
                    executorService.execute(new SocketTask(socket));// 添加到线程池
            }
            if (serverSocket != null)
                serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final class SocketTask implements Runnable {
        private Socket socket = null;
        private InputThread in;
        private OutputThread out;
        private OutputThreadMap map;

        public SocketTask(Socket socket) {
            this.socket = socket;
            map = OutputThreadMap.getInstance();
        }

        @Override
        public void run() {
            out = new OutputThread(socket, map);
            in = new InputThread(socket, out, map);
            in.start();
            out.start();
        }
    }

    /**
     * 退出
     */
    public void quit() {
        try {
            this.isStarted = false;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().start();

    }
}
