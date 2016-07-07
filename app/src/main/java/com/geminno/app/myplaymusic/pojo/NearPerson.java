package com.geminno.app.myplaymusic.pojo;

import java.util.Date;

/**
 * Created by chent on 2016/7/6.
 */
public class NearPerson {

    private Integer mugshot;
    private String name;
    private String instrument;
    private String rank;
    private Integer addFriend;
    private Double distance;
    private Date date;

    public NearPerson(){}
    public NearPerson(Integer mugshot, String name, String instrument, String rank, Integer addFriend, Double distance, Date date) {
        this.mugshot = mugshot;
        this.name = name;
        this.instrument = instrument;
        this.rank = rank;
        this.addFriend = addFriend;
        this.distance = distance;
        this.date = date;
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getAddFriend() {
        return addFriend;
    }

    public void setAddFriend(Integer addFriend) {
        this.addFriend = addFriend;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
