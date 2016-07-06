package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class MusicStyleActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_musicstyle_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_style);

        ib_musicstyle_return = ((ImageButton) findViewById(R.id.ib_musicstyle_return));

        ib_musicstyle_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_musicstyle_return:
                this.finish();
                break;

        }
    }
}
