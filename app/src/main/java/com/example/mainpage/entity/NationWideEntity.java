package com.example.mainpage.entity;

import java.io.Serializable;

public class NationWideEntity implements Serializable {
private String author;
private  String title;
private int pic;
private String time;

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getPic() {
        return pic;
    }

    public String getTime() {
        return time;
    }

    public int getHead() {
        return head;
    }

    private int head;
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
