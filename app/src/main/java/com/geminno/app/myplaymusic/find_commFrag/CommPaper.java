package com.geminno.app.myplaymusic.find_commFrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by dell on 2016/6/28.
 */
public abstract class CommPaper {
    private View root_view;
    private Context context;

    public View getRoot_view() {
        return root_view;
    }

    public Context getContext() {
        return context;
    }

    public CommPaper(Context context){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.root_view = initview( inflater);
    }

    public abstract View initview(LayoutInflater inflater);
    public abstract void initdata();
}
