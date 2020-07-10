package com.news.today.todayinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

import java.util.jar.Attributes;

public class FullScreenVideoView extends VideoView {
    //主要用于直接new出来的对象
    public FullScreenVideoView(Context context)
    {
        super(context);
    }
    //xml中，支持自定义属性
    public FullScreenVideoView(Context context, AttributeSet attrs)
    {
        super(context,attrs);
    }
    //同时支持style样式
    public FullScreenVideoView(Context context,AttributeSet attrs,int def)
    {
        super(context,attrs,def);
    }

    @Override
    //全屏
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSepc包含两个主要内容 1、测量模式 2、测量大小
        int width=getDefaultSize(0,widthMeasureSpec);
        int height=getDefaultSize(0,heightMeasureSpec);
        setMeasuredDimension(width,height);
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
