package com.geminno.app.myplaymusic.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.firendcircle_activity.DynamicDetailsActivity_personcircle;
import com.geminno.app.myplaymusic.pojo.Circle;
import com.geminno.app.myplaymusic.utils.DateUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Wenwen on 2016/6/28.
 */
public class Fragment4_1 extends CommFragment {

    private PullToRefreshListView lv_friend_circle_1;
    boolean flag;

    @Override
    public View initview(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.friendcircle_1, null);
        lv_friend_circle_1 = ((PullToRefreshListView) view.findViewById(R.id.lv_friend_circle_1));
        return view;
    }

    @Override
    public void initdata() {

        final ArrayList<Circle> circleList = new ArrayList<Circle>();

        for (int i = 0; i < 20; i++) {
            circleList.add(new Circle(R.drawable.headpic,
                    "李小璐", "我还在糖果等你",
                    R.drawable.body, 1.54, new Date(), i, i, "你好"));
        }

        lv_friend_circle_1.setAdapter(new BaseAdapter() {


            private ImageButton ib_like_1;

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
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view= View.inflate(getActivity(),R.layout.list_item1,null);
                ib_like_1 = ((ImageButton) view.findViewById(R.id.ib_like_1));

                flag=false;
                final Handler handler=new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                flag=(boolean)msg.obj;
                                break;
                            case 0:
                                flag=(boolean)msg.obj;
                                break;
                        }
                    }
                };

                ImageButton ib_commet_1 = ((ImageButton) view.findViewById(R.id.ib_commet_1));
                ImageView iv_headpic_1=((ImageView) view.findViewById(R.id.iv_headpic_1));
                TextView tv_list_item1_1=((TextView) view.findViewById(R.id.tv_list_item1_1));
                TextView tv_list_item2_1=((TextView) view.findViewById(R.id.tv_list_item2_1));
                ImageView iv_body_1=((ImageView) view.findViewById(R.id.iv_body_1));
                TextView tv_list_item3_1=((TextView) view.findViewById(R.id.tv_list_item3_1));
                TextView tv_list_item5_1=((TextView) view.findViewById(R.id.tv_list_item5_1));
               final TextView tv_list_item6_1=((TextView) view.findViewById(R.id.tv_list_item6_1));
                TextView tv_list_item7_1=((TextView) view.findViewById(R.id.tv_list_item7_1));

                iv_headpic_1.setImageResource(circleList.get(position).getHeadPic());
                tv_list_item1_1.setText(circleList.get(position).getName());
                tv_list_item2_1.setText(circleList.get(position).getBody());
                iv_body_1.setImageResource(circleList.get(position).getPicShare());
                tv_list_item3_1.setText(circleList.get(position).getDistance()+"");
                tv_list_item5_1.setText(DateUtils.DateToString(circleList.get(position).getDate()));
                 tv_list_item6_1.setText(circleList.get(position).getLikeCount()+"");
                tv_list_item7_1.setText(circleList.get(position).getCommentCount()+"");

                ib_like_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(flag==false) {
                            tv_list_item6_1.setText((Integer.parseInt(tv_list_item6_1.getText().toString()) + 1)+"");
                            Message msg=handler.obtainMessage();
                            msg.what=1;
                            msg.obj=true;
                            handler.sendMessage(msg);
                        }else{
                            tv_list_item6_1.setText((Integer.parseInt(tv_list_item6_1.getText().toString()) - 1)+"");
                            Message msg=handler.obtainMessage();
                            msg.what=0;
                            msg.obj=false;
                            handler.sendMessage(msg);
                        }
                    }
                });

                ib_commet_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       startActivity(new Intent(getActivity(), DynamicDetailsActivity_personcircle.class));
                        System.out.println(position);
                    }
                });
                return view;
            }
        });

        lv_friend_circle_1.setMode(PullToRefreshBase.Mode.BOTH);
        // 设置刷新监听
        lv_friend_circle_1.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String str = android.text.format.DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), android.text.format.DateUtils.FORMAT_SHOW_TIME | android.text.format.DateUtils.FORMAT_SHOW_DATE | android.text.format.DateUtils.FORMAT_ABBREV_ALL);
                if (refreshView.isShownHeader()) {
                    //设置刷新标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                    //设置下拉标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                    //设置释放标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                    //设置上一次刷新的提示标签
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                    //加载数据操作
                    lv_friend_circle_1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lv_friend_circle_1.onRefreshComplete();
                        }
                    }, 1000);

                }
                if (refreshView.isShownFooter()) {
                    //设置刷新标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                    //设置下拉标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                    //设置释放标签
                    lv_friend_circle_1.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                    //设置上一次刷新的提示标签
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                    //加载数据操作

                    lv_friend_circle_1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lv_friend_circle_1.onRefreshComplete();
                        }
                    }, 1000);
                }
            }
        });
    }

}
