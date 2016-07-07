package com.geminno.app.myplaymusic.me_activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.MainActivity;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.utils.DataCleanManager;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton ib_setting_1;
    private ImageButton ib_setting_6;
    private ImageButton ib_setting_2;
    private ImageButton ib_setting_3;
    private ImageButton ib_setting_4;
    private ImageButton ib_setting_5;
    private TextView tv_logoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ib_setting_1 = ((ImageButton) findViewById(R.id.ib_setting_1));
        ib_setting_2 = ((ImageButton) findViewById(R.id.ib_setting_2));
        ib_setting_3= ((ImageButton) findViewById(R.id.ib_setting_3));
        ib_setting_4= ((ImageButton) findViewById(R.id.ib_setting_4));
        ib_setting_5= ((ImageButton) findViewById(R.id.ib_setting_5));
        ib_setting_6 = ((ImageButton) findViewById(R.id.ib_setting_6));

        tv_logoff = ((TextView) findViewById(R.id.tv_logoff));

        ib_setting_1.setOnClickListener(this);
        ib_setting_2.setOnClickListener(this);
        ib_setting_3.setOnClickListener(this);
        ib_setting_4.setOnClickListener(this);
        ib_setting_5.setOnClickListener(this);
        ib_setting_6.setOnClickListener(this);
        tv_logoff.setOnClickListener(this);
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
                        DataCleanManager.cleanApplicationData(SettingActivity.this,"");
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.ib_setting_2:
                startActivity(new Intent(this,AcountSafeActivity.class));
                break;
            case R.id.ib_setting_3:
                startActivity(new Intent(this,MessageRemindActivity.class));
                break;
            case R.id.ib_setting_4:
                startActivity(new Intent(this,ChatBackgroundActivity.class));
                break;
            case R.id.ib_setting_5:
                startActivity(new Intent(this,BlackListActivity.class));
                break;
            case R.id.tv_logoff:
                new AlertDialog.Builder(this).setTitle("退出登录")
                        .setMessage("退出后你将无法收到别人的信息,别人也无法找到你,是否继续?")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(SettingActivity.this, MainActivity.class));
                        SettingActivity.this.finish();
                    }
                }).create().show();
                break;
        }
    }
}
