package com.geminno.app.myplaymusic.pojo;

import java.util.Date;

/**
 * Created by Wenwen on 2016/6/28.
 */
public class Circle {

    private Integer headPic;
    private String name;
    private String body;
    private Integer picShare;
    private Double distance;
    private Date date;
    private Integer likeCount;
    private Integer commentCount;
    private String commentContext;
    private Integer age;
    private boolean sex;

    public Circle(Integer headPic, String name, String commentContext) {
        this.headPic = headPic;
        this.name = name;
        this.commentContext = commentContext;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public Circle(String name, Integer headPic, Integer age, boolean sex, String body, Date date, Integer picShare) {
        this.name = name;
        this.headPic = headPic;
        this.age = age;
        this.sex = sex;
        this.body = body;
        this.date = date;
        this.picShare = picShare;
    }

    public Circle(Integer headPic, String name, String body, Integer picShare,
                        Double distance, Date date, Integer likeCount, Integer commentCount, String commentContext) {
        this.headPic = headPic;
        this.name = name;
        this.body = body;
        this.picShare = picShare;
        this.distance = distance;
        this.date = date;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.commentContext=commentContext;
    }

    public Integer getHeadPic() {
        return headPic;
    }

    public void setHeadPic(Integer headPic) {
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPicShare() {
        return picShare;
    }

    public void setPicShare(Integer picShare) {
        this.picShare = picShare;
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
