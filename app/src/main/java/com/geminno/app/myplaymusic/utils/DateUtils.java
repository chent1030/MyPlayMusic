package com.geminno.app.myplaymusic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wenwen on 2016/6/30.
 */
public class DateUtils {
    public static String DateToString(Date date) {
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
        String str=sdf.format(date);
        return str;
    }

}
