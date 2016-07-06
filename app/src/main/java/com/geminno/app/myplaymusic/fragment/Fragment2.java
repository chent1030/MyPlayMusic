package com.geminno.app.myplaymusic.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment2 extends CommFragment {
    View view;
    PopupWindow popupWindow;
    private ImageButton ib_add;
    private RadioGroup rg_message;
    private TextView tv_add_friend;
    private TextView tv_group_chat;

    @Override
    public View initview(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.message,null);
        ib_add = ((ImageButton) view.findViewById(R.id.ib_add));
        rg_message = ((RadioGroup) view.findViewById(R.id.rg_message));
        return view;
    }

    @Override
    public void initdata() {
        if (getActivity() instanceof NearActivity){
            if (new Fragment2_1()!=null){
                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_message,new Fragment2_1()).commit();
            }
        }
        rg_message.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1_message:
                        if (getActivity() instanceof NearActivity){
                            if (new Fragment2_1()!=null){
                                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_message,new Fragment2_1()).commit();
                            }
                        }
                        break;
                    case R.id.rb2_message:
                        if (getActivity() instanceof NearActivity){
                            if (new Fragment2_1()!=null){
                                getActivity().getFragmentManager().beginTransaction().replace(R.id.fl_message,new Fragment2_2()).commit();
                            }
                        }
                        break;
                }
            }
        });
        ib_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final View add = LayoutInflater.from(getActivity()).inflate(R.layout.add,null);
                tv_group_chat = ((TextView) add.findViewById(R.id.tv_group_chat));
                tv_add_friend = ((TextView) add.findViewById(R.id.tv_add_friend));

                tv_group_chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                tv_add_friend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                if (popupWindow==null){
                    popupWindow = new PopupWindow(add, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setFocusable(true);
                }
                popupWindow.showAtLocation(view, Gravity.BOTTOM,0,0);
            }
        });
    }
}
