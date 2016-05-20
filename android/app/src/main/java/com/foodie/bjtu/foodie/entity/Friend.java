package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/16.
 */
public class Friend {

    public Friend(String name, int id,String headPortrait) {
        this.name = name;
        this.headPortrait = headPortrait;
        this.id = id;
    }

    private String name;
    private String headPortrait;
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getHeadPortrait() {
        return headPortrait;
    }
}
