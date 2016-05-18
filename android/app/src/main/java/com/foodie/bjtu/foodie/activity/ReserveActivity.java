package com.foodie.bjtu.foodie.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.ReserveDishListAdapter;
import com.foodie.bjtu.foodie.entity.Dish;
import com.foodie.bjtu.foodie.entity.Restaurant;
import com.foodie.bjtu.foodie.listview.MyListView;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public class ReserveActivity extends Activity{
    //List<Dish> reserve_dish_list = new ArrayList<Dish>();
    //private ReserveDishListAdapter reserveDishListAdapter;
    //private MyListView dishListView;
    private String baseaddress = "http://123.56.143.59:8585/Foodie/order/addorder/?";
    private String address ="";

    //private RadioGroup radioGroup;
//    private int [] ids = {R.id.seat_checkBox1,R.id.seat_checkBox2,R.id.seat_checkBox3
//            ,R.id.seat_checkBox4,R.id.seat_checkBox5,R.id.seat_checkBox6};
//    private CheckBox[] checkBoxs;
    private Button reserve_sure;
    private EditText seat_count;
    private EditText reserve_time;
    private String restaurantid;
    private String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve);


//        Bundle bundle=getIntent().getExtras();
//        reserve_dish_list =(List<Dish>)bundle.getSerializable("reserve_dish_list");
//        Log.e("reserve_dish_list,re:",reserve_dish_list.toString());
        restaurantid = getIntent().getStringExtra("restaurantId");
        init();

    }
    private void init() {
        getBack();
//        dishListView = (MyListView) findViewById(R.id.reserve_dish_list);
//        reserveDishListAdapter = new ReserveDishListAdapter(getApplicationContext(), reserve_dish_list, dishListView);
//        dishListView.setAdapter(reserveDishListAdapter);
//        reserveDishListAdapter.notifyDataSetChanged();

        //radioGroup = (RadioGroup)findViewById(R.id.seat_radiogroup);

        seat_count = (EditText)findViewById(R.id.seat_count);
        reserve_time = (EditText)findViewById(R.id.reserve_time);
        reserve_sure = (Button)findViewById(R.id.reserve_sure);

        reserve_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);
                userid = sharedPreferences.getString("userId", "");
                address = baseaddress+ "userid="+userid+"&restaurantid="+restaurantid+"&time="+reserve_time.getText()+"&seats="+seat_count.getText() ;
                Log.e("address_reserve:", address);
                HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
                    @Override
                    public void onFinish(String response) {
                        final int code= handleSeatResponse(getApplicationContext(), response);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (code == 1){
                                    Toast toast = Toast.makeText(getApplicationContext(),
                                            "Reserve seat success!", Toast.LENGTH_SHORT);
                                    toast.show();
                                    finish();
                                }

                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

                //finish();
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

    private int handleSeatResponse(Context context, String response){
        int code = 0;
        if (!TextUtils.isEmpty(response)){
            try {
                JSONObject jsonObjectSon= new JSONObject(response);
                code = jsonObjectSon.getInt("code");

                address = "";

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return code;
    }
}
