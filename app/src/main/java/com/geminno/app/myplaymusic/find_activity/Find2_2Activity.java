package com.geminno.app.myplaymusic.find_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.R;


public class Find2_2Activity extends AppCompatActivity {

    private ImageView iv_back;

    private ImageView iv_prac_right;
    private Button btn_baoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2_2);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2_2Activity.this.finish();
            }
        });
        btn_baoming = ((Button) findViewById(R.id.btn_baoming));
        btn_baoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Find2_2Activity.this,"报名成功",Toast.LENGTH_SHORT);
            }
        });

        iv_prac_right = ((ImageView) findViewById(R.id.iv_prac_right));
        iv_prac_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Find2_2Activity.this,Find2_2_1Activity.class);
                Find2_2Activity.this.startActivity(i);
            }
        });
    }
}
