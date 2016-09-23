package com.blinkserver.action;

import com.alibaba.fastjson.JSONObject;
import com.blinkserver.server.OutputThread;

/**
 * Created by abu on 2016/9/6 14:57.
 */
public class BlinkerAction implements ActionInterface {

    public static void doAction(OutputThread out, JSONObject json){
        switch(json.getIntValue(Key.ACTION)){
            case ActionInt.BLINK__BLINK:

                break;
            case ActionInt.BLINK__MY_BLINKERS:

                break;
            case ActionInt.BLINK__MY_BLINKS:

                break;
            case ActionInt.BLINK__UNBLINK:

                break;
            default:
                break;
        }
    }
}
