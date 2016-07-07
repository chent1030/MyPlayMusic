package com.geminno.app.myplaymusic.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.person_activity.PersonActivity;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment1 extends CommFragment {
    View view;
    private ImageButton ib_near_search;
    private ImageButton ib_screen;
    private RadioGroup rg_near;

    @Override
    public View initview(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.near,null);
        ib_near_search = ((ImageButton) view.findViewById(R.id.ib_near_search));
        ib_screen = ((ImageButton) view.findViewById(R.id.ib_screen));
        rg_near = ((RadioGroup) view.findViewById(R.id.rg_near));
        return view;
    }

    @Override
    public void initdata() {
        if (getActivity() instanceof NearActivity){
            if (new Fragment1_1()!=null){
                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_near_1,new Fragment1_1()).commit();
            }
        }
        rg_near.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1_near:
                        if (getActivity() instanceof NearActivity){
                            if (new Fragment1_1()!=null){
                                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_near_1,new Fragment1_1()).commit();
                            }
                        }
                        break;
                    case R.id.rb2_near:
                        if (getActivity() instanceof NearActivity){
                            if (new Fragment1_2()!=null){
                                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_near_1,new Fragment1_2()).commit();
                            }
                        }
                        break;
                    case R.id.rb3_near:
                        if (getActivity() instanceof NearActivity){
                            if (new Fragment1_3()!=null){
                                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_near_1,new Fragment1_3()).commit();
                            }
                        }
                        break;
                }
            }
        });
        ib_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonActivity.class);
                startActivity(intent);
            }
        });
    }
}
