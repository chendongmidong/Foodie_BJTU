package com.foodie.bjtu.foodie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.entity.Dish;
import com.foodie.bjtu.foodie.listview.MyListView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public class ReserveDishListAdapter extends BaseAdapter {
    List<Dish> reservedishList;
    List<Dish> dishList;
    LayoutInflater inflater;
    MyListView listView;
    private Context context;

    //TextView dish_count;
    //ImageView dish_minus;
    //int count;
    //int removePosition = 0;
    //Dish dish;

    public ReserveDishListAdapter(Context context,List<Dish> dishList, List<Dish> reservedishList, MyListView listView) {
        this.context = context;
        this.reservedishList = reservedishList;
        this.inflater = LayoutInflater.from(context);
        this.listView = listView;
        this.dishList = dishList;
    }

    @Override
    public int getCount() {
        return dishList.size();
    }

    @Override
    public Object getItem(int position) {
        return dishList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = (View)inflater.inflate(R.layout.reserve_dish_list_item, null);
        convertView.setTag(position);

        //dish = reservedishList.get(position);
        TextView name = (TextView)convertView.findViewById(R.id.dish_name);
        name.setText(dishList.get(position).getName());

        ImageView dish_add = (ImageView)convertView.findViewById(R.id.dish_add);
        ImageView dish_minus = (ImageView)convertView.findViewById(R.id.dish_minus);
        TextView dish_count = (TextView)convertView.findViewById(R.id.dish_count);

        //Log.e("dish_count", (String) dish_count.getText());
        int count = Integer.parseInt((String)dish_count.getText());
        //Log.e("dish_count_num",count+"");
        if(count<=0){
            dish_minus.setVisibility(View.INVISIBLE);
            dish_count.setVisibility(View.INVISIBLE);
        }
        dish_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dish_count = (TextView)listView.findViewWithTag(position).findViewById(R.id.dish_count);
                ImageView dish_minus = (ImageView)listView.findViewWithTag(position).findViewById(R.id.dish_minus);
                int count = Integer.parseInt((String)dish_count.getText());

                Log.e("order_dish_position", position+"");
                Dish di = dishList.get(position);
                //ÔÚ reserve_dish_list ÖÐÌí¼Ódish
                if(count==0){
                    Log.e("dish_count", (String) dish_count.getText());
                    reservedishList.add(di);
                    Log.e("adddishname",  di.getName());
                }
                count++;
                dish_count.setText(count+"");
                di.setCount(count);

                dish_minus.setVisibility(View.VISIBLE);
                dish_count.setVisibility(View.VISIBLE);
            }
        });
        dish_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dish_count = (TextView)listView.findViewWithTag(position).findViewById(R.id.dish_count);
                ImageView dish_minus = (ImageView)listView.findViewWithTag(position).findViewById(R.id.dish_minus);
                int count = Integer.parseInt((String)dish_count.getText());
                count = count-1;
                Dish d = dishList.get(position);
                if(count<=0){
                    dish_minus.setVisibility(View.INVISIBLE);
                    dish_count.setVisibility(View.INVISIBLE);
                    Log.e("minus_position", position + "");

                    reservedishList.remove(d);
                }
                dish_count.setText(count+"");
                d.setCount(count);

            }
        });
        //dish_minus = (ImageView)convertView.findViewById(R.id.dish_minus);
        //dish_count = (TextView)convertView.findViewById(R.id.dish_count);

//        count = Integer.parseInt((String)dish_count.getText());
//        if(count<=0){
//            dish_minus.setVisibility(View.INVISIBLE);
//            dish_count.setVisibility(View.INVISIBLE);
//        }
//        dish_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count = Integer.parseInt((String)dish_count.getText());
//                count++;
//                dish_count.setText(count);
//                dish_minus.setVisibility(View.VISIBLE);
//                dish_count.setVisibility(View.VISIBLE);
//
//                dish.setCount(count);
//            }
//        });
//        dish_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count = Integer.parseInt((String)dish_count.getText());
//                count = count-1;
//                if(count<=0){
//                    dish_minus.setVisibility(View.INVISIBLE);
//                    dish_count.setVisibility(View.INVISIBLE);
//                    reservedishList.remove(removePosition);
//                }
//                dish_count.setText(count);
//                dish.setCount(count);
//
//            }
//        });

        return convertView;

    }
}
