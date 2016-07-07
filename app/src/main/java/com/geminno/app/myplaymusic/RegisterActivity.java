package com.geminno.app.myplaymusic;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxCompoundButton;

import rx.functions.Action1;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{


    Intent intent;
    private Button btn_return;
    private TextView btn_protocol;
    private TextView btn_policy;
    private Button btn_register;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_return = ((Button) findViewById(R.id.btn_return));
        btn_protocol = ((TextView) findViewById(R.id.btn_protocol));
        btn_policy = ((TextView) findViewById(R.id.btn_policy));
        btn_register = ((Button) findViewById(R.id.btn_register));
        cb = ((CheckBox) findViewById(R.id.cb));

        RxCompoundButton.checkedChanges(cb)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        btn_register.setEnabled(aBoolean);
                        btn_register.setBackgroundResource(aBoolean?R.color.button_yes:R.color.button_no);
                    }
                });

        btn_protocol.setOnClickListener(this);
        btn_return.setOnClickListener(this);
        btn_policy.setOnClickListener(this);

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
        }
    }
}

