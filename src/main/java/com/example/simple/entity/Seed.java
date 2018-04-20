package com.example.simple.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
 * "212121@草榴社區@Kin8tengoku-893"
 */

@Entity //实体类的注解
public class Seed {

    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private int id;



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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;

}
