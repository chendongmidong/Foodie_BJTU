package com.foodie.bjtu.foodie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.test.suitebuilder.TestMethod;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhao on 2016/5/15.
 */
public class SignUpActivity extends AppCompatActivity {
    String address = "http://123.56.143.59:8585/Foodie/user/register";
    EditText userName ;
    EditText password ;
    EditText passwordAgain ;
    EditText email;
    EditText phoneNum;
    String postContent;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what){
                case -1:
                    Toast.makeText(SignUpActivity.this,"Sign Up fail",Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    Toast.makeText(SignUpActivity.this,"Sign Up Successful",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        Button signUpButton = (Button)findViewById(R.id.register_button);
        userName = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);
        passwordAgain = (EditText)findViewById(R.id.password_again);
        email = (EditText)findViewById(R.id.email);
        phoneNum = (EditText)findViewById(R.id.phone_number);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("userName", userName.getText().toString());
//                    jsonObject.put("password", password.getText().toString());
//                    jsonObject.put("phone", phoneNum.getText().toString());
//                }catch (JSONException e ){
//                    e.printStackTrace();
//                }
//                postContent = jsonObject.toString();
                address+="?username="+userName.getText().toString()+"&password="+password.getText().toString()+"&phone="+phoneNum.getText().toString();
                HttpUtil.sendHttpRequest(address,new HttpCallBackListenr() {

                    @Override
                    public void onFinish(String response) {
                        handleMomentResponse(SignUpActivity.this, response);
                    }
                    @Override
                    public void onError(Exception e) {
                    }
                });
            }
        });
    }

    public void handleMomentResponse(Context context, String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONObject jsonObjectSon= new JSONObject(response);
                final int code = jsonObjectSon.getInt("code");
                Message message = new Message();
                if (code == -1){
                    message.what = -1;
                }else {
                    message.what = 1;

                    SharedPreferences.Editor mEditor = getSharedPreferences("userInfo",MODE_PRIVATE).edit();
                    mEditor.putString("phoneNum",phoneNum.getText().toString());
                    mEditor.putInt("userId",code);
                    mEditor.putString("userName",userName.getText().toString());
                    mEditor.putString("password",password.getText().toString());
                    mEditor.commit();

                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                handler.sendMessage(message);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
