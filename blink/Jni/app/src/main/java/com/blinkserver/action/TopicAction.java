package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:25.
 */
public class TopicAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(KEY.ACTION)){
            case VALUE.TOPIC__DELETE:

                break;
            case VALUE.TOPIC__INSERT:

                break;
            case VALUE.TOPIC__QUERY:

                break;
            case VALUE.TOPIC__UPDATE:

                break;
            case VALUE.TOPIC_REPLY__DELETE:

                break;
            case VALUE.TOPIC_REPLY__INSERT:

                break;
            case VALUE.TOPIC_REPLY__QUERY:

                break;
            case VALUE.TOPIC_REPLY__UPDATE:

                break;
            case VALUE.TOPIC_REPLY2__DELETE:

                break;
            case VALUE.TOPIC_REPLY2__INSERT:

                break;
            case VALUE.TOPIC_REPLY2__QUERY:

                break;
            case VALUE.TOPIC_REPLY2__UPDATE:

                break;
            default:
                break;
        }
    }
}

