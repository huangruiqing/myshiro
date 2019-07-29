package com.example.demo.model;

import java.util.Date;

/**
 * @ClassName FastjsonTest
 * @Description
 * @Author huangrq
 * @Date 2019/7/24 17:30
 */
public class FastjsonTest {

    private int id;
    private String string;
    private String ignore;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
