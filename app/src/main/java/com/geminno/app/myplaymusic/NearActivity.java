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
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);

        rg_near = ((RadioGroup) findViewById(R.id.rg_near));

        getFragmentManager().beginTransaction().replace(R.id.fl_near,new Fragment1()).commit();

        rg_near.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_near:
                        fragment=new Fragment1();
                        break;
                    case R.id.rb_message:
                        fragment=new Fragment2();
                        break;
                    case R.id.rb_find:
                        fragment=new Fragment3();
                        break;
                    case R.id.rb_friendcircle:
                        fragment=new Fragment4();
                        break;
                    case R.id.rb_me:
                        fragment=new Fragment5();
                        break;

                }
                getFragmentManager().beginTransaction().replace(R.id.fl_near,fragment).commit();

            }
        });



    }

    public void switchFragment(Fragment f){
        getFragmentManager().beginTransaction().replace(R.id.fl_friendcircle,f).commit();
    }
}
