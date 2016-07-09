package com.geminno.app.myplaymusic.me_activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geminno.app.myplaymusic.FindPasswordActivity;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.fragment.Fragment5;

public class Me_infoActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    private TextView ib_returnme;
    private ImageButton ib_name;
    private RelativeLayout rl_personinfo;
    private ImageButton ib_meinfo_1;
    private ImageButton ib_idiograph;
    private ImageButton ib_familarinstrument;
    private ImageButton ib_musicstyle;
    private ImageButton ib_product_connection;
    private ImageButton ib_performance_level;
    private ImageButton ib_sex;
    private ImageButton ib_age;
    private ImageButton ib_hometown;
    private ImageButton ib_profession;
    private TextView tv_takephoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_info);
        ib_idiograph = ((ImageButton) findViewById(R.id.ib_idiograph));
        ib_returnme = ((TextView) findViewById(R.id.ib_returnme));
        ib_meinfo_1 = ((ImageButton) findViewById(R.id.ib_meinfo_1));
        rl_personinfo = ((RelativeLayout) findViewById(R.id.rl_personinfo));
        ib_name=((ImageButton) findViewById(R.id.ib_name));
        ib_familarinstrument = ((ImageButton) findViewById(R.id.ib_familarinstrument));
        ib_musicstyle = ((ImageButton) findViewById(R.id.ib_musicstyle));
        ib_product_connection = ((ImageButton) findViewById(R.id.ib_product_connection));
        ib_performance_level = ((ImageButton) findViewById(R.id.ib_performance_level));
        ib_sex = ((ImageButton) findViewById(R.id.ib_sex));
        ib_age = ((ImageButton) findViewById(R.id.ib_age));
        ib_hometown = ((ImageButton) findViewById(R.id.ib_hometown));
        ib_profession = ((ImageButton) findViewById(R.id.ib_profession));
        ib_returnme.setOnClickListener(this);
        ib_meinfo_1.setOnClickListener(this);
        ib_name.setOnClickListener(this);
        ib_idiograph.setOnClickListener(this);
        ib_familarinstrument.setOnClickListener(this);
        ib_musicstyle.setOnClickListener(this);
        ib_product_connection.setOnClickListener(this);
        ib_performance_level.setOnClickListener(this);
        ib_sex.setOnClickListener(this);
        ib_age.setOnClickListener(this);
        ib_hometown.setOnClickListener(this);
        ib_profession.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_returnme:
               this.finish();
                break;
            case R.id.ib_meinfo_1:
                View photo= LayoutInflater.from(this).inflate(R.layout.photo,null);
                tv_takephoto = ((TextView) photo.findViewById(R.id.tv_takephoto));

                PopupWindow popupWindow=null;
                if(popupWindow==null) {
                    popupWindow = new PopupWindow(photo, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setFocusable(true);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                }

                popupWindow.showAtLocation(rl_personinfo, Gravity.BOTTOM,0,0);

                tv_takephoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent().setAction("android.media.action.STILL_IMAGE_CAMERA"));
                    }
                });

                break;
            case R.id.ib_name:
                startActivity(new Intent(this,NameActivity.class));
                break;
            case R.id.ib_idiograph:
                startActivity(new Intent(this,IdiographActivity.class));
                break;
            case R.id.ib_familarinstrument:
                startActivity(new Intent(this,FamilarinstrumentActivity.class));
                break;
            case R.id.ib_musicstyle:
                startActivity(new Intent(this,MusicStyleActivity.class));
                break;
            case R.id.ib_product_connection:
                startActivity(new Intent(this,ProductConnectionActivity.class));
                break;
            case R.id.ib_performance_level:
                startActivity(new Intent(this,PerformanceLevelActivity.class));
                break;
            case R.id.ib_sex:
                startActivity(new Intent(this,SexActivity.class));
                break;
            case R.id.ib_age:
                startActivity(new Intent(this,AgeActivity.class));
                break;
            case R.id.ib_hometown:
                startActivity(new Intent(this,HomeTownActivity.class));
                break;
            case R.id.ib_profession:
                startActivity(new Intent(this,ProfessionActivity.class));
                break;

        }
    }
}
