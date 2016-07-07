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
import com.geminno.app.myplaymusic.pojo.NearBand;
import com.geminno.app.myplaymusic.pojo.NearPerson;
import com.geminno.app.myplaymusic.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by chent on 2016/7/6.
 */
public class Fragment1_1 extends CommFragment {
    private ListView lv_near_1;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.list_near_1,null);
        lv_near_1 = ((ListView) view.findViewById(R.id.lv_near_1));
        return view;
    }

    @Override
    public void initdata() {
        final ArrayList<NearBand> bandList = new ArrayList<NearBand>();
        for (int i = 0; i <20 ; i++) {
            bandList.add(new NearBand(R.drawable.head_me_info,"好大爷乐队","乐队风格:摇滚","此处是群介绍",3.4));
        }
        lv_near_1.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return bandList.size();
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
                View view = View.inflate(getActivity(),R.layout.list_item_band,null);
                ImageView iv_bandheadpic = ((ImageView) view.findViewById(R.id.iv_bandheadpic));
                TextView tv_item_band_1 = ((TextView) view.findViewById(R.id.tv_item_band_1));
                TextView tv_item_band_2 = ((TextView) view.findViewById(R.id.tv_item_band_2));
                TextView tv_item_band_3 = ((TextView) view.findViewById(R.id.tv_item_band_3));
                TextView tv_item_band_4 = ((TextView) view.findViewById(R.id.tv_item_band_4));

                iv_bandheadpic.setImageResource(bandList.get(position).getMugshot());
                tv_item_band_1.setText(bandList.get(position).getName());
                tv_item_band_2.setText(bandList.get(position).getStylistics());
                tv_item_band_3.setText(bandList.get(position).getIntroduce());
                tv_item_band_4.setText(bandList.get(position).getDistance()+"");
                return view;
            }
        });
    }
}
