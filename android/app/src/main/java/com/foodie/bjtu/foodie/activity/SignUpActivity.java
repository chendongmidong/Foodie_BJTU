package com.foodie.bjtu.foodie.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.foodie.bjtu.foodie.R;

/**
 * Created by zhao on 2016/5/15.
 */
public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        Button signUpButton = (Button)findViewById(R.id.register_button);
        final EditText phoneNum = (EditText)findViewById(R.id.phone_number);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor mEditor = getSharedPreferences("userInfo",MODE_PRIVATE).edit();
                mEditor.putString("phoneNum",phoneNum.getText().toString());
                mEditor.putString("userId","1");
                mEditor.commit();
            }
        });
    }

}
