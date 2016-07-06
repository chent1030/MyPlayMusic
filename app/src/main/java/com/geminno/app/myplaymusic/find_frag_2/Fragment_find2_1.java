package com.geminno.app.myplaymusic.find_frag_2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.find_activity.Find2_1Activity;


/**
 * Created by dell on 2016/6/28.
 */
public class Fragment_find2_1 extends CommFragment {

    private ImageView iv_prac_right;

    @Override
    public View initview(LayoutInflater inflater) {
        View view =inflater.inflate(R.layout.lv_find1_1,null);
        iv_prac_right = ((ImageView) view.findViewById(R.id.iv_prac_right1));
        return  view;
    }


    @Override
    public void initdata() {
            iv_prac_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Find2_1Activity.class);
                    getActivity().startActivity(i);
                }
            });
    }



}
