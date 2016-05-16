package com.foodie.bjtu.foodie.entity;

/**
 * Created by zhao on 2016/5/15.
 */
public class Moment {

    private String name;
    private String avatarUrl;
    private String content;
    private String[] imageUrls;

    public Moment(String name, String avatarUrl, String content, String[] imageUrls) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.content = content;
        this.imageUrls = imageUrls;
    }


    public String getName() {
        return name;
    }

    public String avatorUrl() {
        return avatarUrl;
    }

    public String getContent() { return content; }

    public String[] getImageUrl() {
        return imageUrls;
    }
}
