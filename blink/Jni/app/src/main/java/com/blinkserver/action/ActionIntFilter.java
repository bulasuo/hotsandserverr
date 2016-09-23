package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;
import com.blinkserver.server.TranObj;

/**
 * 多个程序员开发时在此处分流ActionInt,在这之前要现在ActionIntInterface定义ActionInt并且不能与以前的ActionInt重复
 * Created by abu on 2016/9/6 09:09.
 */
public class ActionIntFilter implements ActionInterface {
    public static void doActionInt(OutputThread out, JSONObject json){
        //到此方法的数据包,数据包是合法的可能会有其他异常,比如参数非法什么的
        final TranObj tranObj = new TranObj();
        tranObj.action = ActionInt.USER_GET_SMS;
        try {
            tranObj.tag = json.getString(Key.TAG);
            switch (json.getIntValue(Key.ACTION)) {
                case ActionInt.USER__REGIST:
                case ActionInt.USER__LOGIN:
                case ActionInt.USER__AGREEMENT:
                case ActionInt.USER__UPDATE:
                case ActionInt.USER__QUERY:
                case ActionInt.USER_DETAIL__INSERT:
                case ActionInt.USER_DETAIL__UPDATE:
                case ActionInt.USER_DETAIL__QUERY:
                case ActionInt.USER_GET_SMS:
                    UserAction.doAction(out, json, tranObj);
                    break;
                case ActionInt.BLINK__BLINK:
                case ActionInt.BLINK__MY_BLINKERS:
                case ActionInt.BLINK__MY_BLINKS:
                case ActionInt.BLINK__UNBLINK:
                    BlinkerAction.doAction(out, json);
                    break;
                case ActionInt.BOOK__INSERT:
                case ActionInt.BOOK__DELETE:
                case ActionInt.BOOK__UPDATE:
                case ActionInt.BOOK__QUERY:
                    BookAction.doAction(out, json);
                    break;
                case ActionInt.DYNAMIC__INSERT:
                case ActionInt.DYNAMIC__DELETE:
                case ActionInt.DYNAMIC__UPFATE:
                case ActionInt.DYNAMIC__QUERY:
                    DynamicAction.doAction(out, json);
                    break;
                case ActionInt.MOVIE__INSERT:
                case ActionInt.MOVIE__DELETE:
                case ActionInt.MOVIE__UPDATE:
                case ActionInt.MOVIE__QUERY:
                    MovieAction.doAction(out, json);
                    break;
                case ActionInt.MUSIC__INSERT:
                case ActionInt.MUSIC__DELETE:
                case ActionInt.MUSIC__UPDATE:
                case ActionInt.MUSIC__QUERY:
                    MusicAction.doAction(out, json);
                    break;
                case ActionInt.MV__INSERT:
                case ActionInt.MV__DELETE:
                case ActionInt.MV__UPDATE:
                case ActionInt.MV__QUERY:
                    MVAction.doAction(out, json);
                    break;
                case ActionInt.TOPIC__DELETE:
                case ActionInt.TOPIC__INSERT:
                case ActionInt.TOPIC__QUERY:
                case ActionInt.TOPIC__UPDATE:
                case ActionInt.TOPIC_REPLY__DELETE:
                case ActionInt.TOPIC_REPLY__INSERT:
                case ActionInt.TOPIC_REPLY__QUERY:
                case ActionInt.TOPIC_REPLY__UPDATE:
                case ActionInt.TOPIC_REPLY2__DELETE:
                case ActionInt.TOPIC_REPLY2__INSERT:
                case ActionInt.TOPIC_REPLY2__QUERY:
                case ActionInt.TOPIC_REPLY2__UPDATE:
                    TopicAction.doAction(out, json);
                    break;
                default:
                    System.out.println("ActionInt::" + json.getIntValue(Key.ACTION));
                    // TODO: 2016/9/6 该ActionInt没有?
                    break;
            }
        }catch (Exception e){
            tranObj.message = e.getMessage();
            tranObj.code = -1;
            out.sendMessage(tranObj.formDefTranProtocol());
        }
    }
}
