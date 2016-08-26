package com.test.jni;

import android.app.Application;
import android.content.pm.PackageManager;

/**
 * Created by abu on 2016/8/8 15:41.
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("oncreate APP");
    }

    @Override
    public PackageManager getPackageManager() {System.out.println("getPackageManager");
        return super.getPackageManager();
    }
}
