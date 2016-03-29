package com.example.FoodieAndroidApp.widge;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.FoodieAndroidApp.R;
//import com.example.FoodieAndroidApp.activity.ImagePagerActivity;
import com.example.FoodieAndroidApp.model.Moment;
import com.example.FoodieAndroidApp.model.Restaurant;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/3/29.
 */
public class MomentAdapter extends BaseAdapter{

    private List<Moment> moments;
    Context context;
    public MomentAdapter(Context context,List<Moment> moments) {
        this.moments = moments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return moments.size();
    }

    @Override
    public Object getItem(int position) {
        return moments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Moment moment = moments.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.moment_list_item,null);
            viewHolder.avator = (ImageView)convertView.findViewById(R.id.avator);
            viewHolder.name = (TextView)convertView.findViewById(R.id.user_name);
            viewHolder.content = (TextView)convertView.findViewById(R.id.content);
            viewHolder.images = (NoScrollGridView)convertView.findViewById(R.id.images);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(moment.avatorUrl(), viewHolder.avator);
        viewHolder.name.setText(moment.getName());
        viewHolder.content.setText(moment.getContent());
        if (moment.getImageUrl() != null&& moment.getImageUrl().length > 0){
            viewHolder.images.setVisibility(View.VISIBLE);
            List<String> urls = new ArrayList<String>();
            for (String s:moment.getImageUrl()){
                urls.add(s);
            }
            viewHolder.images.setAdapter(new MyGridAdapter(context,urls));
            viewHolder.images.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    imageBrower(position,moment.getImageUrl());
                }
            });
        }else{
            viewHolder.images.setVisibility(View.GONE);
        }

        return convertView;
    }

//    private void imageBrower(int position, String[] urls) {
//        Intent intent = new Intent(context, ImagePagerActivity.class);
//        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
//        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
//        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
//        context.startActivity(intent);
//    }

    class ViewHolder{
        ImageView avator;
        TextView name;
        TextView content;
        NoScrollGridView images;
    }
}
