package com.foodie.bjtu.foodie.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.activity.GPSNaviActivity;
import com.foodie.bjtu.foodie.adapter.RestaurantAdapter;
import com.foodie.bjtu.foodie.entity.Restaurant;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/12.
 */
public class RestaurantFragment extends Fragment {
    private ListView mRestaurantListView;
    private List<Restaurant> mRestaurants;
    private RestaurantAdapter mRestaurantAdapter;
    private String address = "http://123.56.143.59:8585/Foodie/restaurants/getRestaurants";
    private ProgressBar progressBar;

    public static RestaurantFragment newInstance(){
        RestaurantFragment rf = new RestaurantFragment();
        Bundle b = new Bundle();
        rf.setArguments(b);
        return rf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageLoader imageLoader = ImageLoader.getInstance();
        mRestaurants = new ArrayList<Restaurant>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_fragment,container,false);
        mRestaurantListView = (ListView)view.findViewById(R.id.restaurant_list_view);
        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);
        mRestaurantAdapter = new RestaurantAdapter(mRestaurants,getActivity());
        mRestaurantListView.setAdapter(mRestaurantAdapter);
        mRestaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), GPSNaviActivity.class);
                startActivity(intent);
            }
        });
        if (!mRestaurants.isEmpty()){
            mRestaurants.clear();
        }
        refresh();
        return view;
    }
    private void refresh(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
            @Override
            public void onFinish(String response) {
                handleMomentResponse(getContext(), response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRestaurantAdapter.notifyDataSetChanged();
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
                JSONArray moments = new JSONArray(response);
                for (int i=0;i<moments.length();i++)
                {
                    JSONObject jsonObjectSon= (JSONObject)moments.opt(i);
                    String name = jsonObjectSon.getString("name");
                    String avatar = jsonObjectSon.getString("avatarUrl");
                    String address = jsonObjectSon.getString("address");
                    int score = jsonObjectSon.getInt("score");
                    Restaurant moment = new Restaurant(0,avatar,name,score,address);
                    mRestaurants.add(moment);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
