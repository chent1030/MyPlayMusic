package com.geminno.app.myplaymusic.find_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.find_frag_2.Fragment_find2_1;
import com.geminno.app.myplaymusic.find_frag_2.Fragment_find2_2;


public class Find2Activity extends AppCompatActivity {

    ImageView iv_back;
    private RadioGroup rg_find;
    private TextView tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2);
        iv_back = ((ImageView) findViewById(R.id.iv_back));
        tv_back = ((TextView) findViewById(R.id.tv_back));
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2Activity.this.finish();
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Find2Activity.this.finish();
            }
        });

        rg_find = ((RadioGroup) findViewById(R.id.rg_find));
        getFragmentManager().beginTransaction().replace(R.id.fl_actinfo_2, new Fragment_find2_1()).commit();


        rg_find.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                System.out.println(checkedId+"");
                switch (checkedId) {
                    case R.id.btn_showinfo:
                        getFragmentManager().beginTransaction().replace(R.id.fl_actinfo_2, new Fragment_find2_1()).commit();
                        break;
                    case R.id.btn_pracinfo:
                        getFragmentManager().beginTransaction().replace(R.id.fl_actinfo_2, new Fragment_find2_2()).commit();
                        break;
                }
            }
        });
    }
}