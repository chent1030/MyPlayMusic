package com.geminno.app.myplaymusic.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.pojo.Circle;
import com.geminno.app.myplaymusic.pojo.Message;
import com.geminno.app.myplaymusic.utils.DateUtils;
import com.jakewharton.rxbinding.widget.RxAdapterView;

import java.util.ArrayList;
import java.util.Date;

import rx.functions.Action1;

/**
 * Created by chent on 2016/7/6.
 */
public class Fragment2_1 extends CommFragment {
    private ListView msg_listview;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.list_item,null);
        msg_listview = ((ListView) view.findViewById(R.id.msg_listview));
        return view;
    }

    @Override
    public void initdata() {
        final ArrayList<Message> msgList = new ArrayList<Message>();
        for (int i = 0; i <20 ; i++) {
            msgList.add(new Message(R.drawable.headpic,"李小璐","我还在糖果等你",2.15,new Date()));
        }
        msg_listview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return msgList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = View.inflate(getActivity(),R.layout.list_item_msg,null);
                ImageView iv_mugshot = ((ImageView) view.findViewById(R.id.iv_mugshot));
                TextView tv_list_item_msg_1 = ((TextView) view.findViewById(R.id.tv_list_item_msg_1));
                TextView tv_list_item_msg_2 = ((TextView) view.findViewById(R.id.tv_list_item_msg_2));
                TextView tv_list_item_msg_3 = ((TextView) view.findViewById(R.id.tv_list_item_msg_3));
                TextView tv_list_item_msg_5 = ((TextView) view.findViewById(R.id.tv_list_item_msg_5));

                iv_mugshot.setImageResource(msgList.get(position).getMugshot());
                tv_list_item_msg_1.setText(msgList.get(position).getName());
                tv_list_item_msg_2.setText(msgList.get(position).getBody());
                tv_list_item_msg_3.setText(DateUtils.DateToString(msgList.get(position).getDate()));
                tv_list_item_msg_5.setText(msgList.get(position).getDistance()+"");
                return view;
            }
        });
        //item click event
//        RxAdapterView.itemClicks(msg_listview)
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//
//                    }
//                });
        //item long click
//        RxAdapterView.itemLongClicks(msg_listview)
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//
//                    }
//                });
    }
}
