package com.geminno.app.myplaymusic.find_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;


public class Find2_1Activity extends AppCompatActivity {

    private ImageView iv_back;
    private ImageView iv_prac_right;
    private TextView tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2_1);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        tv_back = ((TextView) findViewById(R.id.tv_back));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2_1Activity.this.finish();
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2_1Activity.this.finish();
            }
        });


        iv_prac_right = ((ImageView) findViewById(R.id.iv_prac_right));
        iv_prac_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Find2_1Activity.this,Find2_1_1Activity.class);
                Find2_1Activity.this.startActivity(i);

            }
        });
    }
}
