package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:09.
 */
public class DynamicAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.DYNAMIC__INSERT:

                break;
            case ActionInt.DYNAMIC__DELETE:

                break;
            case ActionInt.DYNAMIC__UPFATE:

                break;
            case ActionInt.DYNAMIC__QUERY:

                break;
            default:
                break;
        }
    }
}