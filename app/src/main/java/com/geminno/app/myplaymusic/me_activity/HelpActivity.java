package com.geminno.app.myplaymusic.me_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.ProtoActivity;
import com.geminno.app.myplaymusic.R;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_help_return;
    private ImageButton ib_help_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ib_help_return = ((ImageButton) findViewById(R.id.ib_help_return));
        ib_help_1 = ((ImageButton) findViewById(R.id.ib_help_1));

        ib_help_return.setOnClickListener(this);
        ib_help_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_help_return:
                this.finish();
                break;
            case R.id.ib_help_1:
                startActivity(new Intent(this, ProtoActivity.class));
                break;
        }
    }
}
