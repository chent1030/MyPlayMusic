package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class PerformanceLevelActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_musicase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_level);

        ib_musicase = ((TextView) findViewById(R.id.ib_musicage));
        ib_musicase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_musicage:
                this.finish();
                break;
        }

    }
}
