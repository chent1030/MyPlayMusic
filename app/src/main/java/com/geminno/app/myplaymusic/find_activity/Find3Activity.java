package com.geminno.app.myplaymusic.find_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.geminno.app.myplaymusic.R;


public class Find3Activity extends AppCompatActivity {
    ImageView iv_back;
    private ImageView iv_prac_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find3);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find3Activity.this.finish();
            }
        });
        iv_prac_right = ((ImageView) findViewById(R.id.iv_prac_right));
        iv_prac_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Find3Activity.this,Find3_1Activity.class);
                Find3Activity.this.startActivity(i);

            }
        });
    }
}