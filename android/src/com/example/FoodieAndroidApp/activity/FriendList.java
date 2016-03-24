package com.example.FoodieAndroidApp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.FoodieAndroidApp.R;
import com.example.FoodieAndroidApp.model.Friend;
import com.example.FoodieAndroidApp.widge.FriendAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhao on 2016/3/10.
 */
public class FriendList extends Activity {
    
    private List<Friend> friends = new ArrayList<>();
    private ListView friendsList;
    private FriendAdapter friendAdapter;
    private HashSet selectedSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list);

        initFriends();
        selectedSet = new HashSet();
        friendsList = (ListView) findViewById(R.id.friends_list);
        friendsList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        friendAdapter = new FriendAdapter(this,R.layout.friend_item,friends,friendsList);
        friendsList.setAdapter(friendAdapter);
        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                friendAdapter.notifyDataSetChanged();
                if(friendsList.isItemChecked(position)){
                    selectedSet.add(position);
                }else {
                    selectedSet.remove(position);
                }
            }
        });
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

    private void initFriends() {
        Friend apple = new Friend("Apple", R.drawable.apple);
        friends.add(apple);
        Friend banana = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana2 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana3 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana4 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana5 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana6 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana7 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana8 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana9 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana0 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana11 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana12 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana13 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana14 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana21 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana22 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana23 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana24 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana41 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana42 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);
        Friend banana32 = new Friend("Banana", R.drawable.banana);
        friends.add(banana);


    }
}
