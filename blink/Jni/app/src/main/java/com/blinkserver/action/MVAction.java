package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:24.
 */
public class MVAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(KEY.ACTION)){
            case VALUE.MV__INSERT:

                break;
            case VALUE.MV__DELETE:

                break;
            case VALUE.MV__UPDATE:

                break;
            case VALUE.MV__QUERY:

                break;
            default:
                break;
        }
    }
}

