package com.geminno.app.myplaymusic;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geminno.app.myplaymusic.pojo.UserBean;
import com.geminno.app.myplaymusic.utils.IpUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class MainActivity extends AppCompatActivity implements TextWatcher,View.OnClickListener{

    private Button btn_forget;
    private Button bt2;
    private Button bt_login;
    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_forget = ((Button) findViewById(R.id.btn_forget));
        et_phone = ((EditText) findViewById(R.id.et_phone));
        et_password = ((EditText) findViewById(R.id.et_password));
        bt2 = ((Button) findViewById(R.id.bt2));
        bt_login = ((Button) findViewById(R.id.bt_login));

        et_phone.addTextChangedListener(this);
        et_password.addTextChangedListener(this);

        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,FindPasswordActivity.class);

                startActivity(intent);


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);

                startActivity(intent);

            }
        });

        bt_login.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("关闭");
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(!TextUtils.isEmpty(et_phone.getText().toString())&&!TextUtils.isEmpty(et_password.getText().toString())){
            bt_login.setBackgroundColor(Color.parseColor("#FF6091"));
            bt_login.setEnabled(true);
        }else{
            bt_login.setEnabled(false);
            bt_login.setBackgroundColor(Color.parseColor("#cccccc"));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                HttpUtils httpUtils=new HttpUtils();
                RequestParams params=new RequestParams();
                params.addBodyParameter("telephone",et_phone.getText().toString());
                params.addBodyParameter("password",et_password.getText().toString());

                httpUtils.send(HttpRequest.HttpMethod.POST
                        , IpUtils.IpAddress+"/WanYueAPP/index.php/home/user/login"
                        ,params
                        , new RequestCallBack<String>() {

                            @Override
                            public void onSuccess(ResponseInfo<String> responseInfo) {
                                Gson gson=new Gson();
                                UserBean userBean=gson.fromJson(responseInfo.result, UserBean.class);
                                UserBean.User user=userBean.data;
                                Toast.makeText(MainActivity.this,userBean.message,Toast.LENGTH_LONG).show();
                                if(userBean.code==200) {
                                    Intent intent = new Intent(MainActivity.this, NearActivity.class);
                                    intent.putExtra("user_id", user.user_id);
                                    IpUtils.userid=user.user_id;
                                    System.out.println(user.user_id);
                                    startActivity(intent);
                                    MainActivity.this.finish();
                                }
                            }

                            @Override
                            public void onFailure(HttpException e, String s) {

                            }
                        });

                break;
        }
    }
}
