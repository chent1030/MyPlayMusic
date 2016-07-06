package com.geminno.app.myplaymusic.find_fragment;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.find_activity.Find2Activity;
import com.geminno.app.myplaymusic.find_activity.Find3Activity;
import com.geminno.app.myplaymusic.find_commFrag.SFindBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dell on 2016/6/28.
 */
public class Fragment3 extends CommFragment {

    private ViewPager vp_img;
    List<SFindBean> sfList;
    private ImageView show_1;
    private ImageView show_2;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.vp_item,null);
        vp_img = ((ViewPager) view.findViewById(R.id.vp_img));

        show_1 = ((ImageView) view.findViewById(R.id.show_1));
        show_2 = ((ImageView) view.findViewById(R.id.show_2));
        show_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(),Find2Activity.class);

                getActivity().startActivity(i);
            }
        });

        show_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(),Find3Activity.class);

                getActivity().startActivity(i);
            }
        });
        return view;
    }



    @Override
    public void initdata() {
        sfList = new ArrayList<SFindBean>();

        sfList.add(new SFindBean(R.mipmap.show_title));
        sfList.add(new SFindBean(R.mipmap.show1));
        sfList.add(new SFindBean(R.mipmap.show2));

        vp_img.setAdapter(new MyPageAdapter());


    }
    public class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return sfList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            System.out.println("choose:position:"+position);
            View view =View.inflate(getActivity(),R.layout.imgview_item,null);
            ImageView imgview = ((ImageView) view.findViewById(R.id.imgview));
            imgview.setImageResource(sfList.get(position).getShowSrc());
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View)object);
        }
    }



}
