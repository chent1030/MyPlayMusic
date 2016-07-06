package com.geminno.app.myplaymusic.me_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.pojo.Circle;
import com.geminno.app.myplaymusic.utils.DateUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMusicCircleActivity extends AppCompatActivity {

    private PullToRefreshListView ptrlv_dynamic;
    private ImageButton ib_return_dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music_circle);
        ptrlv_dynamic = ((PullToRefreshListView) findViewById(R.id.ptrlv_dynamic));
        ib_return_dynamic = ((ImageButton) findViewById(R.id.ib_return_dynamic));
        initdata();
    }

    private void initdata() {

        ArrayList<Circle> circleList = new ArrayList<Circle>();
        for(int i=0;i<20;i++) {
            circleList.add(new Circle("chao", R.drawable.head_me_info,
                    23, true, "fuckyou", new Date(), R.drawable.picshare
            ));
        }

        List<Map<String, String>> person = new ArrayList<Map<String, String>>();

        HashMap<String, String> ma = new HashMap<String, String>();
        for(int i = 0; i< circleList.size(); i++) {
            ma.put("headPic", circleList.get(i).getHeadPic() + "");
            ma.put("name", circleList.get(i).getName());
            ma.put("age", circleList.get(i).getAge() + "");
            ma.put("sex", circleList.get(i).isSex() == true ? "男" : "女");
            ma.put("body", circleList.get(i).getBody());
            ma.put("picshare", circleList.get(i).getPicShare() + "");
            ma.put("time", DateUtils.DateToString(circleList.get(i).getDate()));
            person.add(ma);
        }



        ptrlv_dynamic.setAdapter(new SimpleAdapter(this, person,
                R.layout.person_dynamic,
                new String[]{"headPic", "name", "age", "sex", "body", "picshare", "time"},
                new int[]{R.id.iv_dyn, R.id.tv_dyn_1, R.id.tv_dyn_3, R.id.tv_dyn_2, R.id.tv_dyn_4, R.id.iv_dyn_2, R.id.tv_dyn_5}));

        ptrlv_dynamic.setMode(PullToRefreshBase.Mode.PULL_FROM_END);

        ptrlv_dynamic.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String str = android.text.format.DateUtils.formatDateTime(MyMusicCircleActivity.this, System.currentTimeMillis(), android.text.format.DateUtils.FORMAT_SHOW_TIME | android.text.format.DateUtils.FORMAT_SHOW_DATE | android.text.format.DateUtils.FORMAT_ABBREV_ALL);

                if (refreshView.isShownFooter()) {
                    //设置刷新标签
                    ptrlv_dynamic.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                    //设置下拉标签
                    ptrlv_dynamic.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                    //设置释放标签
                    ptrlv_dynamic.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                    //设置上一次刷新的提示标签
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                    //加载数据操作
//                new MyTask().execute();
                    ptrlv_dynamic.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ptrlv_dynamic.onRefreshComplete();
                        }
                    }, 1000);
                }
            }
        });

        ib_return_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMusicCircleActivity.this.finish();
            }
        });
    }

}