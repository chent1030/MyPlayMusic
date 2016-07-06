package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class FamilarinstrumentActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_familarinstrument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familarinstrument);

        ib_familarinstrument = ((ImageButton) findViewById(R.id.ib_familarinstrument));
        ib_familarinstrument.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_familarinstrument:
                this.finish();
                break;
        }

    }
}
