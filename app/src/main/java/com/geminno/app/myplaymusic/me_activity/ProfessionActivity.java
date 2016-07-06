package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class ProfessionActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_profession_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        ib_profession_return = ((ImageButton) findViewById(R.id.ib_profession_return));
        ib_profession_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_profession_return:
                this.finish();
                break;
        }
    }
}
