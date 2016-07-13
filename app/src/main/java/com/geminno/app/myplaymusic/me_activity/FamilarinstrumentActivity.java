package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.pojo.ResultBean;
import com.geminno.app.myplaymusic.utils.IpUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

public class FamilarinstrumentActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_familarinstrument;
    int user_id;
    private CheckBox cb_fs1;
    private CheckBox cb_fs2;
    private CheckBox cb_fs3;
    private CheckBox cb_fs4;
    private CheckBox cb_fs5;
    private CheckBox cb_fs6;
    private CheckBox cb_fs7;
    private CheckBox cb_fs8;
    private CheckBox cb_fs9;

    private Button btn_familarinstrument_1;
    ArrayList<CheckBox> cbList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familarinstrument);
        user_id=getIntent().getIntExtra("user_id",1);
        ib_familarinstrument = ((TextView) findViewById(R.id.ib_familarinstrument));
        ib_familarinstrument.setOnClickListener(this);
        initView();
    }

    private void initView() {
        btn_familarinstrument_1 = ((Button) findViewById(R.id.btn_familarinstrument_1));
        btn_familarinstrument_1.setOnClickListener(this);
        cbList=new ArrayList<CheckBox>();

        cb_fs1 = ((CheckBox) findViewById(R.id.cb_fs1));
        cb_fs2 = ((CheckBox) findViewById(R.id.cb_fs2));
        cb_fs3 = ((CheckBox) findViewById(R.id.cb_fs3));
        cb_fs4 = ((CheckBox) findViewById(R.id.cb_fs4));
        cb_fs5 = ((CheckBox) findViewById(R.id.cb_fs5));
        cb_fs6 = ((CheckBox) findViewById(R.id.cb_fs6));
        cb_fs7 = ((CheckBox) findViewById(R.id.cb_fs7));
        cb_fs8 = ((CheckBox) findViewById(R.id.cb_fs8));
        cb_fs9 = ((CheckBox) findViewById(R.id.cb_fs9));



        cbList.add(cb_fs1);
        cbList.add(cb_fs2);
        cbList.add(cb_fs3);
        cbList.add(cb_fs4);
        cbList.add(cb_fs5);
        cbList.add(cb_fs6);
        cbList.add(cb_fs7);
        cbList.add(cb_fs8);
        cbList.add(cb_fs9);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_familarinstrument:
                this.finish();
                break;
            case R.id.btn_familarinstrument_1:
                String instrument="";
                for (CheckBox checkBox : cbList) {
                    if(checkBox.isChecked()){
                        instrument+=checkBox.getText().toString();
                    }
                    HttpUtils httpUtils=new HttpUtils();
                    RequestParams params=new RequestParams();
                    params.addBodyParameter("userid",user_id+"");
                    params.addBodyParameter("instrument",instrument);
                    System.out.println(user_id);
                    System.out.println(instrument);
                    httpUtils.send(HttpRequest.HttpMethod.POST,
                            IpUtils.IpAddress+"/WanYueEr/goodinstrument.php",
                            params, new RequestCallBack<String>() {
                                @Override
                                public void onSuccess(ResponseInfo<String> responseInfo) {

                                    Gson gson=new Gson();
                                    ResultBean rb=gson.fromJson(responseInfo.result,ResultBean.class);
                                    if(rb.resultCode==200){
                                        Toast.makeText(FamilarinstrumentActivity.this,rb.message,Toast.LENGTH_LONG).show();
                                    }

                                }

                                @Override
                                public void onFailure(HttpException e, String s) {

                                }
                            });


                }
        }

    }



}
