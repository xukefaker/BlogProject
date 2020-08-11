package com.example.mainpage.entity;

import java.io.Serializable;

public class VideoEntity  implements Serializable {
    private int id;
    private String title;
    private String name;
    private  int dzCount;
    private  int collectCount;
    private  int commentCount;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDzCount(int dzCount) {
        this.dzCount = dzCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public int getDzCount() {
        return dzCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public int getCommentCount() {
        return commentCount;
    }
}
