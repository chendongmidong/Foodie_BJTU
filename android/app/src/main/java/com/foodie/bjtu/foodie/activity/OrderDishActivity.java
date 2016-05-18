package com.foodie.bjtu.foodie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.ReserveDishListAdapter;
import com.foodie.bjtu.foodie.entity.Dish;
import com.foodie.bjtu.foodie.listview.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
public class OrderDishActivity extends Activity{
    List<Dish> dishList = new ArrayList<Dish>();
    List<Dish> reserve_dish_list = new ArrayList<Dish>();
    private ReserveDishListAdapter reserveDishListAdapter;
    private MyListView dishListView;

    private Button sure_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_dish);


        Bundle bundle=getIntent().getExtras();
        dishList =(List<Dish>)bundle.getSerializable("dishList");
        Log.e("dishList,re:", dishList.toString());
        init();
    }
    private void init() {
        getBack();
        dishListView = (MyListView) findViewById(R.id.order_dish_list);
        reserveDishListAdapter = new ReserveDishListAdapter(getApplicationContext(), dishList,reserve_dish_list, dishListView);
        dishListView.setAdapter(reserveDishListAdapter);
        reserveDishListAdapter.notifyDataSetChanged();

        //radioGroup = (RadioGroup)findViewById(R.id.seat_radiogroup);

        sure_Button = (Button)findViewById(R.id.order_dish_sure);
        sure_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        checkBoxs = new CheckBox[ids.length];
//        for (int i = 0; i < ids.length; i++) {
//            checkBoxs[i] = (CheckBox) this.findViewById(ids[i]);
//        }

    }

    private void getBack(){
        ImageView back = (ImageView)findViewById(R.id.back_img);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent intent = new Intent();
//                intent.setClass(ReserveActivity.this, RestaurantDetailActivity.class);
//                startActivity(intent);
            }
        });
    }

}
