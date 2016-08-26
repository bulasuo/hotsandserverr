package com.test.jni;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by abu on 2016/8/17 10:38.
 */
public class SlidingLinearLayout extends LinearLayout {
    private int xRelative;
    private int mLastMotionX;
    private boolean opened;
    private int extraWidth;
    public SlidingLinearLayout(Context context) {
        super(context);
    }

    public SlidingLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(int extraWidth){
        this.extraWidth = extraWidth;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:System.out.println("ACTION_DOWN-"+(int) event.getX());
                mLastMotionX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:System.out.println("ACTION_MOVE-"+(int) event.getX());
                final int x = (int) event.getX();
                xRelative = mLastMotionX - x;
                scrollBy(xRelative, 0);
                mLastMotionX = x;
                break;
            case MotionEvent.ACTION_UP:System.out.println("ACTION_UP-"+(int) event.getX()+"::-"+getScrollX()+"-"+xRelative+"-"+(extraWidth / 2));
                if(Math.abs(getScrollX()) > extraWidth / 2){
                    if(xRelative > 0)
                        open();
                    else
                        close();
                    xRelative = 0;
                }
                break;
        }
        return true;
    }

    private void open(){
        scrollTo(extraWidth, 0);
    }

    private void close(){
        scrollTo(0, 0);
    }

}
