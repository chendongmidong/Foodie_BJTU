package com.foodie.bjtu.foodie.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/16.
 */
public class Dish implements Serializable{
    private String id;
    private String photo;
    private String name;
    private int grade = 0;
    private int score;
    private int price;
    private String category;
    private int frequency;

    private int count;//预定菜的份数

    public Dish(String id, String name, int score, int price, String category, int frequency){
        this.id = id;
        this.category = category;
        this.frequency = frequency;
        this.score = score;
        this.name = name;
        //this.photo = photo;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
