package com.geminno.app.myplaymusic.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by Wenwen on 2016/7/8.
 *
 *
 */

//防止多次请求验证码的计时器
public class TimeCount extends CountDownTimer {

    private Button checking;

    public TimeCount(long millisInFuture, long countDownInterval,Button checking) {
        super(millisInFuture, countDownInterval);//参数依次为总时长，和计时的时间间隔
        this.checking=checking;
    }

    @Override
    public void onTick(long millisUntilFinished) {//计时显示过程
        checking.setClickable(false);
        checking.setBackgroundColor(0xffcccccc);
        checking.setText(millisUntilFinished/1000+"秒后重新验证");

    }

    @Override
    public void onFinish() {
        //计时触发完毕
        checking.setText("重新验证");
        checking.setClickable(true);
        checking.setBackgroundColor(Color.parseColor("#FF6091"));

    }
}
