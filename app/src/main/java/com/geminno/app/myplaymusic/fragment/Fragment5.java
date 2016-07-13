package com.geminno.app.myplaymusic.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.MainActivity;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.me_activity.CreateBandActivity;
import com.geminno.app.myplaymusic.me_activity.HelpActivity;
import com.geminno.app.myplaymusic.me_activity.Me_infoActivity;
import com.geminno.app.myplaymusic.me_activity.MyMusicCircleActivity;
import com.geminno.app.myplaymusic.me_activity.SettingActivity;
import com.geminno.app.myplaymusic.pojo.UserBean1;
import com.geminno.app.myplaymusic.utils.IpUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.cache.FileNameGenerator;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment5 extends CommFragment implements View.OnClickListener{

    Intent intent;
    private ImageButton ib_me_1;
    private ImageButton ib_me_2;
    private ImageButton ib_me_3;
    private ImageButton ib_me_4;
    private ImageButton ib_me_5;
    private int user_id;
    private TextView tv_me_1;
    private TextView tv_me_2;
    private ImageView iv_me;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    try {
                        iv_me.setImageBitmap(android.graphics.BitmapFactory.decodeStream(new FileInputStream((File)msg.obj)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    String userInfo=msg.obj.toString();
                    String[] user=userInfo.split("\\|");
                    tv_me_1.setText(user[0]);
                    tv_me_2.setText(user[1]);
                    break;
            }
        }
    };




    @Override
    public View initview(LayoutInflater inflater) {
       View view=inflater.inflate(R.layout.me,null);
        tv_me_1 = ((TextView) view.findViewById(R.id.tv_me_1));
        tv_me_2 = ((TextView) view.findViewById(R.id.tv_me_2));
        iv_me = ((ImageView) view.findViewById(R.id.iv_me));
        ib_me_1 = ((ImageButton) view.findViewById(R.id.ib_me_1));
        ib_me_2 = ((ImageButton) view.findViewById(R.id.ib_me_2));
        ib_me_3 = ((ImageButton) view.findViewById(R.id.ib_me_3));
        ib_me_4 = ((ImageButton) view.findViewById(R.id.ib_me_4));
        ib_me_5 = ((ImageButton) view.findViewById(R.id.ib_me_5));
        System.out.println(this.user_id);
        return view;

    }



    @Override
    public void initdata() {

        readInfo();
        getUser1Info();

        ib_me_1.setOnClickListener(this);
        ib_me_2.setOnClickListener(this);
        ib_me_3.setOnClickListener(this);
        ib_me_4.setOnClickListener(this);
        ib_me_5.setOnClickListener(this);
    }



    private void readInfo() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user_nickname=sharedPreferences.getString("user_nickname","");
        String user_wanyueaccount=sharedPreferences.getString("user_wanyueaccount","");

        tv_me_1.setText(user_nickname);
        tv_me_2.setText(user_wanyueaccount);
    }

    private void getUser1Info() {

        final File file=new File(getActivity().getCacheDir(),"head.png");

        if(file.exists()){
            try {
                iv_me.setImageBitmap(android.graphics.BitmapFactory.decodeStream(new FileInputStream(file)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String path = IpUtils.IpAddress+"/WanYueEr/myinfromation.php";
                    try {
                        URL url = new URL(path);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setConnectTimeout(5000);
                        conn.setReadTimeout(3000);
                        String data = "user_id=" + user_id;
                        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        conn.setRequestProperty("Content-Length", data.length() + "");
                        conn.setDoOutput(true);

                        OutputStream os = conn.getOutputStream();
                        os.write(data.getBytes());

                        int code = conn.getResponseCode();
                        InputStream is=null;
                        if (code == 200) {
                            is = conn.getInputStream();
                            StringBuilder sb = new StringBuilder("");
                            byte[] bytes = new byte[1024];
                            int length = -1;
                            while ((length = is.read(bytes)) != -1) {
                                sb.append(new String(bytes, 0, length));
                            }
                            Gson gson = new Gson();
                            UserBean1 userBean1 = gson.fromJson(sb.toString(), UserBean1.class);
                            if (userBean1.resultCode == 200) {
                                ArrayList<UserBean1.User1> datalist = userBean1.data;
                                String user_nickname = datalist.get(0).user_nickname;
                                String user_wanyueaccount = datalist.get(0).user_wanyueaccount;
                                String userInfo = user_nickname + "|" + user_wanyueaccount;
                                final String user_headimage_path = IpUtils.IpAddress+"/WanYueEr/" + datalist.get(0).user_headimage;
                                System.out.println(user_headimage_path);

                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        InputStream is=null;
                                        FileOutputStream fos=null;
                                        try {
                                            System.out.println(user_headimage_path);
                                            URL url = new URL(user_headimage_path);
                                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                            conn.setConnectTimeout(5000);
                                            conn.setReadTimeout(3000);
                                            int code = conn.getResponseCode();

                                            if (code == 200) {
                                                is = conn.getInputStream();
                                                fos=new FileOutputStream(file);
                                                byte[] bytes=new byte[1024];
                                                int length=-1;
                                                while((length=is.read(bytes))!=-1){
                                                    fos.write(bytes,0,length);
                                                }

                                                Message msg = handler.obtainMessage();
                                                msg.what = 1;
                                                msg.obj = file;
                                                handler.sendMessage(msg);

                                            }

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }finally {
                                            try {
                                                fos.close();
                                                is.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                        }

                                    }
                                }).start();

                                Message msg = handler.obtainMessage();
                                msg.what = 2;
                                msg.obj = userInfo;
                                handler.sendMessage(msg);
                                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("user_nickname", user_nickname);
                                editor.putString("user_wanyueaccount", user_wanyueaccount);
                                editor.commit();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_me_1:
                intent=new Intent(getActivity(), Me_infoActivity.class);
                intent.putExtra("user_id",user_id);
                break;
            case R.id.ib_me_2:
                intent=new Intent(getActivity(), MyMusicCircleActivity.class);
                break;
            case R.id.ib_me_3:
                intent=new Intent(getActivity(), CreateBandActivity.class);
                break;
            case R.id.ib_me_4:
                intent=new Intent(getActivity(), SettingActivity.class);
                break;
            case R.id.ib_me_5:
                intent=new Intent(getActivity(), HelpActivity.class);
                break;
        }
        startActivity(intent);
    }


        public int getUserId(int user_id){
            this.user_id=user_id;
            return this.user_id ;
        }
}
