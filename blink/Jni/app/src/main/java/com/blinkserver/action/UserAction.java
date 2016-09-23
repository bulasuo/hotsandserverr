package com.blinkserver.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blinkserver.Config;
import com.blinkserver.server.OutputThread;
import com.blinkserver.server.TranObj;
import com.blinkserver.util.XUtil;

import java.net.URLEncoder;

/**
 * Created by abu on 2016/9/6 14:29.
 */
public class UserAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json, TranObj tranObj) throws Exception{
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.USER__REGIST:

                break;
            case ActionInt.USER__LOGIN:

                break;
            case ActionInt.USER__AGREEMENT:

                break;
            case ActionInt.USER__UPDATE:

                break;
            case ActionInt.USER__QUERY:

                break;
            case ActionInt.USER_DETAIL__INSERT:

                break;
            case ActionInt.USER_DETAIL__UPDATE:

                break;
            case ActionInt.USER_DETAIL__QUERY:

                break;
            case ActionInt.USER_GET_SMS:
                do_USER_GET_SMS(out, json, tranObj);
                break;
            default:
                break;
        }
    }

    private static void do_USER_GET_SMS(OutputThread out, JSONObject json, TranObj tranObj) throws Exception{
        JSONObject rjson;
        out.phone = json.getString(Key.PHONE);
        out.checkCode = String.valueOf((int) (Math.random() * 1000000));
        rjson = JSON.parseObject(XUtil.getRequest(Config.SMS_API_URL, "&mobile="+out.phone+"&tpl_value="+ URLEncoder.encode(out.checkCode, "utf-8")));
        String message = null;
        switch(rjson.getIntValue(Key.ERROR_CODE)){
            case 0:
                message = "短信发送成功";
                tranObj.message = message;
                out.sendMessage(tranObj.formDefTranProtocol());
                return;
            case 1:
                message = "err_1:短信过期";
                break;
            case 2:
                message = "err_2:短信不可达";
                break;
            case 3:
                message = "err_3:短信状态未知";
                break;
            case 4:
                message = "err_4:短信被短信中心拒绝";
                break;
            case 5:
                message = "err_5:目的号码是黑名单号码";
                break;
            case 6:
                message = "err_6:网关内部状态";
                break;
            case 7:
                message = "err_7:审核驳回";
                break;
            case 8:
                message = "err_8:网关内部状态";
                break;
        }
        //code!=0,短信没有发送成功
        throw new Exception(message);



    }


}
