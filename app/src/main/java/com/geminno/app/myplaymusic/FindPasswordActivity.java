package com.geminno.app.myplaymusic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geminno.app.myplaymusic.utils.MyUtils;
import com.geminno.app.myplaymusic.utils.TimeCount;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class FindPasswordActivity extends AppCompatActivity implements TextWatcher,View.OnClickListener{

    private Button btn_close;
    private Button btn_verifycode_forgetpassword;
    private Button btn_return;
    private Button btn_save;
    private EditText et_phone_forgetpassword;
    private EditText et_verifycode_forgetpassword;
    private EditText et_newpassword;
    private EditText et_ms_newpassword;
    String phone_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);

//        initSDK();

        btn_close = ((Button) findViewById(R.id.btn_close));
        btn_return = ((Button) findViewById(R.id.btn_return));
        btn_save = ((Button) findViewById(R.id.btn_save));
        btn_verifycode_forgetpassword = ((Button) findViewById(R.id.btn_verifycode_forgetpassword));

        et_phone_forgetpassword=((EditText)findViewById(R.id.et_phone_forgetpassword));
        et_verifycode_forgetpassword=((EditText)findViewById(R.id.et_verifycode_forgetpassword));
        et_newpassword=((EditText)findViewById(R.id.et_newpassword));
        et_ms_newpassword=((EditText)findViewById(R.id.et_ms_newpassword));

        et_phone_forgetpassword.addTextChangedListener(this);
        et_verifycode_forgetpassword.addTextChangedListener(this);
        et_newpassword.addTextChangedListener(this);
        et_ms_newpassword.addTextChangedListener(this);

        btn_verifycode_forgetpassword.setOnClickListener(this);
        btn_save.setOnClickListener(this);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               FindPasswordActivity.this.finish();
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FindPasswordActivity.this.finish();
            }
        });
    }

//    private void initSDK() {
//
//        SMSSDK.initSDK(this,"14b9581e3a77e","53aa664f91de74bf8af04dcfe2f71ec6");
//
//        final Handler hanlder=new Handler();
//        EventHandler eh=new EventHandler(){
//            @Override
//            public void afterEvent(int result, int event, Object data) {
//                Message msg=hanlder.obtainMessage();
//                msg.arg1=result;
//                msg.arg2=event;
//                msg.obj=data;
//                hanlder.sendMessage(msg);
//
//            }
//        };
//        SMSSDK.registerEventHandler(eh);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_verifycode_forgetpassword:
                if(TextUtils.isEmpty(et_phone_forgetpassword.getText().toString())){
                    Toast.makeText(this,"手机号不能为空",Toast.LENGTH_LONG).show();
                }else if(!MyUtils.isMobileNO(et_phone_forgetpassword.getText().toString())){
                    Toast.makeText(this,"请输入正确的手机号格式",Toast.LENGTH_LONG).show();
                }else{
                    TimeCount time=new TimeCount(60000,1000,btn_verifycode_forgetpassword);
//                    SMSSDK.getVerificationCode("86",et_phone_forgetpassword.getText().toString());
                    phone_new=et_phone_forgetpassword.getText().toString();
                    time.start();
                }
                break;
            case R.id.btn_save:

//                String et_ver=et_verifycode_forgetpassword.getText().toString();
//                SMSSDK.submitVerificationCode("86",phone_new,et_ver);

                if(!MyUtils.isPassword(et_newpassword.getText().toString())){
                    new AlertDialog.Builder(this).setTitle("提示")
                            .setMessage("新密码必须同时包含数字和字母,长度6至12位")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create().show();
                }else{
                    if(et_ms_newpassword.getText().toString().equals(et_newpassword.getText().toString())){
                        new AlertDialog.Builder(this).setTitle("提示")
                                .setMessage("密码修改成功")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).create().show();
                    }else{
                        Toast.makeText(this,"两次输入的密码不一致",Toast.LENGTH_LONG).show();
                    }
                }
                break;

        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if(!TextUtils.isEmpty(et_phone_forgetpassword.getText().toString())
                &&!TextUtils.isEmpty(et_verifycode_forgetpassword.getText().toString())
                &&!TextUtils.isEmpty(et_newpassword.getText().toString())
                &&!TextUtils.isEmpty(et_ms_newpassword.getText().toString())){

            btn_save.setEnabled(true);
            btn_save.setBackgroundColor(Color.parseColor("#FF6091"));

        }else{
            btn_save.setEnabled(false);
            btn_save.setBackgroundColor(Color.parseColor("#cccccc"));
        }
    }
}
