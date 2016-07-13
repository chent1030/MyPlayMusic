package com.geminno.app.myplaymusic.firendcircle_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.pojo.Circle;

import java.util.ArrayList;
import java.util.List;


public class DynamicDetailsActivity_bandcircle extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_return_dynamicdetail_2;
    private ListView lv_dynamicdetail_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_details_activity_bandcircle);

        lv_dynamicdetail_2 = ((ListView) findViewById(R.id.lv_dynamicdetail_2));
        ib_return_dynamicdetail_2 = ((TextView) findViewById(R.id.ib_return_dynamicdetail_2));
        ib_return_dynamicdetail_2.setOnClickListener(this);

        initData();
    }

    private void initData() {
       final List<Circle> circleList=new ArrayList<Circle>();

        for(int i=0;i<3;i++) {
            circleList.add(new Circle(R.drawable.headpic,"jasd"+i,"aslkjdkl"+i));
        }

        lv_dynamicdetail_2.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return circleList.size();
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
                View view=View.inflate(DynamicDetailsActivity_bandcircle.this,R.layout.dynamic_detail,null);
                ImageView iv_dynamic_detail_listitem=((ImageView) view.findViewById(R.id.iv_dynamic_detail_listitem));
                TextView tv_dynamic_detail_listitem=((TextView) view.findViewById(R.id.tv_dynamic_detail_listitem));
                TextView tv_dynamic_detail_listitem1=((TextView) view.findViewById(R.id.tv_dynamic_detail_listitem1));

                iv_dynamic_detail_listitem.setImageResource(circleList.get(position).getHeadPic());
                tv_dynamic_detail_listitem.setText(circleList.get(position).getName());
                tv_dynamic_detail_listitem1.setText(circleList.get(position).getCommentContext());

                return view;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_return_dynamicdetail_2:
                this.finish();
                break;
        }
    }
}
