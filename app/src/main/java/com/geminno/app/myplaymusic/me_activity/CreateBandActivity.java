package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class CreateBandActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_createBand_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_band);

        ib_createBand_return = ((TextView) findViewById(R.id.ib_createBand_return));

        ib_createBand_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_createBand_return:
                this.finish();
                break;
        }

    }
}
