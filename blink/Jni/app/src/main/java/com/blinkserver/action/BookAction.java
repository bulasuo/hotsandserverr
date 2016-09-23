package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 15:08.
 */
public class BookAction implements ActionInterface{

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.BOOK__INSERT:

                break;
            case ActionInt.BOOK__DELETE:

                break;
            case ActionInt.BOOK__UPDATE:

                break;
            case ActionInt.BOOK__QUERY:

                break;
            default:
                break;
        }
    }
}
