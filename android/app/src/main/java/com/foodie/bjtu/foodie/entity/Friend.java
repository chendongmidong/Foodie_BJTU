package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/16.
 */
public class Friend {

    public Friend(String name, int headPortrait) {
        this.name = name;
        this.headPortrait = headPortrait;
    }

    private String name;
    private int headPortrait;

    public String getName() {
        return name;
    }

    public int getHeadPortrait() {
        return headPortrait;
    }

}
