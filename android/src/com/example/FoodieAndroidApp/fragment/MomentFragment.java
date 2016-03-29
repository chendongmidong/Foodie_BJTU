package com.example.FoodieAndroidApp.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.FoodieAndroidApp.R;
import com.example.FoodieAndroidApp.model.FoodieHttpClient;
import com.example.FoodieAndroidApp.model.Moment;
import com.example.FoodieAndroidApp.model.Restaurant;
import com.example.FoodieAndroidApp.widge.MomentAdapter;
import com.example.FoodieAndroidApp.widge.RestaurantAdapter;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.LogRecord;

/**
 * Created by zhao on 2016/3/29.
 */
public class MomentFragment extends Fragment {

    public static final int SHOW_MESSAGE = 0;
    private ListView momentListView;
    private List<Moment> momentList;
    private MomentAdapter momentAdapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SHOW_MESSAGE:
                    String response = (String) msg.obj;
                    momentList.add(new Moment("Mike", "http://pic1a.nipic.com/2008-10-06/2008106145837425_2.jpg", response, null));
                    momentAdapter.notifyDataSetChanged();
            }
        }
    };
    public static MomentFragment getInstance(){
        MomentFragment mf = new MomentFragment();
        Bundle b = new Bundle();
        mf.setArguments(b);
        return mf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        momentList = new ArrayList<Moment>();
        String[] urls = {"http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg", "http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg", "http://e.hiphotos.baidu.com/zhidao/pic/item/55e736d12f2eb9389fca3264d7628535e4dd6f84.jpg"};
        momentList.add(new Moment("Mike", "http://pic1a.nipic.com/2008-10-06/2008106145837425_2.jpg", "where there is a will,there is a way", urls));

        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moments_fragment,container,false);
        momentListView = (ListView)view.findViewById(R.id.show_moments);
        momentAdapter = new MomentAdapter(getActivity(),momentList);
        momentListView.setAdapter(momentAdapter);
        return view;
    }

    public void refresh() {
        FoodieHttpClient.get("",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("onSuccess ", "onSuccess ");
                Message message = new Message();
                message.what = SHOW_MESSAGE;
                message.obj = response.toString();
                handler.sendMessage(message);
            }

            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline

                Log.d("jiujiujiu", "onSuccess ");
//                JSONObject firstEvent = timeline.get(0);
//                String tweetText = firstEvent.getString("text");

                // Do something with the response
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("onFailure", responseString);
            }
        });
    }
}
