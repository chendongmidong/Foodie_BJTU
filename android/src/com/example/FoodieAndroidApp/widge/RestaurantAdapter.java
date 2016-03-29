package com.example.FoodieAndroidApp.widge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.FoodieAndroidApp.R;
import com.example.FoodieAndroidApp.model.Restaurant;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by zhao on 2016/3/28.
 */
public class RestaurantAdapter extends BaseAdapter {
    private List<Restaurant> restaurants;
    Context context;
    public RestaurantAdapter(Context context,List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        this.context = context;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Restaurant restaurant = restaurants.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.restaurant_item,null);
            viewHolder.restaurantPhoto = (ImageView)convertView.findViewById(R.id.restaurant_photo);
            viewHolder.restaurantName = (TextView) convertView.findViewById(R.id.restaurant_name);
            viewHolder.restaurantGrade = (ImageView)convertView.findViewById(R.id.restaurant_grade);
            viewHolder.restaurantLocation = (TextView) convertView.findViewById(R.id.restaurant_location);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.restaurantPhoto.setImageResource(restaurant.getPhoto());
        viewHolder.restaurantName.setText(restaurant.getName());
        viewHolder.restaurantGrade.setImageResource(restaurant.getGrade());
        viewHolder.restaurantLocation.setText(restaurant.getLocation());

        return convertView;
    }

    class ViewHolder{
        ImageView restaurantPhoto;
        TextView restaurantName;
        ImageView restaurantGrade;
        TextView restaurantLocation;
    }
}
