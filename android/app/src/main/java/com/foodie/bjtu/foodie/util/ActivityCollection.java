package com.foodie.bjtu.foodie.util;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/19.
 */
public class ActivityCollection {
    public static List<AppCompatActivity> activities = new ArrayList<>();
    public static void addActivity(AppCompatActivity appCompatActivity){
        activities.add(appCompatActivity);
    }
    public static void removeA(AppCompatActivity appCompatActivity){
        activities.remove(appCompatActivity);
    }
    public static void finishAll(){
        for (AppCompatActivity a:activities){
            a.finish();
        }
    }
}
