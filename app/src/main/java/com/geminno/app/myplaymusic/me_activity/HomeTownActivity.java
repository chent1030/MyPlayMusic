package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class HomeTownActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_hometown_1;
    private ImageButton ib_hometown_2;
    private EditText et_hometown_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_town);

        ib_hometown_1 = ((ImageButton) findViewById(R.id.ib_hometown_1));
        ib_hometown_2=((ImageButton) findViewById(R.id.ib_hometown_2));
        et_hometown_1=((EditText) findViewById(R.id.et_hometown_1));

        ib_hometown_1.setOnClickListener(this);
        ib_hometown_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_hometown_1:
                this.finish();
                break;
            case R.id.ib_hometown_2:
                et_hometown_1.setText("");
                break;
        }

    }
}
