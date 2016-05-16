package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/12.
 */
public class Restaurant {

    private int id;
    private int photo;
    private String name;
    private int grade;
    private String location;

    public Restaurant(int id, int photo, String name, int grade, String location) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.grade = grade;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public int getPhoto() {
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
}
