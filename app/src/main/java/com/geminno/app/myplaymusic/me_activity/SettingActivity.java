package com.geminno.app.myplaymusic.me_activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.geminno.app.myplaymusic.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_setting_1;
    private ImageButton ib_setting_6;
    private ImageButton ib_setting_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ib_setting_1 = ((ImageButton) findViewById(R.id.ib_setting_1));
        ib_setting_2 = ((ImageButton) findViewById(R.id.ib_setting_2));
        ib_setting_6 = ((ImageButton) findViewById(R.id.ib_setting_6));

        ib_setting_1.setOnClickListener(this);
        ib_setting_2.setOnClickListener(this);
        ib_setting_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_setting_1:
                this.finish();
                break;
            case R.id.ib_setting_6:

                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("清理缓存");
                builder.setMessage("根据缓存文件的大小，清理时间从几秒到几分钟不等，请耐心等待。");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("清除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SettingActivity.this,"你执行了清除操作",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.ib_setting_2:
                startActivity(new Intent(this,AcountSafeActivity.class));
                break;


        }
    }
}
