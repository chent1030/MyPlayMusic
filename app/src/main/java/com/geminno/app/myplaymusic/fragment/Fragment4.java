package com.geminno.app.myplaymusic.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.geminno.app.myplaymusic.Comm.CommFragment;
import com.geminno.app.myplaymusic.MainActivity;
import com.geminno.app.myplaymusic.NearActivity;
import com.geminno.app.myplaymusic.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Wenwen on 2016/6/27.
 */
public class Fragment4 extends CommFragment {


    private static final int RESULT_LOAD_IMAGE = 10;
    private RadioGroup rg_friend_circle;
    private ImageButton ib_photo;
    PopupWindow popupWindow;
    View view;
    private TextView tv_takephoto;
    private TextView tv_fromphone;
    private TextView cancel_photo;


    @Override
    public View initview(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.friendcircle, null);
        rg_friend_circle = ((RadioGroup) view.findViewById(R.id.rg_friend_circle));
        ib_photo = ((ImageButton) view.findViewById(R.id.ib_photo));
        return view;
    }

    @Override
    public void initdata() {

        if (getActivity() instanceof NearActivity) {
            if (new Fragment4_1() != null) {
                ((NearActivity) getActivity()).switchFragment(new Fragment4_1());
            }
        }

        rg_friend_circle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1_friendcircle:
                        if (getActivity() instanceof NearActivity) {
                            if (new Fragment4_1() != null) {
                                ((NearActivity) getActivity()).switchFragment(new Fragment4_1());
                            }
                        }
                        break;
                    case R.id.rb2_friendcircle:
                        if (getActivity() instanceof NearActivity) {
                            ((NearActivity) getActivity()).switchFragment(new Fragment4_2());
                        }
                        break;
                }


            }
        });

        ib_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View photo = LayoutInflater.from(getActivity()).inflate(R.layout.photo, null);
                tv_takephoto = ((TextView) photo.findViewById(R.id.tv_takephoto));
                tv_fromphone = ((TextView) photo.findViewById(R.id.tv_fromphone));
                cancel_photo = ((TextView) photo.findViewById(R.id.cancel_photo));

                tv_takephoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //startActivityForResult(camera, RESULT_LOAD_IMAGE);
                        Intent intent=new Intent();
                        intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                        startActivity(intent);
                    }
                });

                tv_fromphone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(picture, RESULT_LOAD_IMAGE + 1);

                    }
                });

                cancel_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                if (popupWindow == null) {
                    popupWindow = new PopupWindow(photo, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setFocusable(true);
                }
                popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
            }
        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data == null) {
//            return;
//        }
//        switch (requestCode) {
//            case RESULT_LOAD_IMAGE:
//                switch (resultCode) {
//                    case Activity.RESULT_OK://照相完成点击确定
//                        String sdStatus = Environment.getExternalStorageState();
//                        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {//检测sd是否可用
//                            Log.v("TestFile", "SD card is not avaiable/writeable right now");
//                            return;
//                        }
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
//                        String name = sdf.format(Calendar.getInstance().getTime()) + ".jpg";
//                        System.out.println(name);
//
//                        Bundle bundle = data.getExtras();
//                        Bitmap bitmap = (Bitmap) bundle.get("data");
//
//                        File file = new File("/sdcard/picak/");
//                        file.mkdirs();
//
//                        String fileName = file.getPath() + name;
//
//                        FileOutputStream fos = null;
//
//                        try {
//                            fos = new FileOutputStream(fileName);
//                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        } finally {
//                            try {
//                                fos.flush();
//                                fos.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                }
//
//
//            case RESULT_LOAD_IMAGE + 1:
//                if (resultCode == Activity.RESULT_OK) {
//                    Uri selectedImage = data.getData();
//                    String[] filePathColumns = {MediaStore.Images.Media.DATA};
//                    Cursor c = getActivity().getContentResolver().query(selectedImage, filePathColumns, null, null, null);
//                    c.moveToNext();
//                    int columnIndex = c.getColumnIndex(filePathColumns[0]);
//                    String picturePath = c.getString(columnIndex);
//                    c.close();
//                }
//
//        }
//
//    }


}
