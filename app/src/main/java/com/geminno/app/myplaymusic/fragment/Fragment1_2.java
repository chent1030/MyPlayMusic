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
public class Fragment1_2 extends CommFragment {
    private ListView lv_near_2;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.list_near_2,null);
        lv_near_2 = ((ListView) view.findViewById(R.id.lv_near_2));
        return view;
    }

    @Override
    public void initdata() {
        final ArrayList<NearPerson> persons = new ArrayList<NearPerson>();
        for (int i = 0; i <20 ; i++) {
            persons.add(new NearPerson(R.drawable.headpic,"中岛美雪","乐器:钢琴","等级:大神",R.drawable.title_msg_right,1.56,new Date()));
        }
        lv_near_2.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return persons.size();
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
                View view = View.inflate(getActivity(),R.layout.list_item_person,null);
                ImageView iv_headpic = ((ImageView) view.findViewById(R.id.iv_headpic));
                TextView tv_item_person_1 = ((TextView) view.findViewById(R.id.tv_item_person_1));
                TextView tv_item_person_2 = ((TextView) view.findViewById(R.id.tv_item_person_2));
                TextView tv_item_person_3 = ((TextView) view.findViewById(R.id.tv_item_person_3));
                TextView tv_item_person_4 = ((TextView) view.findViewById(R.id.tv_item_person_4));
                TextView tv_item_person_6 = ((TextView) view.findViewById(R.id.tv_item_person_6));

                iv_headpic.setImageResource(persons.get(position).getMugshot());
                tv_item_person_1.setText(persons.get(position).getName());
                tv_item_person_2.setText(persons.get(position).getInstrument());
                tv_item_person_3.setText(persons.get(position).getRank());
                tv_item_person_4.setText(persons.get(position).getDistance()+"");
                tv_item_person_6.setText(DateUtils.DateToString(persons.get(position).getDate()));
                return view;
            }
        });
    }
}
