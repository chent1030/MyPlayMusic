package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class SexActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        ib_sex = ((ImageButton) findViewById(R.id.ib_sex));

        ib_sex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_sex:
                this.finish();
                break;
        }
    }
}
