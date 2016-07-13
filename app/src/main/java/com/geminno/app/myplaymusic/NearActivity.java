package com.geminno.app.myplaymusic;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.geminno.app.myplaymusic.find_fragment.Fragment3;
import com.geminno.app.myplaymusic.fragment.Fragment1;
import com.geminno.app.myplaymusic.fragment.Fragment2;

import com.geminno.app.myplaymusic.fragment.Fragment4;
import com.geminno.app.myplaymusic.fragment.Fragment5;

public class NearActivity extends AppCompatActivity {

    private RadioGroup rg_near;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);

        final int user_id= this.getIntent().getIntExtra("user_id",1);
        System.out.println(user_id);
        rg_near = ((RadioGroup) findViewById(R.id.rg_near));

        getFragmentManager().beginTransaction().replace(R.id.fl_near,new Fragment1()).commit();

        rg_near.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_near:
                        Fragment1 fragment1=new Fragment1();
                        getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment1).commit();
                        break;
                    case R.id.rb_message:
                        Fragment2 fragment2=new Fragment2();
                        getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment2).commit();
                        break;
                    case R.id.rb_find:
                        Fragment3 fragment3=new Fragment3();
                        getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment3).commit();
                        break;
                    case R.id.rb_friendcircle:
                        Fragment4 fragment4=new Fragment4();
                        getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment4).commit();
                        break;
                    case R.id.rb_me:
                        Fragment5 fragment5=new Fragment5();
                        fragment5.getUserId(user_id);
                        getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment5).commit();
                        break;

                }

            }
        });

    }



}
