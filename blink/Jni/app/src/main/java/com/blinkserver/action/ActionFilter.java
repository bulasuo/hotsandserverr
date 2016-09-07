package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 09:09.
 */
public class ActionFilter implements ActionInterface{
    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(KEY.ACTION)){
            case VALUE.USER__REGIST:
            case VALUE.USER__LOGIN:
            case VALUE.USER__AGREEMENT:
            case VALUE.USER__UPDATE:
            case VALUE.USER__QUERY:
            case VALUE.USER_DETAIL__INSERT:
            case VALUE.USER_DETAIL__UPDATE:
            case VALUE.USER_DETAIL__QUERY:
            case VALUE.USER_GET_SMS:
                UserAction.doAction(out, json);
                break;
            case VALUE.BLINK__BLINK:
            case VALUE.BLINK__MY_BLINKERS:
            case VALUE.BLINK__MY_BLINKS:
            case VALUE.BLINK__UNBLINK:
                BlinkerAction.doAction(out, json);
                break;
            case VALUE.BOOK__INSERT:
            case VALUE.BOOK__DELETE:
            case VALUE.BOOK__UPDATE:
            case VALUE.BOOK__QUERY:
                BookAction.doAction(out, json);
                break;
            case VALUE.DYNAMIC__INSERT:
            case VALUE.DYNAMIC__DELETE:
            case VALUE.DYNAMIC__UPFATE:
            case VALUE.DYNAMIC__QUERY:
                DynamicAction.doAction(out, json);
                break;
            case VALUE.MOVIE__INSERT:
            case VALUE.MOVIE__DELETE:
            case VALUE.MOVIE__UPDATE:
            case VALUE.MOVIE__QUERY:
                MovieAction.doAction(out, json);
                break;
            case VALUE.MUSIC__INSERT:
            case VALUE.MUSIC__DELETE:
            case VALUE.MUSIC__UPDATE:
            case VALUE.MUSIC__QUERY:
                MusicAction.doAction(out, json);
                break;
            case VALUE.MV__INSERT:
            case VALUE.MV__DELETE:
            case VALUE.MV__UPDATE:
            case VALUE.MV__QUERY:
                MVAction.doAction(out, json);
                break;
            case VALUE.TOPIC__DELETE:
            case VALUE.TOPIC__INSERT:
            case VALUE.TOPIC__QUERY:
            case VALUE.TOPIC__UPDATE:
            case VALUE.TOPIC_REPLY__DELETE:
            case VALUE.TOPIC_REPLY__INSERT:
            case VALUE.TOPIC_REPLY__QUERY:
            case VALUE.TOPIC_REPLY__UPDATE:
            case VALUE.TOPIC_REPLY2__DELETE:
            case VALUE.TOPIC_REPLY2__INSERT:
            case VALUE.TOPIC_REPLY2__QUERY:
            case VALUE.TOPIC_REPLY2__UPDATE:
                TopicAction.doAction(out, json);
                break;
            default:
                // TODO: 2016/9/6 该action没有?
                break;
        }
    }
}
