package com.blinkserver.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blinkserver.Config;
import com.blinkserver.server.OutputThread;
import com.blinkserver.server.TranObj;
import com.blinkserver.util.XUtil;

/**
 * Created by abu on 2016/9/6 14:29.
 */
public class UserAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json, TranObj tranObj){
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
                do_USER_GET_SMS(out, json, tranObj);
                break;
            default:
                break;
        }
    }

    private static void do_USER_GET_SMS(OutputThread out, JSONObject json, TranObj tranObj){
        JSONObject rjson;
        out.phone = json.getString(KEY.PHONE);
        try{
            rjson = JSON.parseObject(XUtil.getRequest(Config.SMS_API_URL+""))
        }


    }


}
