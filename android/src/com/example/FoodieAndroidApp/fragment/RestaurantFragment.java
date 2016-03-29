package com.example.FoodieAndroidApp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.FoodieAndroidApp.R;
import com.example.FoodieAndroidApp.model.Restaurant;
import com.example.FoodieAndroidApp.widge.RestaurantAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/3/28.
 */
public class RestaurantFragment extends Fragment {

    private ListView restauListView;
    private List<Restaurant> restaurantList;
    private RestaurantAdapter restaurantAdapter;
    public static RestaurantFragment getInstance(){
        RestaurantFragment rf = new RestaurantFragment();
        Bundle b = new Bundle();
        rf.setArguments(b);
        return rf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantList = new ArrayList<Restaurant>();
        restaurantList.add(new Restaurant(1,R.drawable.banana,"cao",1,"dd"));
        restaurantList.add(new Restaurant(1,R.drawable.banana,"cao",1,"dd"));
        restaurantList.add(new Restaurant(1,R.drawable.banana,"cao",1,"dd"));
        restaurantList.add(new Restaurant(1,R.drawable.banana,"cao",1,"dd"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_fragment,container,false);
        restauListView = (ListView)view.findViewById(R.id.restaurant_list_view);
        restaurantAdapter = new RestaurantAdapter(getActivity(),restaurantList);
        restauListView.setAdapter(restaurantAdapter);
        return view;
    }
}
