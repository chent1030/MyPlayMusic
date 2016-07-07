package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class BlackListActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_blacklist_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_list);

        ib_blacklist_1 = ((ImageButton) findViewById(R.id.ib_blacklist_1));

        ib_blacklist_1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_blacklist_1:
                this.finish();
                break;
        }

    }
}
