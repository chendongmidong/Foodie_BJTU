package com.foodie.bjtu.foodie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.activity.ImagePagerActivity;
import com.foodie.bjtu.foodie.entity.Friend;
import com.foodie.bjtu.foodie.entity.Moment;
import com.foodie.bjtu.foodie.widget.NoScrollGridView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/16.
 */
public class FriendAdapter extends BaseAdapter{

    private List<Friend> mFriends;
    private Context mContext;
    private ListView mListView;

    public FriendAdapter(List<Friend> mFriends, Context mContext, ListView listView) {
        this.mFriends = mFriends;
        this.mContext = mContext;
        mListView = listView;
    }

    @Override
    public int getCount() {
        return mFriends.size();
    }

    @Override
    public Object getItem(int i) {
        return mFriends.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Friend friend = mFriends.get(i);
        ViewHolder mViewHolder = null;

        if (view == null){
            mViewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.friend_item,null);
            mViewHolder.headPortrait = (ImageView)view.findViewById(R.id.friend_portrait);
            mViewHolder.name = (TextView)view.findViewById(R.id.friend_name);
            mViewHolder.checkBox = (CheckBox) view.findViewById(R.id.friend_cb);
            view.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(friend.getHeadPortrait(), mViewHolder.headPortrait);
        mViewHolder.name.setText(friend.getName());
        if (mListView.isItemChecked(i)){
            mViewHolder.checkBox.setChecked(true);
        }else {
            mViewHolder.checkBox.setChecked(false);
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

    public class ViewHolder {
        ImageView headPortrait;
        TextView name;
        CheckBox checkBox;
    }
}
