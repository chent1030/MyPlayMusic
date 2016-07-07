package com.geminno.app.myplaymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProtoActivity extends AppCompatActivity {

    private TextView tv_proto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proto);

        tv_proto = ((TextView) findViewById(R.id.tv_proto));
        tv_proto.setText("xxxxxxxxxxxxxxxxxx");
    }

    public void btn_return_proto(View view){


        this.finish();
    }
}
