package com.geminno.app.myplaymusic.find_commFrag;

import java.io.Serializable;

/**
 * Created by dell on 2016/6/29.
 */
public class SFindBean implements Serializable{
    private int showSrc;
    public SFindBean(){}
    public SFindBean(int showSrc) {
        this.showSrc = showSrc;
    }

    public int getShowSrc() {
        return showSrc;
    }

    public void setShowSrc(int showSrc) {
        this.showSrc = showSrc;
    }
}
