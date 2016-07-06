package com.geminno.app.myplaymusic.me_activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_cancername;
    private EditText et_name_1;
    private ImageButton ib_name_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        et_name_1=((EditText) findViewById(R.id.et_name_1));
        ib_name_1=((ImageButton) findViewById(R.id.ib_name_1));
        ib_cancername = ((ImageButton) findViewById(R.id.ib_cancername));
        ib_cancername.setOnClickListener(this);
        ib_name_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_cancername:
                et_name_1.setText("");
                break;
            case R.id.ib_name_1:
                this.finish();
                break;
        }

    }
}
