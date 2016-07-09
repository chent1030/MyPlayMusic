package com.geminno.app.myplaymusic.me_activity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.R;

import java.util.Calendar;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_age;
    private DatePicker datetimepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        ib_age = ((TextView) findViewById(R.id.ib_age));
        ib_age.setOnClickListener(this);

        Calendar calendar=Calendar.getInstance();

        View view=LayoutInflater.from(this).inflate(R.layout.layout_date,null);
        datetimepicker = ((DatePicker) view.findViewById(R.id.datepicker));
        calendar.setTimeInMillis(System.currentTimeMillis());//初始化当前日期
        datetimepicker.setCalendarViewShown(false);//设置日期简要显示，否则详细显示，包括星期/周
        datetimepicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),null);//设置datetimepicker

        final AlertDialog.Builder builder=new AlertDialog.Builder(this);

        String s="";
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                s="日";
                break;
            case 2:
                s="一";
                break;
            case 3:
                s="二";
                break;
            case 4:
                s="三";
                break;
            case 5:
                s="四";
                break;
            case 6:
                s="五";
                break;
            case 7:
                s="六";
                break;
        }

        builder.setTitle(calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1)+"月"
                +calendar.get(Calendar.DAY_OF_MONTH)+"日"+" 星期"+s);
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("完成", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AgeActivity.this, "传输数据", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_age:
                this.finish();
                break;

        }
    }
}
