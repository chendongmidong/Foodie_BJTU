package com.foodie.bjtu.foodie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.entity.Restaurant;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhao on 2016/5/12.
 */
public class RestaurantAdapter extends BaseAdapter {
    private List<Restaurant> mRestaurants;
    private Context mContext;

    public RestaurantAdapter(List mRestaurants, Context mContext) {
        this.mRestaurants = mRestaurants;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    @Override
    public Object getItem(int i) {
        return mRestaurants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Restaurant mRestaurant = mRestaurants.get(i);
        ViewHolder mViewHolder = null;
        if (view == null){
            mViewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.restaurant_item,null);
            mViewHolder.restaurantPhoto = (ImageView)view.findViewById(R.id.restaurant_photo);
            mViewHolder.restaurantName = (TextView) view.findViewById(R.id.restaurant_name);
            mViewHolder.restaurantGrade = (TextView)view.findViewById(R.id.restaurant_grade);
            mViewHolder.restaurantLocation = (TextView) view.findViewById(R.id.restaurant_location);
            view.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(mRestaurant.getPhoto(), mViewHolder.restaurantPhoto);

        mViewHolder.restaurantName.setText(mRestaurant.getName());
        mViewHolder.restaurantGrade.setText(mRestaurant.getGrade()+"");
        mViewHolder.restaurantLocation.setText(mRestaurant.getLocation());
        return view;
    }

    class ViewHolder{
        ImageView restaurantPhoto;
        TextView restaurantName;
        TextView restaurantGrade;
        TextView restaurantLocation;
    }
}
