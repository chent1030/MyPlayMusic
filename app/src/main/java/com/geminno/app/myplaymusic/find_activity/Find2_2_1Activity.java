package com.geminno.app.myplaymusic.find_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.geminno.app.myplaymusic.R;


public class Find2_2_1Activity extends AppCompatActivity {

    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2_2_1);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2_2_1Activity.this.finish();
            }
        });
    }
}
