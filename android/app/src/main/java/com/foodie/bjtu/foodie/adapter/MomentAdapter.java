package com.foodie.bjtu.foodie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.activity.ImagePagerActivity;
import com.foodie.bjtu.foodie.entity.Moment;
import com.foodie.bjtu.foodie.widget.NoScrollGridView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/15.
 */
public class MomentAdapter extends BaseAdapter{
    private List<Moment> mMoments;
    private Context mContext;

    public MomentAdapter(List<Moment> mMoments, Context mContext) {
        this.mMoments = mMoments;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mMoments.size();
    }

    @Override
    public Object getItem(int i) {
        return mMoments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Moment mMoment = mMoments.get(i);
        ViewHolder mViewHolder = null;
        if (view == null){
            mViewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.moment_list_item,null);
            mViewHolder.avator = (ImageView)view.findViewById(R.id.avator);
            mViewHolder.name = (TextView)view.findViewById(R.id.user_name);
            mViewHolder.content = (TextView)view.findViewById(R.id.content);
            mViewHolder.images = (NoScrollGridView)view.findViewById(R.id.images);
            view.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) view.getTag();
        }
        mViewHolder.name.setText(mMoment.getName());
        ImageLoader.getInstance().displayImage(mMoment.avatorUrl(), mViewHolder.avator);
        mViewHolder.content.setText(mMoment.getContent());

        if (mMoment.getImageUrl() != null&& mMoment.getImageUrl().length > 0){
            mViewHolder.images.setVisibility(View.VISIBLE);
            List<String> urls = new ArrayList<String>();
            for (String s:mMoment.getImageUrl()){
                urls.add(s);
            }
            mViewHolder.images.setAdapter(new MyGridAdapter(mContext,R.layout.gridview_item,urls));
            mViewHolder.images.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    imageBrower(position,mMoment.getImageUrl());
                }
            });
        }else{
            mViewHolder.images.setVisibility(View.GONE);
        }
        return view;
    }

    private void imageBrower(int position, String[] urls) {
        Intent intent = new Intent(mContext, ImagePagerActivity.class);
        // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        mContext.startActivity(intent);
    }

    class ViewHolder{
        TextView name;
        ImageView avator;
        TextView content;
        NoScrollGridView images;
    }
}
