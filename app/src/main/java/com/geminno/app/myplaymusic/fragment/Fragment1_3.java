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
import com.geminno.app.myplaymusic.pojo.NearGroup;

import java.util.ArrayList;

/**
 * Created by chent on 2016/7/6.
 */
public class Fragment1_3 extends CommFragment {
    private ListView lv_near_3;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.list_near_3,null);
        lv_near_3 = ((ListView) view.findViewById(R.id.lv_near_3));
        return view;
    }

    @Override
    public void initdata() {
        final ArrayList<NearGroup> groups = new ArrayList<NearGroup>();
        for (int i = 0; i <20 ; i++) {
            groups.add(new NearGroup(R.drawable.head_me_info,"啪嗒嗨",123,"此处是介绍","北京市海淀区"));
        }
        lv_near_3.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return groups.size();
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
                View view = View.inflate(getActivity(),R.layout.list_item_faction,null);
                ImageView iv_factionheadpic = ((ImageView) view.findViewById(R.id.iv_factionheadpic));
                TextView tv_item_faction_1 = ((TextView) view.findViewById(R.id.tv_item_faction_1));
                TextView tv_item_faction_2 = ((TextView) view.findViewById(R.id.tv_item_faction_2));
                TextView tv_item_faction_3 = ((TextView) view.findViewById(R.id.tv_item_faction_3));
                TextView tv_item_faction_4 = ((TextView) view.findViewById(R.id.tv_item_faction_4));

                iv_factionheadpic.setImageResource(groups.get(position).getMugshot());
                tv_item_faction_1.setText(groups.get(position).getName());
                tv_item_faction_2.setText(groups.get(position).getNum()+"");
                tv_item_faction_3.setText(groups.get(position).getIntroduce());
                tv_item_faction_4.setText(groups.get(position).getAddress());
                return view;
            }
        });
    }
}
