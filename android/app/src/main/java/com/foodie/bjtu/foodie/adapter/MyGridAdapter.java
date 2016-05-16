package com.foodie.bjtu.foodie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.foodie.bjtu.foodie.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhao on 2016/5/15.
 */
public class MyGridAdapter extends ArrayAdapter<String> {
    private int resourceId;
    public MyGridAdapter(Context context, int textResourceId, List<String> objects){
        super(context,textResourceId,objects);
        this.resourceId = textResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String url = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
            viewHolder.imageView = (ImageView)view.findViewById(R.id.album_image);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        ImageLoader.getInstance().displayImage(url,viewHolder.imageView);
        return view;
    }

    class ViewHolder{
        ImageView imageView;
    }
}
