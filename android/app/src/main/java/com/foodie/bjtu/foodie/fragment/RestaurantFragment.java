package com.foodie.bjtu.foodie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.RestaurantAdapter;
import com.foodie.bjtu.foodie.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/12.
 */
public class RestaurantFragment extends Fragment {

    private ListView mRestaurantListView;
    private List<Restaurant> mRestaurants;
    private RestaurantAdapter mRestaurantAdapter;

    public static RestaurantFragment newInstance(){
        RestaurantFragment rf = new RestaurantFragment();
        Bundle b = new Bundle();
        rf.setArguments(b);
        return rf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestaurants = new ArrayList<Restaurant>();
        mRestaurants.add(new Restaurant(1,R.drawable.rabbit,"cao",R.drawable.rabbit,"dd"));
        mRestaurants.add(new Restaurant(1,R.drawable.rabbit,"cao",R.drawable.rabbit,"dd"));
        mRestaurants.add(new Restaurant(1,R.drawable.rabbit,"cao",R.drawable.rabbit,"dd"));
        mRestaurants.add(new Restaurant(1,R.drawable.rabbit,"cao",R.drawable.rabbit,"dd"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_fragment,container,false);
        mRestaurantListView = (ListView)view.findViewById(R.id.restaurant_list_view);
        mRestaurantAdapter = new RestaurantAdapter(mRestaurants,getActivity());
        mRestaurantListView.setAdapter(mRestaurantAdapter);
        return view;
    }
}
