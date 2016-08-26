package com.test.jni;

/**
 * Created by abu on 2016/8/4 14:15.
 */
public class NdkJniUtils {

    static {
        System.loadLibrary("YanboberJniLibName");   //defaultConfig.ndk.moduleName
    }

    public native String getCLanguageString();
}
