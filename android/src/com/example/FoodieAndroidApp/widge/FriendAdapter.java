package com.example.FoodieAndroidApp.widge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.FoodieAndroidApp.R;
import com.example.FoodieAndroidApp.model.Friend;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhao on 2016/3/10.
 */
public class FriendAdapter extends ArrayAdapter<Friend>{

    private int resourceId;

    private LayoutInflater inflater;
    private ListView mListView;
    private ViewHolder holder;

    public FriendAdapter(Context context, int itemViewResourceId, List<Friend> object, ListView listView){
        super(context,itemViewResourceId,object);
        resourceId = itemViewResourceId;
        inflater = LayoutInflater.from(getContext());
        mListView = listView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Friend friend = getItem(position);

        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(resourceId,null);
            holder.headPortrait = (ImageView) convertView.findViewById(R.id.friend_portrait);
            holder.name = (TextView)convertView.findViewById(R.id.friend_name);
            holder.checkBox = (CheckBox)convertView.findViewById(R.id.friend_cb);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.headPortrait.setImageResource(friend.getHeadPortrait());
        holder.name.setText(friend.getName());
        if (mListView.isItemChecked(position)){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }
        return convertView;
    }

    public class ViewHolder {
        ImageView headPortrait;
        TextView name;
        CheckBox checkBox;
    }
}
