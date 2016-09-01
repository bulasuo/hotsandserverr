package com.blinkserver.util;

/**
 * Created by abu on 2016/9/1 11:10.
 */
public class XUtil {
    public static byte[] intToByteArray(int i) {
        byte[] r = new byte[4];
        r[0] = (byte)((i >> 24) & 0xFF);
        r[1] = (byte)((i >> 16) & 0xFF);
        r[2] = (byte)((i >> 8) & 0xFF);
        r[3] = (byte)(i & 0xFF);
        return r;
    }
}
