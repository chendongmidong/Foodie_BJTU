package com.foodie.bjtu.foodie.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/17.
 */
public class ImageUtil {

    public static void EncodeImage(final List<String> iamgesPath, final EncodeCallBackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> images = new ArrayList<String>();
                for (String s:iamgesPath){
                    Bitmap bitmap = BitmapFactory.decodeFile(s);
                    Log.d("ImageUtil:", "bitmap width: " + bitmap.getWidth() + " height: " + bitmap.getHeight());
                    //convert to byte array
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    byte[] bytes = baos.toByteArray();

                    //base64 encode
                    byte[] encode = Base64.encode(bytes,Base64.DEFAULT);
                    String encodeString = new String(encode);

                    images.add(encodeString);
                }
                if (images != null&&images.size()>0){
                    listener.onFinish(images);
                }else {
                    listener.onError();
                }
            }
        }).start();
    }
}
