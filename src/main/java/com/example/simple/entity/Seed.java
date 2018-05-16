package com.example.simple.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 */

@Entity //实体类的注解
public class Seed {

    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private int id;

    private String day;

    private int hits;

    private String moiveID;

    private String size;

    private String title;

    private String url;

    private Date createDate;

    public String getMoiveID() {
        return moiveID;
    }

    public void setMoiveID(String moiveID) {
        this.moiveID = moiveID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
