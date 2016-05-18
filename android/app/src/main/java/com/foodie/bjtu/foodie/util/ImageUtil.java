package com.foodie.bjtu.foodie.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import sun.misc.BASE64Encoder;


/**
 * Created by zhao on 2016/5/17.
 */
public class ImageUtil {

    public static String EncodeImage(final List<String> iamgesPath){

        List<String> images = new ArrayList<String>();
        for (String s:iamgesPath){
            String temp = s.substring(7);
//            Bitmap bitmap = decodeSampledBitmapFromFile(temp,256,144);
            Bitmap bitmap = BitmapFactory.decodeFile(temp);
            String encodeString = encodeToBase64(bitmap);

            InputStream in = null;
            byte[] data = null;
            //读取图片字节数组
            try
            {
                in = new FileInputStream(temp);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
//            images.add(encoder.encode(data).trim());
            images.add(encodeString);
        }
       return images.get(0);
    }

    public static Bitmap decodeSampledBitmapFromFile(String imagePath,int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath,options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(imagePath,options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
    public static String encodeToBase64(Bitmap image)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 40, baos);
        try {
            baos.flush();
            baos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

    public static String bitMapToString(Bitmap bitmap){
        int bytes = bitmap.getByteCount();
//or we can calculate bytes this way. Use a different value than 4 if you don't use 32bit images.
//int bytes = b.getWidth()*b.getHeight()*4;

        ByteBuffer buffer = ByteBuffer.allocate(bytes); //Create a new buffer
        bitmap.copyPixelsToBuffer(buffer); //Move the byte data to the buffer

        byte[] array = buffer.array();

//        ByteArrayOutputStream ByteStream=new  ByteArrayOutputStream();
////        bitmap.compress(Bitmap.CompressFormat.WEBP,100, ByteStream);
//        byte [] b=ByteStream.toByteArray();
//        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return array.toString();
    }
}
