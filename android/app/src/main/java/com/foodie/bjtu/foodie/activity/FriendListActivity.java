package com.foodie.bjtu.foodie.activity;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.FriendAdapter;
import com.foodie.bjtu.foodie.entity.Friend;
import com.foodie.bjtu.foodie.entity.Moment;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhao on 2016/5/16.
 */
public class FriendListActivity extends AppCompatActivity{

    private List<Friend> friends = new ArrayList<>();
    private ListView friendsList;
    private FriendAdapter friendAdapter;
    private HashSet selectedSet;
    private LinearLayout galleryView;
    private List<Integer> positionList;
    private ProgressBar progressBar;
    private final String address = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendlist_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        selectedSet = new HashSet();
        positionList = new ArrayList<Integer>();
        galleryView = (LinearLayout)findViewById(R.id.gallery);
        friendsList = (ListView) findViewById(R.id.friends_list);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        friendsList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        friendAdapter = new FriendAdapter(friends,this,friendsList);
        friendsList.setAdapter(friendAdapter);
        refresh();
        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                friendAdapter.notifyDataSetChanged();
                if(friendsList.isItemChecked(position)){
                    selectedSet.add(position);
                    positionList.add(position);
                    addAvator(position);
                }else {
                    selectedSet.remove(position);

                    //完成在上面的scrollView动态显示头像功能
                    for (int i= 0;i<positionList.size();i++){
                        if (positionList.get(i) == position){
                            galleryView.removeViewAt(i);
                            while (positionList.get(i)!= null&& i<positionList.size()-1){
                                positionList.set(i,positionList.get(i+1));
                                i++;
                            }
                            positionList.remove(positionList.size()-1);
                            break;
                        }
                    }
                }
            }
        });


    }

    private void refresh(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
            @Override
            public void onFinish(String response) {
                handleMomentResponse(FriendListActivity.this, response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        friendAdapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
            @Override
            public void onError(Exception e) {

            }
        });
    }

    public void handleMomentResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)){
            try {

                JSONArray moments = new JSONArray(response);
                for (int i=0;i<moments.length();i++)
                {
                    JSONObject jsonObjectSon= (JSONObject)moments.opt(i);
                    String name = jsonObjectSon.getString("name");
                    String avatar = jsonObjectSon.getString("avatorUrl");
                    Friend friend = new Friend(name,avatar);
                    friends.add(friend);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.friend_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.confirm_button:
                Toast.makeText(this,selectedSet.toString(),Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addAvator(int position){
        View view1 = LayoutInflater.from(FriendListActivity.this).inflate(R.layout.gallery_item,null);
        ImageView imageView = (ImageView)view1.findViewById(R.id.gallery_image);
        ImageLoader.getInstance().displayImage(friends.get(position).getHeadPortrait(),imageView);
        galleryView.addView(view1);
    }

}
