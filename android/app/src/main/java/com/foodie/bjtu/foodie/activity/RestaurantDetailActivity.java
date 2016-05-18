package com.foodie.bjtu.foodie.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.DishListAdapter;
import com.foodie.bjtu.foodie.entity.Dish;
import com.foodie.bjtu.foodie.entity.Restaurant;
import com.foodie.bjtu.foodie.fragment.RestaurantFragment;
import com.foodie.bjtu.foodie.listview.MyListView;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public class RestaurantDetailActivity extends Activity {
    List<Dish> dishList = new ArrayList<Dish>();
    List<Dish> reserve_dish_list = new ArrayList<Dish>();
    private TextView restaurant_name;
    private TextView restaurant_intro;
    private TextView restaurant_adress;
    private TextView restaurant_phone;

    private ImageView restaurant_grade;
    private ImageView restaurant_photo;
    private ImageView back;
    private Button reserve_button;
    private Button order_dish_button;

    private LinearLayout restaurant_address_Linear;

    private DishListAdapter dishListAdapter;
    private MyListView dishListView;
    private Restaurant restaurant;

    private String baseaddress = "http://123.56.143.59:8585/Foodie/";
    private String address ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail);

        Intent intent = this.getIntent();
        String restaurant_name = intent.getStringExtra("restaurantname");
        address = baseaddress +"restaurants/getRestaurant?name="+restaurant_name;
        Log.e("address:",address);
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
            @Override
            public void onFinish(String response) {
                handleRestanrantResponse(getApplicationContext(), response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        init();
                    }
                });
            }

            @Override
            public void onError(Exception e) {

            }
    });

    }

    private void init(){
        getBack();
        restaurant_name = (TextView)findViewById(R.id.restaurant_name);
        restaurant_name.setText(restaurant.getName());
        restaurant_intro = (TextView)findViewById(R.id.restaurant_intro);
        restaurant_intro.setText(restaurant.getIntro());
        restaurant_adress = (TextView)findViewById(R.id.restaurant_adress);
        restaurant_adress.setText(restaurant.getLocation());
        restaurant_phone = (TextView)findViewById(R.id.restaurant_phone);
        restaurant_phone.setText(restaurant.getPhone());

        restaurant_photo = (ImageView)findViewById(R.id.restaurant_photo);
        ImageLoader.getInstance().displayImage("http://pic1a.nipic.com/2008-10-06/2008106145837425_2.jpg",restaurant_photo);

        restaurant_address_Linear = (LinearLayout)findViewById(R.id.restaurant_address_Linear);
        restaurant_address_Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RestaurantDetailActivity.this, GPSNaviActivity.class);
                startActivity(intent);
            }
        });

        dishListView = (MyListView)findViewById(R.id.restaurant_dish_list);

        reserve_button = (Button)findViewById(R.id.reserve_button);
        order_dish_button = (Button)findViewById(R.id.dish_order);

        dishListAdapter = new DishListAdapter(getApplicationContext(),dishList,dishListView,reserve_dish_list);
        dishListView.setAdapter(dishListAdapter);
        dishListAdapter.notifyDataSetChanged();

        address = baseaddress+"dish/getDishesByRestauId?restaurantId="+restaurant.getStringid();
        Log.e("address_dish:", address);
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
            @Override
            public void onFinish(String response) {
                handleDishesResponse(getApplicationContext(), response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        dishListAdapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onError(Exception e) {

            }
        });


        reserve_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantDetailActivity.this, ReserveActivity.class);
//                Bundle bundle = new Bundle();
//
//                Log.e("reserve_dish_list:", reserve_dish_list.toString());
//                bundle.putSerializable("reserve_dish_list", (Serializable) reserve_dish_list);
//                intent.putExtras(bundle);
                intent.putExtra("restaurantId",restaurant.getStringid());
                startActivity(intent);

            }
        });
        order_dish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantDetailActivity.this, OrderDishActivity.class);
                Bundle bundle = new Bundle();

                Log.e("dish_list:", dishList.toString());
                bundle.putSerializable("dishList", (Serializable) dishList);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }

    private void getBack(){
        back = (ImageView)findViewById(R.id.back_img);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent intent = new Intent();
//                intent.setClass(RestaurantDetailActivity.this, RestaurantFragment.class);
//                startActivity(intent);
            }
        });
    }

    private void handleRestanrantResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray restaurants = new JSONArray(response);
                Log.v("dkjkssdjk",restaurants.toString());
                if(restaurants.length()>0){
                    JSONObject jsonObjectSon= (JSONObject)restaurants.opt(0);
                    String name = jsonObjectSon.getString("name");
                    String avatar = jsonObjectSon.getString("avatarUrl");
                    String address = jsonObjectSon.getString("address");
                    int score = jsonObjectSon.getInt("score");
                    String id = jsonObjectSon.getString("id");
                    String intro = jsonObjectSon.getString("intro");
                    String phone = jsonObjectSon.getString("phone");
                    restaurant = new Restaurant(0,avatar,name,score,address);
                    restaurant.setStringid(id);
                    restaurant.setIntro(intro);
                    restaurant.setPhone(phone);


                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void handleDishesResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)) try {
            JSONArray dishes = new JSONArray(response);
            Log.e("dishes,Json",dishes.toString());
            for (int i = 0; i < dishes.length(); i++) {
                JSONObject jsonObjectSon = (JSONObject) dishes.opt(i);
                String name = jsonObjectSon.getString("name");
                int price = jsonObjectSon.getInt("price");
                int frequency = jsonObjectSon.getInt("frequency");
                String category = jsonObjectSon.getString("category");
                int score = jsonObjectSon.getInt("score");
                String id = jsonObjectSon.getString("id");
                String photo = jsonObjectSon.getString("photo");
                Dish dish = new Dish(id, name, score, price, category, frequency);
                dish.setPhoto(photo);
                dishList.add(dish);
                Log.e("dishes_name,Json", name);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
