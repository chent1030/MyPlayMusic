package com.geminno.app.myplaymusic.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.me_activity.CreateBandActivity;
import com.geminno.app.myplaymusic.me_activity.HelpActivity;
import com.geminno.app.myplaymusic.me_activity.Me_infoActivity;
import com.geminno.app.myplaymusic.me_activity.MyMusicCircleActivity;
import com.geminno.app.myplaymusic.me_activity.SettingActivity;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment5 extends CommFragment implements View.OnClickListener{

    Intent intent;
    private ImageButton ib_me_1;
    private ImageButton ib_me_2;
    private ImageButton ib_me_3;
    private ImageButton ib_me_4;
    private ImageButton ib_me_5;


    @Override
    public View initview(LayoutInflater inflater) {
       View view=inflater.inflate(R.layout.me,null);
        ib_me_1 = ((ImageButton) view.findViewById(R.id.ib_me_1));
        ib_me_2 = ((ImageButton) view.findViewById(R.id.ib_me_2));
        ib_me_3 = ((ImageButton) view.findViewById(R.id.ib_me_3));
        ib_me_4 = ((ImageButton) view.findViewById(R.id.ib_me_4));
        ib_me_5 = ((ImageButton) view.findViewById(R.id.ib_me_5));
        return view;
    }

    @Override
    public void initdata() {
        ib_me_1.setOnClickListener(this);
        ib_me_2.setOnClickListener(this);
        ib_me_3.setOnClickListener(this);
        ib_me_4.setOnClickListener(this);
        ib_me_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_me_1:
                intent=new Intent(getActivity(), Me_infoActivity.class);
                break;
            case R.id.ib_me_2:
                intent=new Intent(getActivity(), MyMusicCircleActivity.class);
                break;
            case R.id.ib_me_3:
                intent=new Intent(getActivity(), CreateBandActivity.class);
                break;
            case R.id.ib_me_4:
                intent=new Intent(getActivity(), SettingActivity.class);
                break;
            case R.id.ib_me_5:
                intent=new Intent(getActivity(), HelpActivity.class);
                break;
        }
        startActivity(intent);
    }
}
