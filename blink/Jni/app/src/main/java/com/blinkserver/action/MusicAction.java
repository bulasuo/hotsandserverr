package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:24.
 */
public class MusicAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.MUSIC__INSERT:

                break;
            case ActionInt.MUSIC__DELETE:

                break;
            case ActionInt.MUSIC__UPDATE:

                break;
            case ActionInt.MUSIC__QUERY:

                break;
            default:
                break;
        }
    }
}

