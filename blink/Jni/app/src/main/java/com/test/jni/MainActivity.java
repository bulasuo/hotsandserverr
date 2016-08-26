package com.test.jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

    }
}
