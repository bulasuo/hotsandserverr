package com.blinkserver.server;

import com.blinkserver.Config;
import com.blinkserver.security.SecurityHS;
import com.blinkserver.util.MyDate;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
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
    private int sum = 0;

    public Server() {
        try {
            executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                    .availableProcessors() * 50);
            serverSocket = new ServerSocket();
//            serverSocket.setReceiveBufferSize(1024 * 10); //设置缓存区的大小
            serverSocket.bind(new InetSocketAddress(Config.SERVER_PORT));
        } catch (IOException e) {
            e.printStackTrace();
            quit();
        }
    }

    public void start() {
        try {
            System.out.println("服务器已启动... " + MyDate.getDateCN());
            while (isStarted) {
                socket = serverSocket.accept();
                socket.setKeepAlive(true);
                String ip = socket.getInetAddress().toString();
                if (socket.isConnected()) {
                    System.out.println(ip + " 已建立连接 "+ MyDate.getDateCN() + "\nsum:"+ ++sum);
                    executorService.execute(new SocketTask(socket));// 添加到线程池
                }
            }
            if (serverSocket != null)
                serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final class SocketTask implements Runnable {
        private Socket socket = null;
        private InputThread in;
        private OutputThread out;

        public SocketTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SecurityHS.RSAKeyParMaker mRSAKeyParMaker = new SecurityHS.RSAKeyParMaker();
                out = new OutputThread(socket);
                in = new InputThread(socket, out, mRSAKeyParMaker.privateKey);
                in.start();
                out.start();
                TranProtocol tranProtocol = new TranProtocol(TranProtocol.TP_SSH, mRSAKeyParMaker.publicKey);
                out.sendMessage(tranProtocol);
            } catch (Exception e) {
                out.tryDestroy();
                in.tryDestroy();
                e.printStackTrace();
                System.out.println("生成RSA秘钥对失败!");
            }

            try {
                final OutputThread outT = OutputThreadMap.add(socket.getInetAddress().getHostAddress(), out);
                if (outT != null && !outT.socket.isClosed()) {
                    outT.socket.shutdownInput();
                    outT.tryDestroy();
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("关闭上一个相同ip的socket出现异常!!");
            }
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
        //把图片文件夹检查一下 后面就不再判断了
        File file = new File(Config.IMG_PATH);
        if(!file.exists())
            file.mkdirs();
        new Server().start();
    }

    // TODO: 2016/9/9 要在凌晨4点扫一下所有连接, 僵尸连接就tryDestroy() 
    // TODO: 2016/9/18 唯一账户登入 设计 
}
