package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/12.
 */
public class Restaurant {

    private int id;
    private String stringid;
    private String photo;
    private String name;
    private int grade;
    private String location;
    private String intro;
    private String phone;


    public Restaurant(int id, String photo, String name, int grade, String location) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.grade = grade;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getLocation() {
        return location;
    }

    public String getStringid() {
        return stringid;
    }

    public void setStringid(String stringid) {
        this.stringid = stringid;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
