package com.example.simple.entity;


import java.util.Date;

/**
 * day
 * :
 * "2014-04-04"
 * hits
 * :
 * "199"
 * size
 * :
 * "1662MB"
 * title
 * :
 * "212121@草榴社區@Kin8tengoku-893 金髪天国 日本男兒小尺寸已經滿足不了美女 超可愛金髮女傭美女羅莎莉"
 */
public class Seed {
    private Date day;

    private int hits;

    private String size;

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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    private String title;

}
