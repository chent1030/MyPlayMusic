package com.geminno.app.myplaymusic.me_activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geminno.app.myplaymusic.FindPasswordActivity;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;
import com.geminno.app.myplaymusic.fragment.Fragment5;

import com.geminno.app.myplaymusic.pojo.UserBean1;
import com.geminno.app.myplaymusic.utils.IpUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Me_infoActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    private TextView ib_returnme;
    private ImageButton ib_name;
    private RelativeLayout rl_personinfo;
    private ImageButton ib_meinfo_1;
    private ImageButton ib_idiograph;
    private ImageButton ib_familarinstrument;
    private ImageButton ib_musicstyle;
    private ImageButton ib_product_connection;
    private ImageButton ib_performance_level;
    private ImageButton ib_sex;
    private ImageButton ib_age;
    private ImageButton ib_hometown;
    private ImageButton ib_profession;
    private TextView tv_takephoto;
    int user_id;
    private TextView user_nickname;
    private TextView tv_user_wanyueaccount;
    private static final int RESULT_LOAD_IMAGE = 200;
    ImageView iv_head_me_info;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    try {
                        iv_head_me_info.setImageBitmap(android.graphics.BitmapFactory.decodeStream(new FileInputStream((File)msg.obj)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    String userInfo=msg.obj.toString();
                    String[] user=userInfo.split("\\|");
                    user_nickname.setText(user[0]);
                    tv_user_wanyueaccount.setText(user[1]);
                    tv_user_wanyueaccount_2.setText(user[1]);
                    break;
            }
        }
    };
    private TextView tv_fromephone;
    private TextView tv_user_wanyueaccount_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_info);
        tv_user_wanyueaccount_2 = ((TextView) findViewById(R.id.tv_user_wanyueaccount_2));
        iv_head_me_info = ((ImageView) findViewById(R.id.iv_head_me_info));
        tv_user_wanyueaccount = ((TextView) findViewById(R.id.tv_user_wanyueaccount));
        user_nickname = ((TextView) findViewById(R.id.user_nickname));
        ib_idiograph = ((ImageButton) findViewById(R.id.ib_idiograph));
        ib_returnme = ((TextView) findViewById(R.id.ib_returnme));
        ib_meinfo_1 = ((ImageButton) findViewById(R.id.ib_meinfo_1));
        rl_personinfo = ((RelativeLayout) findViewById(R.id.rl_personinfo));
        ib_name=((ImageButton) findViewById(R.id.ib_name));
        ib_familarinstrument = ((ImageButton) findViewById(R.id.ib_familarinstrument));
        ib_musicstyle = ((ImageButton) findViewById(R.id.ib_musicstyle));
        ib_product_connection = ((ImageButton) findViewById(R.id.ib_product_connection));
        ib_performance_level = ((ImageButton) findViewById(R.id.ib_performance_level));
        ib_sex = ((ImageButton) findViewById(R.id.ib_sex));
        ib_age = ((ImageButton) findViewById(R.id.ib_age));
        ib_hometown = ((ImageButton) findViewById(R.id.ib_hometown));
        ib_profession = ((ImageButton) findViewById(R.id.ib_profession));
        ib_returnme.setOnClickListener(this);
        ib_meinfo_1.setOnClickListener(this);
        ib_name.setOnClickListener(this);
        ib_idiograph.setOnClickListener(this);
        ib_familarinstrument.setOnClickListener(this);
        ib_musicstyle.setOnClickListener(this);
        ib_product_connection.setOnClickListener(this);
        ib_performance_level.setOnClickListener(this);
        ib_sex.setOnClickListener(this);
        ib_age.setOnClickListener(this);
        ib_hometown.setOnClickListener(this);
        ib_profession.setOnClickListener(this);

        user_id=getIntent().getIntExtra("user_id",1);
        System.out.println(user_id);
        getUser1Info();

        readInfo();
        getUser1Info();
    }

    private void readInfo() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user_nickname1=sharedPreferences.getString("user_nickname","");
        String user_wanyueaccount=sharedPreferences.getString("user_wanyueaccount","");

        user_nickname.setText(user_nickname1);
        tv_user_wanyueaccount.setText(user_wanyueaccount);
        tv_user_wanyueaccount_2.setText(user_wanyueaccount);
    }

    private void getUser1Info() {

        final File file=new File(this.getCacheDir(),"head.png");

        if(file.exists()){
            try {
                iv_head_me_info.setImageBitmap(android.graphics.BitmapFactory.decodeStream(new FileInputStream(file)));
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
                                SharedPreferences sharedPreferences = Me_infoActivity.this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
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
            case R.id.ib_returnme:
               this.finish();
                break;
            case R.id.ib_meinfo_1:
                View photo= LayoutInflater.from(this).inflate(R.layout.photo,null);
                tv_takephoto = ((TextView) photo.findViewById(R.id.tv_takephoto));
                tv_fromephone = ((TextView) photo.findViewById(R.id.tv_fromphone));

                PopupWindow popupWindow=null;
                if(popupWindow==null) {
                    popupWindow = new PopupWindow(photo, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setFocusable(true);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                }

                popupWindow.showAtLocation(rl_personinfo, Gravity.BOTTOM,0,0);

                tv_takephoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent().setAction("android.media.action.STILL_IMAGE_CAMERA"));
                    }
                });

                tv_fromephone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(picture, RESULT_LOAD_IMAGE );
                    }
                });

                break;
            case R.id.ib_name:
                startActivity(new Intent(this,NameActivity.class));
                break;
            case R.id.ib_idiograph:
                startActivity(new Intent(this,IdiographActivity.class));
                break;
            case R.id.ib_familarinstrument:
                Intent intent=new Intent(this,FamilarinstrumentActivity.class);
                intent.putExtra("user_id",user_id);
                startActivity(intent);
                break;
            case R.id.ib_musicstyle:
                startActivity(new Intent(this,MusicStyleActivity.class));
                break;
            case R.id.ib_product_connection:
                startActivity(new Intent(this,ProductConnectionActivity.class));
                break;
            case R.id.ib_performance_level:
                startActivity(new Intent(this,PerformanceLevelActivity.class));
                break;
            case R.id.ib_sex:
                startActivity(new Intent(this,SexActivity.class));
                break;
            case R.id.ib_age:
                startActivity(new Intent(this,AgeActivity.class));
                break;
            case R.id.ib_hometown:
                startActivity(new Intent(this,HomeTownActivity.class));
                break;
            case R.id.ib_profession:
                startActivity(new Intent(this,ProfessionActivity.class));
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RESULT_LOAD_IMAGE:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumns = {MediaStore.Images.Media.DATA};
                    Cursor c = this.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                    c.moveToNext();
                    int columnIndex = c.getColumnIndex(filePathColumns[0]);
                    String picturePath = c.getString(columnIndex);
                    c.close();
                    Bitmap bm1= BitmapFactory.decodeFile(picturePath,null);
                    iv_head_me_info.setImageBitmap(bm1);
                }
                break;
        }
    }
}
