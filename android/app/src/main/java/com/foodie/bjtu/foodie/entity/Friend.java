package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/16.
 */
public class Friend {

    public Friend(String name, String headPortrait) {
        this.name = name;
        this.headPortrait = headPortrait;
    }

    private String name;
    private String headPortrait;

    public String getName() {
        return name;
    }
    public String getHeadPortrait() {
        return headPortrait;
    }
}
