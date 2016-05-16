package com.foodie.bjtu.foodie.util;

/**
 * Created by zhao on 2016/5/15.
 */
public interface HttpCallBackListenr {
    void onFinish(String response);
    void onError(Exception e);
}
