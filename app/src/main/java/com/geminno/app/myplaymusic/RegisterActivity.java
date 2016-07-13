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

import com.geminno.app.myplaymusic.pojo.RegisterBean;
import com.geminno.app.myplaymusic.utils.IpUtils;
import com.geminno.app.myplaymusic.utils.MyUtils;
import com.geminno.app.myplaymusic.utils.TimeCount;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.mob.commons.SMSSDK;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    Gson gson=new Gson();
//                    RegisterBean rb=gson.fromJson(((StringBuilder)msg.obj).toString(),RegisterBean.class);
//                    System.out.println(rb.message);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化SDK
//        cn.smssdk.SMSSDK.initSDK(this,"14b9581e3a77e","53aa664f91de74bf8af04dcfe2f71ec6");
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

//        final Handler handler=new Handler();
//        EventHandler eventHandler=new EventHandler(){
//            @Override
//            public void afterEvent(int event, int result, Object data) {
//                Message msg=new Message();
//                msg.arg1=event;
//                msg.arg2=result;
//                msg.obj=data;
//                handler.sendMessage(msg);
//            }
//        };
//        cn.smssdk.SMSSDK.registerEventHandler(eventHandler);//注册短信回调


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
//                    cn.smssdk.SMSSDK.getVerificationCode("86",str_phone);
                    str_str_phone=str_phone;
                    time.start();
                }
                break;
            case R.id.btn_register:
//                String str_et2=et2.getText().toString();
//                cn.smssdk.SMSSDK.submitVerificationCode("86",str_str_phone,str_et2);
               final String et1_1=et1.getText().toString();
                final String et3_3=et3.getText().toString();
                final String et5_5=et5.getText().toString();
                final String et4_4=et4.getText().toString();
                if(et3_3.length()<6||et3_3.length()>=12){
                    Toast.makeText(RegisterActivity.this,"密码为6-12个字符",Toast.LENGTH_LONG).show();
                }else{
                                if(et3_3.equals(et4_4)) {

                                    HttpUtils httpUtils=new HttpUtils();
                                    RequestParams params=new RequestParams();
                                    params.addBodyParameter("telephone",et1_1);
                                    params.addBodyParameter("password",et3_3);
                                    params.addBodyParameter("nickname",et5_5);

                                    httpUtils.send(HttpRequest.HttpMethod.POST
                                            , IpUtils.IpAddress+"/WanYueAPP/index.php/home/user/register"
                                            ,params, new RequestCallBack<String>() {
                                                @Override
                                                public void onLoading(long total, long current, boolean isUploading) {
                                                    Toast.makeText(RegisterActivity.this,"注册中",Toast.LENGTH_LONG).show();
                                                }

                                                @Override
                                                public void onSuccess(ResponseInfo<String> responseInfo) {
                                                    System.out.println(responseInfo.result);
                                                    Gson gson=new Gson();
                                                    RegisterBean registerBean=gson.fromJson(responseInfo.result, RegisterBean.class);
                                                    System.out.println(registerBean.code);
                                                    System.out.println(registerBean.id);
                                                    Toast.makeText(RegisterActivity.this,registerBean.message,Toast.LENGTH_LONG).show();
                                                }
                                                @Override
                                                public void onFailure(HttpException e, String s) {
                                                    Toast.makeText(RegisterActivity.this,"访问失败",Toast.LENGTH_LONG).show();
                                                }
                                            });
//                                    new Thread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            String path="http://192.168.30.33:80/WanYueAPP/index.php/home/user/register";
//
//                                            try {
//                                                URL url=new URL(path);
//                                                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
//                                                conn.setRequestMethod("POST");
//                                                conn.setConnectTimeout(5000);
//                                                conn.setReadTimeout(3000);
//                                                //设置请求常用属性
//
//                                                String data="telephone="+et1_1+"&password="+et3_3+"&nickname="+et5_5;
//                                                conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//                                                conn.setRequestProperty("Content-Length",data.length()+"");
//
//                                                //打开输出流
//                                                conn.setDoOutput(true);
//                                                OutputStream os=conn.getOutputStream();
//                                                os.write(data.getBytes());
//
//                                                int code=conn.getResponseCode();
//                                                System.out.println(code);
//
//                                                if(code==200){
//                                                    InputStream is=conn.getInputStream();
//                                                    byte[] bytes=new byte[1024];
//                                                    int length=-1;
//                                                    StringBuilder sb=new StringBuilder("");
//                                                    while((length=is.read(bytes))!=-1){
//                                                        sb.append(new String(bytes,0,length));
//                                                    }
//
//                                                    Message msg=handler.obtainMessage();
//                                                    msg.obj=sb;
//                                                    msg.what=1;
//                                                    handler.sendMessage(msg);
//
//                                                }
//
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }
//
//                                        }
//                                    }).start();
                                }else{
                                    Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_LONG).show();
                                }
                }

                break;
        }
    }


    @Override
    protected void onDestroy() {
//        cn.smssdk.SMSSDK.unregisterAllEventHandler();
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

