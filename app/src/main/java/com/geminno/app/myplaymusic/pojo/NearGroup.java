package com.geminno.app.myplaymusic.pojo;

/**
 * Created by chent on 2016/7/6.
 */
public class NearGroup {

    private Integer mugshot;
    private String name;
    private int num;
    private String introduce;
    private String address;

    public NearGroup(){}

    public NearGroup(Integer mugshot, String name, int num, String introduce, String address) {
        this.mugshot = mugshot;
        this.name = name;
        this.num = num;
        this.introduce = introduce;
        this.address = address;
    }

    public Integer getMugshot() {
        return mugshot;
    }

    public void setMugshot(Integer mugshot) {
        this.mugshot = mugshot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
