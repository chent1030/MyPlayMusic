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
import com.geminno.app.myplaymusic.circle_activity.ShareCircleActivity;

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



    private RadioGroup rg_friend_circle;
    private ImageButton ib_photo;
    View view;



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
                startActivity(new Intent(getActivity(), ShareCircleActivity.class));

            }

        });

    }
}
