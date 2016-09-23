package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:11.
 */
public class MovieAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.MOVIE__INSERT:

                break;
            case ActionInt.MOVIE__DELETE:

                break;
            case ActionInt.MOVIE__UPDATE:

                break;
            case ActionInt.MOVIE__QUERY:

                break;
            default:
                break;
        }
    }
}
