package com.foodie.bjtu.foodie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;

import org.json.JSONObject;

/**
 * Created by zhao on 2016/5/17.
 */
public class LoginActivity extends AppCompatActivity {

    String address;
    EditText userName ;
    EditText password ;
    int code;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what){
                case -1:
                    Toast.makeText(LoginActivity.this,"Log In fail",Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(LoginActivity.this,"Log In Successful",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        userName = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo",MODE_PRIVATE);
        userName.setText(sharedPreferences.getString("userName",""));
        password.setText(sharedPreferences.getString("password",""));

        Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address ="http://123.56.143.59:8585/Foodie/user/login"+"?username="+userName.getText().toString()+"&password="+password.getText().toString();
                HttpUtil.sendHttpRequest(address,new HttpCallBackListenr() {
                    @Override
                    public void onFinish(String response) {
                        handleMomentResponse(LoginActivity.this, response);
                    }
                    @Override
                    public void onError(Exception e) {
                    }
                });
            }
        });
        Button registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void handleMomentResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONObject jsonObjectSon= new JSONObject(response);
                code = jsonObjectSon.getInt("code");
                Message message = new Message();
                if (code == 0){
                    message.what = -1;
                }else {
                    message.what = 1;
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                handler.sendMessage(message);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
