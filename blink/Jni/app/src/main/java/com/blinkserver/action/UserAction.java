package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 14:29.
 */
public class UserAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(KEY.ACTION)){
            case VALUE.USER__REGIST:

                break;
            case VALUE.USER__LOGIN:

                break;
            case VALUE.USER__AGREEMENT:

                break;
            case VALUE.USER__UPDATE:

                break;
            case VALUE.USER__QUERY:

                break;
            case VALUE.USER_DETAIL__INSERT:

                break;
            case VALUE.USER_DETAIL__UPDATE:

                break;
            case VALUE.USER_DETAIL__QUERY:

                break;
            case VALUE.USER_GET_SMS:

                break;
            default:
                break;
        }
    }

    private static void do_USER_GET_SMS(OutputThread out, JSONObject json){

    }


}
