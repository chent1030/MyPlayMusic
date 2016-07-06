package com.geminno.app.myplaymusic.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment1 extends CommFragment {
    @Override
    public View initview(LayoutInflater inflater) {
        TextView textView=new TextView(getActivity());
        textView.setText("附近");
        return textView;
    }

    @Override
    public void initdata() {

    }
}
