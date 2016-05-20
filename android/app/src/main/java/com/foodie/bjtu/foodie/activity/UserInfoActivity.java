package com.foodie.bjtu.foodie.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.foodie.bjtu.foodie.R;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by zhao on 2016/5/19.
 */
public class UserInfoActivity extends AppCompatActivity {
    EditText userName ;
    EditText password ;
    EditText passwordAgain ;
    EditText email;
    EditText phoneNum;
    ImageButton avatar;
    Button button;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        userName = (EditText)findViewById(R.id.user_name);
        password = (EditText)findViewById(R.id.password);
        passwordAgain = (EditText)findViewById(R.id.password_again);
        email = (EditText)findViewById(R.id.email);
        phoneNum = (EditText)findViewById(R.id.phone_number);
        avatar = (ImageButton)findViewById(R.id.avatar);
        button = (Button)findViewById(R.id.change_button);

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo",MODE_PRIVATE);
        userName.setText(sharedPreferences.getString("userName",""));
        email.setText(sharedPreferences.getString("email",""));
        phoneNum.setText(sharedPreferences.getString("phoneNum",""));
        ImageLoader.getInstance().displayImage(sharedPreferences.getString("userAvatar",""),avatar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor mEditor = getSharedPreferences("userInfo",MODE_PRIVATE).edit();
                mEditor.putString("phoneNum",phoneNum.getText().toString());
                mEditor.putString("email",email.getText().toString());
                mEditor.putString("userName",userName.getText().toString());
                mEditor.commit();
            }
        });
    }
}
