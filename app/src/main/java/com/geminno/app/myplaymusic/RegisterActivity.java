package com.geminno.app.myplaymusic;


import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.utils.MyUtils;
import com.geminno.app.myplaymusic.utils.TimeCount;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
import com.mob.commons.SMSSDK;

import cn.smssdk.EventHandler;
import rx.functions.Action1;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher{


    Intent intent;
    private Button btn_return;
    private TextView btn_protocol;
    private TextView btn_policy;
    private Button btn_register;
    private CheckBox cb;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private Button btn_verifycode;
    private TimeCount time;
    String str_phone,str_str_phone;
    boolean flag=false;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int result=msg.arg1;
            int event=msg.arg2;
            Object data=msg.obj;
            if(result== cn.smssdk.SMSSDK.RESULT_COMPLETE){
                if(event== cn.smssdk.SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                    Toast.makeText(RegisterActivity.this,"验证成功",Toast.LENGTH_LONG).show();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化SDK
        cn.smssdk.SMSSDK.initSDK(this,"14b9581e3a77e","53aa664f91de74bf8af04dcfe2f71ec6");
        initview();

    }

    public void initview(){

        btn_return = ((Button) findViewById(R.id.btn_return));
        btn_protocol = ((TextView) findViewById(R.id.btn_protocol));
        btn_policy = ((TextView) findViewById(R.id.btn_policy));
        btn_register = ((Button) findViewById(R.id.btn_register));
        cb = ((CheckBox) findViewById(R.id.cb));
        et1 = ((EditText) findViewById(R.id.et1_1));
        et2 = ((EditText) findViewById(R.id.et2_1));
        et3 = ((EditText) findViewById(R.id.et3_1));
        et4 = ((EditText) findViewById(R.id.et4_1));
        et5 = ((EditText) findViewById(R.id.et5_1));


        btn_protocol.setOnClickListener(this);
        btn_return.setOnClickListener(this);
        btn_policy.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        EventHandler eventHandler=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg=new Message();
                msg.arg1=event;
                msg.arg2=result;
                msg.obj=data;
                handler.sendMessage(msg);
            }
        };
        cn.smssdk.SMSSDK.registerEventHandler(eventHandler);//注册短信回调


        btn_verifycode = ((Button) findViewById(R.id.btn_verifycode));
        time=new TimeCount(60000,1000,btn_verifycode);//构造CountDownTimer对象
        btn_verifycode.setOnClickListener(this);




        et1.addTextChangedListener(this);
        et2.addTextChangedListener(this);
        et3.addTextChangedListener(this);
        et4.addTextChangedListener(this);
        et5.addTextChangedListener(this);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked&&flag){
                    btn_register.setBackgroundColor(Color.parseColor("#FF6091"));
                    btn_register.setEnabled(true);
                }else{
                    Toast.makeText(RegisterActivity.this,"请选择使用协议",Toast.LENGTH_LONG).show();
                    btn_register.setBackgroundColor(Color.parseColor("#cccccc"));
                    btn_register.setEnabled(false);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_protocol:
                intent=new Intent(this,ProtoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_return:
                this.finish();
                break;
            case R.id.btn_policy:
                intent=new Intent(this,PolicyActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_verifycode:

                str_phone=et1.getText().toString().trim();

                if(TextUtils.isEmpty(str_phone)){
                    Toast.makeText(RegisterActivity.this,"手机号不能为空",Toast.LENGTH_LONG).show();
                }else if(!MyUtils.isMobileNO(str_phone)){
                    Toast.makeText(RegisterActivity.this,"请输入正确的手机号格式",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RegisterActivity.this,"发送成功",Toast.LENGTH_LONG).show();
                    // 下面的代码就是调用sdk的发送短信的方法，其中的“86”是官方中定义的，代表中国的意思
                    // 第二个参数表示的是需要发送短信的手机号
                    cn.smssdk.SMSSDK.getVerificationCode("86",str_phone);
                    str_str_phone=str_phone;
                    time.start();
                }
                break;
            case R.id.btn_register:
                String str_et2=et2.getText().toString();
                cn.smssdk.SMSSDK.submitVerificationCode("86",str_str_phone,str_et2);

                String et3_3=et3.getText().toString();
                String et4_4=et4.getText().toString();
                if(et3_3.length()<6||et3_3.length()>=12){
                    Toast.makeText(RegisterActivity.this,"密码为6-12个字符",Toast.LENGTH_LONG).show();
                }else{
                                if(et3_3.equals(et4_4)) {
                                    Toast.makeText(RegisterActivity.this, "注册成功，跳转", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_LONG).show();
                                }
                }
                break;
        }
    }


    @Override
    protected void onDestroy() {
        cn.smssdk.SMSSDK.unregisterAllEventHandler();
        super.onDestroy();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(!TextUtils.isEmpty(et1.getText().toString())&&!TextUtils.isEmpty(et2.getText().toString())
        &&!TextUtils.isEmpty(et3.getText().toString())&&!TextUtils.isEmpty(et4.getText().toString())
                &&!TextUtils.isEmpty(et5.getText().toString())){
           flag=true;
            if(cb.isChecked()){
                btn_register.setBackgroundColor(Color.parseColor("#FF6091"));
                btn_register.setEnabled(true);
            }

        }else{
            flag=false;
            btn_register.setBackgroundColor(Color.parseColor("#cccccc"));
            btn_register.setEnabled(false);
        }

    }
}

