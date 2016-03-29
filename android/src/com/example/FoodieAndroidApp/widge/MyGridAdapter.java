package com.example.FoodieAndroidApp.widge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.FoodieAndroidApp.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by zhao on 2016/3/29.
 */
public class MyGridAdapter extends BaseAdapter {
    private List<String> urls;
    Context context;
    public MyGridAdapter(Context context,List<String> urls) {
        this.urls = urls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String url = urls.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item,null);
            viewHolder.photo = (ImageView)convertView.findViewById(R.id.album_image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(url, viewHolder.photo);

        return convertView;
    }

    class ViewHolder{
        ImageView photo;
    }
}
