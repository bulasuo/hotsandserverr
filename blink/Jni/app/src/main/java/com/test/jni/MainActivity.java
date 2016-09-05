package com.test.jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blinkserver.util.XUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.text);
        SlidingLinearLayout slidingLinearLayout = (SlidingLinearLayout) findViewById(R.id.slid);

        NdkJniUtils jni = new NdkJniUtils();

        textView.setText(jni.getCLanguageString());
        getPackageManager();
        slidingLinearLayout.init(100);

        Button tv_click = (Button) findViewById(R.id.tv_click);
        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("startHHH");
                        try {
                            Socket socket = new Socket();
                            socket.connect(new InetSocketAddress("192.168.1.107", 8080), 1000);
                            DataInputStream dis = null;
                            try {
                                dis = new DataInputStream(socket.getInputStream());// 实例化对象输入流
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            byte[] buf = new byte[256];

                            while(true){
                                System.out.println("read start");
                                int read = 0;
                                while((read = dis.read(buf, 0, 256)) != -1)
                                    System.out.println("read-"+read+":" + XUtil.bytes2HexString(buf));

                                System.out.println("read finish");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
