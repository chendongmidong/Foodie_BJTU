package com.foodie.bjtu.foodie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.entity.Moment;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by zhao on 2016/5/19.
 */
public class InviteActivity extends AppCompatActivity {
    private String address;
    EditText userName;
    EditText password;
    EditText passwordAgain;
    EditText email;
    Button button;
    String temp = "";

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what){
                case -1:
                    Toast.makeText(InviteActivity.this,"Invite fail",Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(InviteActivity.this,"Invite Successful",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invite_activity);
        Intent intent = getIntent();
        String[] names = intent.getStringArrayExtra("friends");
        int[] ids = intent.getIntArrayExtra("friendsId");
        for (int i = 0; i < ids.length; i++) {
            if (i != ids.length - 1) {
                temp += ids[i] + ",";
            } else {
                temp += ids[i];
            }
        }
        userName = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        passwordAgain = (EditText) findViewById(R.id.password_again);
        email = (EditText) findViewById(R.id.email);
        button = (Button) findViewById(R.id.register_button);

//        address = "http://123.56.143.59:8585/Foodie/activity/newActivity?name=" + userName.getText().toString() + "&time=2016-01-04-08" + "&location=" + passwordAgain.getText().toString() + "&userid=" + temp;
        String name = "";
        for (String s : names) {
            name += s;
        }
        TextView textView = (TextView) findViewById(R.id.friends_name);
        textView.setText(name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "http://123.56.143.59:8585/Foodie/activity/newActivity?name=" + userName.getText().toString() + "&time=2016-01-04-08" + "&location=" + passwordAgain.getText().toString() + "&userid=" + temp;
                HttpUtil.sendHttpRequest(address, new HttpCallBackListenr() {
                    @Override
                    public void onFinish(String response) {
                        handleMomentResponse(InviteActivity.this, response);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        });
    }

    public void handleMomentResponse(Context context, String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObjectSon = new JSONObject(response);
                final int code = jsonObjectSon.getInt("code");
                Message message = new Message();
                if (code == -1) {
                    message.what = -1;
                } else {
                    message.what = 1;
                    finish();
                }
                handler.sendMessage(message);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
