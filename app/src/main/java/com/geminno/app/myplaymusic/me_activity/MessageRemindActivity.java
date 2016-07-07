package com.geminno.app.myplaymusic.me_activity;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class MessageRemindActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_messageremind_1;
    private ImageView iv_messageremind_1;
    private CheckBox cb_messageremind_1;
    private ImageView iv_messageremind_2;
    private CheckBox cb_messageremind_2;
    private ImageView iv_messageremind_3;
    private CheckBox cb_messageremind_3;
    private ImageView iv_messageremind_4;
    private CheckBox cb_messageremind_4;
    private ImageView iv_messageremind_5;
    private CheckBox cb_messageremind_5;

    ObjectAnimator oa=null;
    ObjectAnimator oa1=null;
    ObjectAnimator oa2=null;
    ObjectAnimator oa3=null;
    ObjectAnimator oa4=null;
    boolean flag=false;
    boolean flag1=false;
    boolean flag2=false;
    boolean flag3=false;
    boolean flag4=false;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    flag=(boolean) msg.obj;
                    break;
                case 2:
                    flag1=(boolean) msg.obj;
                    break;
                case 3:
                    flag2=(boolean) msg.obj;
                    break;
                case 4:
                    flag3=(boolean) msg.obj;
                    break;
                case 5:
                    flag4=(boolean) msg.obj;
                    break;
            }
        }
    };
    private RelativeLayout rl_messageremind;
    private RelativeLayout rl_messageremind_1;
    private RelativeLayout rl_messageremind_2;
    private TextView tv_messageremind_2;
    private TextView tv_messageremind_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_remind);
        tv_messageremind_3=((TextView) findViewById(R.id.tv_messageremind_3));
        tv_messageremind_2=((TextView) findViewById(R.id.tv_messageremind_2));
        rl_messageremind = ((RelativeLayout) findViewById(R.id.rl_messageremind));
        rl_messageremind_1 = ((RelativeLayout) findViewById(R.id.rl_remindmessage_1));
        rl_messageremind_2 = ((RelativeLayout) findViewById(R.id.rl_messageremind_2));
        ib_messageremind_1 = ((ImageButton) findViewById(R.id.ib_messageremind_1));
        iv_messageremind_1 = ((ImageView) findViewById(R.id.iv_messageremind_1));
        cb_messageremind_1 = ((CheckBox) findViewById(R.id.cb_messageremind_1));
        iv_messageremind_2 = ((ImageView) findViewById(R.id.iv_messageremind_2));
        cb_messageremind_2 = ((CheckBox) findViewById(R.id.cb_messageremind_2));
        iv_messageremind_3= ((ImageView) findViewById(R.id.iv_messageremind_3));
        cb_messageremind_3 = ((CheckBox) findViewById(R.id.cb_messageremind_3));
        iv_messageremind_4 = ((ImageView) findViewById(R.id.iv_messageremind_4));
        cb_messageremind_4 = ((CheckBox) findViewById(R.id.cb_messageremind_4));
        iv_messageremind_5 = ((ImageView) findViewById(R.id.iv_messageremind_5));
        cb_messageremind_5 = ((CheckBox) findViewById(R.id.cb_messageremind_5));

        ib_messageremind_1.setOnClickListener(this);
        iv_messageremind_1.setOnClickListener(this);
        cb_messageremind_1.setOnClickListener(this);
        iv_messageremind_2.setOnClickListener(this);
        cb_messageremind_2.setOnClickListener(this);
        iv_messageremind_3.setOnClickListener(this);
        cb_messageremind_3.setOnClickListener(this);
        iv_messageremind_4.setOnClickListener(this);
        cb_messageremind_4.setOnClickListener(this);
        iv_messageremind_5.setOnClickListener(this);
        cb_messageremind_5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ib_messageremind_1:
                this.finish();
                break;

            case R.id.cb_messageremind_1:
                if(flag==false) {
                    oa = ObjectAnimator.ofFloat(iv_messageremind_1, "translationX", 0, iv_messageremind_1.getWidth()/2+12);
                    Message msg = handler.obtainMessage();
                    msg.what = 1;
                    msg.obj = true;
                    handler.sendMessage(msg);
                    rl_messageremind.setVisibility(View.GONE);
                    rl_messageremind_1.setVisibility(View.GONE);
                    rl_messageremind_2.setVisibility(View.GONE);
                    tv_messageremind_2.setVisibility(View.GONE);
                    tv_messageremind_3.setVisibility(View.GONE);

                }
                if(flag==true){
                    oa = ObjectAnimator.ofFloat(iv_messageremind_1, "translationX", iv_messageremind_1.getWidth()/2+12,0);
                    Message msg = handler.obtainMessage();
                    msg.what = 1;
                    msg.obj = false;
                    handler.sendMessage(msg);
                    rl_messageremind.setVisibility(View.VISIBLE);
                    rl_messageremind_1.setVisibility(View.VISIBLE);
                    rl_messageremind_2.setVisibility(View.VISIBLE);
                    tv_messageremind_2.setVisibility(View.VISIBLE);
                    tv_messageremind_3.setVisibility(View.VISIBLE);
                }
                oa.setDuration(200);
                oa.start();
                break;

            case R.id.cb_messageremind_2:
                if(flag1==false) {
                    oa1 = ObjectAnimator.ofFloat(iv_messageremind_2, "translationX", 0, iv_messageremind_1.getWidth()/2+12);
                    Message msg = handler.obtainMessage();
                    msg.what = 2;
                    msg.obj = true;
                    handler.sendMessage(msg);
                }
                if(flag1==true){
                    oa1 = ObjectAnimator.ofFloat(iv_messageremind_2, "translationX", iv_messageremind_1.getWidth()/2+12, 0);
                    Message msg = handler.obtainMessage();
                    msg.what = 2;
                    msg.obj = false;
                    handler.sendMessage(msg);

                }
                oa1.setDuration(200);
                oa1.start();
                break;
            case R.id.cb_messageremind_3:
                if(flag2==false) {
                    oa2 = ObjectAnimator.ofFloat(iv_messageremind_3, "translationX", 0, iv_messageremind_1.getWidth()/2+12);
                    Message msg = handler.obtainMessage();
                    msg.what = 3;
                    msg.obj = true;
                    handler.sendMessage(msg);
                }
                if(flag2==true){
                    oa2 = ObjectAnimator.ofFloat(iv_messageremind_3, "translationX", iv_messageremind_1.getWidth()/2+12, 0);
                    Message msg = handler.obtainMessage();
                    msg.what = 3;
                    msg.obj = false;
                    handler.sendMessage(msg);

                }
                oa2.setDuration(200);
                oa2.start();
                break;
            case R.id.cb_messageremind_4:
                if(flag3==false) {
                    oa3 = ObjectAnimator.ofFloat(iv_messageremind_4, "translationX", 0, iv_messageremind_1.getWidth()/2+12);
                    Message msg = handler.obtainMessage();
                    msg.what = 4;
                    msg.obj = true;
                    handler.sendMessage(msg);
                }
                if(flag3==true){
                    oa3 = ObjectAnimator.ofFloat(iv_messageremind_4, "translationX", iv_messageremind_1.getWidth()/2+12, 0);
                    Message msg = handler.obtainMessage();
                    msg.what = 4;
                    msg.obj = false;
                    handler.sendMessage(msg);

                }
                oa3.setDuration(200);
                oa3.start();
                break;
            case R.id.cb_messageremind_5:
                if(flag4==false) {
                    oa4 = ObjectAnimator.ofFloat(iv_messageremind_5, "translationX", 0, iv_messageremind_1.getWidth()/2+12);
                    Message msg = handler.obtainMessage();
                    msg.what = 5;
                    msg.obj = true;
                    handler.sendMessage(msg);
                }
                if(flag4==true){
                    oa4 = ObjectAnimator.ofFloat(iv_messageremind_5, "translationX", iv_messageremind_1.getWidth()/2+12, 0);
                    Message msg = handler.obtainMessage();
                    msg.what = 5;
                    msg.obj = false;
                    handler.sendMessage(msg);

                }
                oa4.setDuration(200);
                oa4.start();
                break;
        }

    }
}
