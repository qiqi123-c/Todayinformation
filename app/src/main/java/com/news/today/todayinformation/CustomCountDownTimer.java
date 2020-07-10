package com.news.today.todayinformation;

import android.os.Handler;
import java.util.logging.LogRecord;

public class CustomCountDownTimer implements Runnable {
    //1.实时回调倒计时
    //2.支持传入总时间
    //3.每过一秒总时间减一
    //4.总时间倒计时为0时回调完成状态
    private int time;
    private int countDownTime;
    private final Handler handler;
    private final ICountDownHandler countDownHandler;
    private boolean isRun;
    public CustomCountDownTimer (int time,ICountDownHandler countDownHandler){
        handler=new Handler();
        this.time=time;
        this.countDownTime=time;
        this.countDownHandler=countDownHandler;
    }



    @Override
    public void run() {

        if (isRun)
        {
            if (countDownHandler!=null)
            {
                countDownHandler.onTicker(countDownTime);
            }
            if(countDownTime==0)
            {
                if(countDownHandler!=null)
                    countDownHandler.onFinish();
            }
            else{
                countDownTime=time--;
                handler.postDelayed(this,1000);
        }}
    }
public void start(){
        isRun=true;
        handler.post(this);
}

public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }
    public interface ICountDownHandler{
        void onTicker(int time);
        void onFinish();
    }
}
