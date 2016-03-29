package com.example.FoodieAndroidApp.model;

/**
 * Created by zhao on 2016/3/29.
 */
public class Moment {
    private String name;
    private String avatorUrl;
    private String content;
    private String[] imageUrls;

    public Moment(String name, String avatorUrl, String content, String[] imageUrls) {
        this.name = name;
        this.avatorUrl = avatorUrl;
        this.content = content;
        this.imageUrls = imageUrls;
    }


    public String getName() {
        return name;
    }

    public String avatorUrl() {
        return avatorUrl;
    }

    public String getContent() { return content; }

    public String[] getImageUrl() {
        return imageUrls;
    }
}
