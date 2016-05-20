package com.foodie.bjtu.foodie.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.test.suitebuilder.TestMethod;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.MyGridAdapter;
import com.foodie.bjtu.foodie.util.HttpCallBackListenr;
import com.foodie.bjtu.foodie.util.HttpUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhao on 2016/5/15.
 */
public class SignUpActivity extends AppCompatActivity {
    private static final int TAKE_PHOTO = 1;
    private static final int CHOOSE_PHOTO = 2;

    String address = "http://123.56.143.59:8585/Foodie/user/register";
    String imageAddress = "http://123.56.143.59:8585/Foodie/user/updateAvatar";
    EditText userName ;
    EditText password ;
    EditText passwordAgain ;
    EditText email;
    EditText phoneNum;
    ImageButton avatar;
    private int nameIndex;
    private String imageName;
    private Uri imageUri;
    String imagePath;
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
        avatar = (ImageButton)findViewById(R.id.avatar);

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
                address = "";
            }
        });

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(SignUpActivity.this).setItems(
                        new String[]{"Take Photo", "Choose Form Album"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        SharedPreferences.Editor editor = getSharedPreferences("name_data", MODE_PRIVATE).edit();
                                        SharedPreferences preferences = getSharedPreferences("name_data", MODE_PRIVATE);
                                        if (preferences.getInt("nameIndex", 0) == 0) {
                                            editor.putInt("nameIndex", 1);
                                            editor.commit();
                                        }
                                        nameIndex = preferences.getInt("nameIndex", 0);
                                        imageName = "IMG" + nameIndex + ".jpg";
                                        editor.putInt("nameIndex", ++nameIndex);
                                        editor.commit();
                                        File outputImage = new File(Environment.getExternalStorageDirectory(), "Foodie/images/" + imageName);
                                        try {
                                            if (outputImage.exists()) {
                                                outputImage.delete();
                                            }
                                            outputImage.createNewFile();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                        imageUri = Uri.fromFile(outputImage);
                                        Intent photoIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                                        photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                                        startActivityForResult(photoIntent, TAKE_PHOTO);
                                        break;
                                    case 1:
                                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                                        intent.setType("image/*");
                                        startActivityForResult(intent, CHOOSE_PHOTO);
                                }
                            }
                        }).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK){
                    imagePath = imageUri.toString();
                    ImageLoader.getInstance().displayImage(imagePath,avatar);
                    SharedPreferences.Editor editor = getSharedPreferences("userInfo",MODE_PRIVATE).edit();
                    editor.putString("userAvatar",imagePath);
                    editor.commit();
                }
                break;

            case CHOOSE_PHOTO:
                if(resultCode == RESULT_OK){
                    handleImageBeforekitKat(data);
//                    if(Build.VERSION.SDK_INT >= 19)
//                        //handleImageOnkitKat(data);
//                    handleImageBeforekitKat(data);
//                    else
//                        handleImageBeforekitKat(data);
                }
                break;
            default:

                break;
        }
    }

    private void handleImageBeforekitKat(Intent data){
        Uri uri = data.getData();
        imagePath = "file://"+getImagePath(uri,null);
//        String image = uri.toString();
        ImageLoader.getInstance().displayImage(imagePath,avatar);
        SharedPreferences.Editor editor = getSharedPreferences("userInfo",MODE_PRIVATE).edit();
        editor.putString("userAvatar",imagePath);
        editor.commit();
    }

    private String getImagePath(Uri uri,String selection){
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
            }
            cursor.close();
        }
        return path;
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
                    mEditor.putString("email",email.getText().toString());
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
