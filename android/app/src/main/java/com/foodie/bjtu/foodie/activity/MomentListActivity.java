package com.foodie.bjtu.foodie.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.foodie.bjtu.foodie.Constant;
import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.MomentAdapter;
import com.foodie.bjtu.foodie.entity.Moment;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;
import com.foodie.bjtu.foodie.widget.RefreshableView;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/15.
 */
public class MomentListActivity extends Activity {
    RefreshableView refreshableView;
    private ListView listView;
    MomentAdapter momentAdapter;
    List<Moment> list = new ArrayList<Moment>();
    private int flag;
    private String address;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.moments_list);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);

        if (flag == Constant.FRIENDS_MOMENTS) {
            address = "http://123.56.143.59:8585/Foodie/moments/getFriendsMoments";
        } else if (flag == Constant.FRIENDS_MOMENTS) {
            SharedPreferences sharedPreferences = getSharedPreferences("userInfo",MODE_PRIVATE);
            int userId = sharedPreferences.getInt("user",0);
            address = "http://http://123.56.143.59:8585/moments/getMyMoments/?name="+userId;
        }else if (flag ==3){
            String keyWord = intent.getStringExtra("keyWord");
            address = "http://http://123.56.143.59:8585/moments/searchMoments?key="+keyWord;
            Log.d("keyWord",keyWord);
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        listView = (ListView) findViewById(R.id.show_moments);
//        String[] urls = {"http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg", "http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg", "http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg"};
//        list.add(new Moment("Mike", "http://pic1a.nipic.com/2008-10-06/2008106145837425_2.jpg","do something",urls));

        momentAdapter = new MomentAdapter(list,MomentListActivity.this);
        listView.setAdapter(momentAdapter);
        refresh();
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                if (!list.isEmpty()){
                    list.clear();
                }
                refresh();
                refreshableView.finishRefreshing();
            }
        }, 0);
    }

    private void refresh(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
            @Override
            public void onFinish(String response) {
                handleMomentResponse(MomentListActivity.this, response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        momentAdapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
            @Override
            public void onError(Exception e) {

            }
        });
    }


    public void handleMomentResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)){
            try {
//                JSONObject jsonObject = new JSONObject(response);
//                JSONArray moments = jsonObject.getJSONArray("content");
                JSONArray moments = new JSONArray(response);
                for (int i=0;i<moments.length();i++)
                {
                    JSONObject jsonObjectSon= (JSONObject)moments.opt(i);
                    String name = jsonObjectSon.getString("name");
                    String avatar = jsonObjectSon.getString("avatorUrl");
                    String content = jsonObjectSon.getString("content");
                    JSONArray urls = null;
                    if (!jsonObjectSon.isNull("imageUrls")) {
                        urls = jsonObjectSon.getJSONArray("imageUrls");
                    }
                    String[] stringUrls = null;
                    if (urls != null) {
                        stringUrls = new String[urls.length()];
                        for (int i1 = 0; i1 < urls.length(); i1++) {
                            stringUrls[i1] = urls.optString(i1);
                        }
                    }
                    Moment moment = new Moment(name,avatar,content,stringUrls);
                    list.add(moment);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

