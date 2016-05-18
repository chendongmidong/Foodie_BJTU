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
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 */
public class DishListAdapter extends BaseAdapter {
    List<Dish> dishList;
    List<Dish> reserve_dish_list;
    LayoutInflater inflater;
    MyListView listView;

    private Context context;
    //TextView dish_count;
    //ImageView dish_minus;
    //int count = 0;
    int reserve_position;
    //Dish dish;

    public DishListAdapter(Context context, List<Dish> dishList, MyListView listView, List<Dish> reserve_dish_list) {
        this.context = context;
        this.dishList = dishList;
        this.inflater = LayoutInflater.from(context);
        this.listView = listView;
        this.reserve_dish_list = reserve_dish_list;
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
        convertView = (View)inflater.inflate(R.layout.dish_list_item, parent, false);
        convertView.setTag(position);

        Log.e("dishListAdapter,positon",position+"");
        //reserve_position = position;
        //dish = dishList.get(position);
        TextView name = (TextView)convertView.findViewById(R.id.dish_name);
        name.setText(dishList.get(position).getName());
        Log.e("dishListAdapter,getName", dishList.get(position).getName());
        //TextView grade = (TextView)convertView.findViewById(R.id.dish_grade);
        TextView category = (TextView)convertView.findViewById(R.id.dish_category);
        category.setText(dishList.get(position).getCategory());

        TextView frequency = (TextView)convertView.findViewById(R.id.dish_frequency);
        frequency.setText(dishList.get(position).getFrequency()+"");

        TextView price = (TextView)convertView.findViewById(R.id.dish_price);
        price.setText(dishList.get(position).getPrice() + "");

        ImageView dish_picture = (ImageView)convertView.findViewById(R.id.dish_picture);
        ImageLoader.getInstance().displayImage(dishList.get(position).getPhoto()+"",dish_picture);

//        ImageView dish_add = (ImageView)convertView.findViewById(R.id.dish_add);
//        ImageView dish_minus = (ImageView)convertView.findViewById(R.id.dish_minus);
//        TextView dish_count = (TextView)convertView.findViewById(R.id.dish_count);
//
//        Log.e("dish_count",(String)dish_count.getText());
//        int count = Integer.parseInt((String)dish_count.getText());
//        Log.e("dish_count_num",count+"");
//        if(count<=0){
//            dish_minus.setVisibility(View.INVISIBLE);
//            dish_count.setVisibility(View.INVISIBLE);
//        }
//        dish_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView dish_count = (TextView)listView.findViewWithTag(position).findViewById(R.id.dish_count);
//                ImageView dish_minus = (ImageView)listView.findViewWithTag(position).findViewById(R.id.dish_minus);
//                int count = Integer.parseInt((String)dish_count.getText());
//
//                Dish di = dishList.get(position);
//                //在 reserve_dish_list 中添加dish
//                if(count==0){
//                    Log.e("dish_count", (String) dish_count.getText());
//                    reserve_dish_list.add(di);
//                    Log.e("adddishname",  di.getName());
//                }
//                count++;
//                dish_count.setText(count+"");
//                di.setCount(count);
//
//                dish_minus.setVisibility(View.VISIBLE);
//                dish_count.setVisibility(View.VISIBLE);
//            }
//        });
//        dish_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TextView dish_count = (TextView)listView.findViewWithTag(position).findViewById(R.id.dish_count);
//                ImageView dish_minus = (ImageView)listView.findViewWithTag(position).findViewById(R.id.dish_minus);
//                int count = Integer.parseInt((String)dish_count.getText());
//                count = count-1;
//                Dish d = dishList.get(position);
//                if(count<=0){
//                    dish_minus.setVisibility(View.INVISIBLE);
//                    dish_count.setVisibility(View.INVISIBLE);
//                    Log.e("minus_position", position + "");
//                    //reserve_dish_list.remove(position);
//
//                    reserve_dish_list.remove(d);
//                }
//                dish_count.setText(count+"");
//                d.setCount(count);
//
//            }
//        });

        return convertView;

    }
}
