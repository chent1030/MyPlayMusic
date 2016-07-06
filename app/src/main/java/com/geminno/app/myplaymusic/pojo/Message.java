package com.geminno.app.myplaymusic.pojo;

import java.util.Date;

/**
 * Created by chent on 2016/7/6.
 */
public class Message {

    private Integer mugshot;
    private String name;
    private String body;
    private Double distance;
    private Date date;
    public Message(){}
    public Message(Integer mugshot, String name, String body, Double distance, Date date) {
        this.mugshot = mugshot;
        this.name = name;
        this.body = body;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
