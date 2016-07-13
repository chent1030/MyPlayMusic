package com.geminno.app.myplaymusic.pojo;

import java.util.Date;

/**
 * Created by Wenwen on 2016/7/12.
 */
public class UserBean {

    public Integer code;
    public String message;
    public User data;

    public static class User{
        public Integer user_id;
        public String user_name;
        public String user_nickname;
        public String user_password;
        public String user_headimage;
        public String user_description;
        public String user_wanyueaccount;
        public Integer user_phonenumber;
        public String user_musicyear;
        public String user_works;
        public String user_levels;
        public Date user_birthday;
        public String user_homeplace;
        public String user_job;
        public Double user_longtitude;
        public Double user_latitude;
        public String user_gender;
        public String user_instrument;
        public String user_musicstyle;
        public Date user_last_log_time;
        public Integer user_band_id;

    }
}
