package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.geminno.app.myplaymusic.R;

public class SettingPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_settingpassword_1;
    private ImageButton ib_setpassword_1;
    private ImageButton ib_setpassword_2;
    private EditText et_setpassword_1;
    private EditText et_setpassword_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_password);

        ib_settingpassword_1 = ((ImageButton) findViewById(R.id.ib_settingpassword_1));
        ib_setpassword_1 = ((ImageButton) findViewById(R.id.ib_setpassword_1));
        ib_setpassword_2 = ((ImageButton) findViewById(R.id.ib_setpassword_2));
        et_setpassword_1 = ((EditText) findViewById(R.id.et_setpassword_1));
        et_setpassword_2 = ((EditText) findViewById(R.id.et_setpassword_2));

        ib_settingpassword_1.setOnClickListener(this);
        ib_setpassword_1.setOnClickListener(this);
        ib_setpassword_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_settingpassword_1:
                this.finish();
                break;
            case R.id.ib_setpassword_1:
                et_setpassword_1.setText("");
                break;
            case R.id.ib_setpassword_2:
                et_setpassword_2.setText("");
                break;
        }
    }
}
