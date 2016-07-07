package com.geminno.app.myplaymusic.pojo;

/**
 * Created by chent on 2016/7/6.
 */
public class NearBand {

    private Integer mugshot;
    private String name;
    private String stylistics;
    private String introduce;
    private Double distance;

    public NearBand(){}

    public NearBand(Integer mugshot, String name, String stylistics, String introduce, Double distance) {
        this.mugshot = mugshot;
        this.name = name;
        this.stylistics = stylistics;
        this.introduce = introduce;
        this.distance = distance;
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

    public String getStylistics() {
        return stylistics;
    }

    public void setStylistics(String stylistics) {
        this.stylistics = stylistics;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
