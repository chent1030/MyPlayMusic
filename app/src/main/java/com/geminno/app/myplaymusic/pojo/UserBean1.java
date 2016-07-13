package com.geminno.app.myplaymusic.pojo;

import java.util.ArrayList;


/**
 * Created by Wenwen on 2016/7/12.
 */
public class UserBean1 {

    public Integer resultCode;
    public String message;
    public ArrayList<User1> data;

    public static class User1{
        public Integer user_id;
        public String user_nickname;
        public String user_headimage;
        public String user_name;
        public String user_wanyueaccount;
    }
}
