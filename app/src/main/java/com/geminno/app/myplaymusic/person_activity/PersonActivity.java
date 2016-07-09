package com.geminno.app.myplaymusic.person_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class PersonActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView ib_screen_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        ib_screen_back = ((TextView) findViewById(R.id.ib_screen_back));
        ib_screen_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_screen_back:
                this.finish();
                break;
        }
    }
}
