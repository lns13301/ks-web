package com.gyuhan.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Work {
    @Id
    private String position;
    private String company;
    private String time;
    private String desc;

    public Work() {
    }

    public Work(String position, String company, String time, String desc) {
        this.position = position;
        this.company = company;
        this.time = time;
        this.desc = desc;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }
}
