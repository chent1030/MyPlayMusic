package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class MusicStyleActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_musicstyle_return;
    private CheckBox cb_musicstyle_1;
    private CheckBox cb_musicstyle_2;
    private CheckBox cb_musicstyle_3;
    private CheckBox cb_musicstyle_4;
    private CheckBox cb_musicstyle_5;
    private CheckBox cb_musicstyle_6;
    private CheckBox cb_musicstyle_7;
    private CheckBox cb_musicstyle_8;
    private CheckBox cb_musicstyle_9;
    private CheckBox cb_musicstyle_10;
    private CheckBox cb_musicstyle_11;
    private CheckBox cb_musicstyle_12;
    private Button btn_musicstyle;
    ArrayList<CheckBox> cbList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_style);

        ib_musicstyle_return = ((TextView) findViewById(R.id.ib_musicstyle_return));
        ib_musicstyle_return.setOnClickListener(this);
        initview();
    }

    private void initview() {
        cbList=new ArrayList<CheckBox>();
        cb_musicstyle_1 = ((CheckBox) findViewById(R.id.cb_musicstyle_1));
        cb_musicstyle_2 = ((CheckBox) findViewById(R.id.cb_musicstyle_2));
        cb_musicstyle_3 = ((CheckBox) findViewById(R.id.cb_musicstyle_3));
        cb_musicstyle_4 = ((CheckBox) findViewById(R.id.cb_musicstyle_4));
        cb_musicstyle_5 = ((CheckBox) findViewById(R.id.cb_musicstyle_5));
        cb_musicstyle_6 = ((CheckBox) findViewById(R.id.cb_musicstyle_6));
        cb_musicstyle_7 = ((CheckBox) findViewById(R.id.cb_musicstyle_7));
        cb_musicstyle_8 = ((CheckBox) findViewById(R.id.cb_musicstyle_8));
        cb_musicstyle_9 = ((CheckBox) findViewById(R.id.cb_musicstyle_9));
        cb_musicstyle_10 = ((CheckBox) findViewById(R.id.cb_musicstyle_10));
        cb_musicstyle_11 = ((CheckBox) findViewById(R.id.cb_musicstyle_11));
        cb_musicstyle_12 = ((CheckBox) findViewById(R.id.cb_musicstyle_12));

        btn_musicstyle = ((Button) findViewById(R.id.btn_musicstyle));
        btn_musicstyle.setOnClickListener(this);
        cbList.add(cb_musicstyle_1);
        cbList.add(cb_musicstyle_2);
        cbList.add(cb_musicstyle_3);
        cbList.add(cb_musicstyle_4);
        cbList.add(cb_musicstyle_5);
        cbList.add(cb_musicstyle_6);
        cbList.add(cb_musicstyle_7);
        cbList.add(cb_musicstyle_8);
        cbList.add(cb_musicstyle_9);
        cbList.add(cb_musicstyle_10);
        cbList.add(cb_musicstyle_11);
        cbList.add(cb_musicstyle_12);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_musicstyle_return:
                this.finish();
                break;
            case R.id.btn_musicstyle:
                String musicstyle="";
                for (CheckBox checkBox : cbList) {
                    if(checkBox.isChecked()){
                        musicstyle+=checkBox.getText().toString();
                    }
                    HttpUtils httpUtils=new HttpUtils();
                    RequestParams params=new RequestParams();
                    params.addBodyParameter("userid",IpUtils.userid+"");
                    params.addBodyParameter("musicstyle",musicstyle);
                    httpUtils.send(HttpRequest.HttpMethod.POST,
                            IpUtils.IpAddress+"/WanYueEr/musicstyle.php",
                            params, new RequestCallBack<String>() {
                                @Override
                                public void onSuccess(ResponseInfo<String> responseInfo) {

                                    Gson gson=new Gson();
                                    ResultBean rb=gson.fromJson(responseInfo.result,ResultBean.class);
                                    if(rb.resultCode==200){
                                        Toast.makeText(MusicStyleActivity.this,rb.message,Toast.LENGTH_LONG).show();
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
