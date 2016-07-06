package com.geminno.app.myplaymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PolicyActivity extends AppCompatActivity {

    private TextView tv_policy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        tv_policy = ((TextView) findViewById(R.id.tv_policy));

        tv_policy.setText("ccxxxxxxxxxxxxxxxxxxxx");
    }

    public void btn_return_policy(View view){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);

        this.finish();

    }

}
