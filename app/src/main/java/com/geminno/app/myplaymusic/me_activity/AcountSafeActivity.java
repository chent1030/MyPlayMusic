package com.geminno.app.myplaymusic.me_activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.geminno.app.myplaymusic.R;

public class AcountSafeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView ib_account_safe_1;
    private ImageButton ib_account_safe_2;
    private RelativeLayout rl_view;
    private TextView tv_verifypassword;
    private TextView tv_cancer_verfy;
    PopupWindow popupWindow=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_safe);

        rl_view = ((RelativeLayout) findViewById(R.id.rl_view));

        ib_account_safe_1 = ((TextView) findViewById(R.id.ib_account_safe_1));
        ib_account_safe_2 = ((ImageButton) findViewById(R.id.ib_account_safe_2));
        ib_account_safe_1.setOnClickListener(this);
        ib_account_safe_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ib_account_safe_1:
                this.finish();
                break;
            case R.id.ib_account_safe_2:

                View view=LayoutInflater.from(this).inflate(R.layout.account_safe_popupwindow,null);
                tv_verifypassword = ((TextView) view.findViewById(R.id.tv_verifypassword));
                tv_cancer_verfy = ((TextView) view.findViewById(R.id.tv_cancer_verfy));
                if(popupWindow==null){
                    popupWindow=new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setFocusable(true);
                    popupWindow.setOutsideTouchable(true);
                }
                popupWindow.showAtLocation(rl_view, Gravity.CENTER,0,0);

                tv_verifypassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(AcountSafeActivity.this,SettingPasswordActivity.class));
                    }
                });

                tv_cancer_verfy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
        }

    }
}
