package com.foodie.bjtu.foodie.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.adapter.MyGridAdapter;
import com.foodie.bjtu.foodie.widget.NoScrollGridView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/16.
 */
public class AddMomentActivity extends AppCompatActivity{
    private static final int TAKE_PHOTO = 1;
    private static final int CHOOSE_PHOTO = 2;

    private NoScrollGridView gridView;
    private Button backButton;
    private Button sendButton;
    private Button addButton;
    private EditText content;
    private int nameIndex;
    private String imageName;
    private Uri imageUri;
    private List<String> selectedImages;
    private int selectNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.add_moment);
        selectedImages = new ArrayList<String>();
        backButton = (Button)findViewById(R.id.back_button);
        sendButton = (Button)findViewById(R.id.send_button);
        addButton = (Button)findViewById(R.id.add_button);
        content = (EditText) findViewById(R.id.content);
        gridView = (NoScrollGridView)findViewById(R.id.selected_photo);
        File imageDir = new File(Environment.getExternalStorageDirectory(),"Foodie/images/");
        if (!imageDir.exists()){
            imageDir.mkdirs();
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectNum++;
                if (selectNum <= 9){
                    new AlertDialog.Builder(AddMomentActivity.this).setItems(
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
                                            File outputImage = new File(Environment.getExternalStorageDirectory(), "Nourriture/images/" + imageName);
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
                }else{
                    Toast.makeText(AddMomentActivity.this,"9 images at most", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK){
                    String temp = imageUri.toString();
                    selectedImages.add(temp);
                    displayImage();
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

    private void handleImageOnkitKat(Intent data){
//        String imagePath = null;
//        Uri uri = data.getData();
//        if(DocumentsContract.isDocumentUri(this,uri)){
//            String docId = DocumentsContract.getDocumentId(uri);
//            if(uri.getAuthority().equals("com.android.providers.media.documents")){
//                String id = docId.split(":")[1];
//                String selection = MediaStore.Images.Media._ID +"="+id;
//                imagePath = getImagePath(uri,selection);
//            } else if(uri.getAuthority().equals("com.android.providers.downloads.documents")){
//                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/puvlic_downloads"),Long.valueOf(docId));
//                imagePath = getImagePath(contentUri,null);
//            }
//        }else if("content".equalsIgnoreCase(uri.getScheme())){
//            imagePath = getImagePath(uri,null);
//        }
//        selectedImages.add(imagePath);
//        displayImage();
    }

    private void handleImageBeforekitKat(Intent data){
        Uri uri = data.getData();
        //   String image = getImagePath(uri,null);
        String image = uri.toString();
        //displayImage(image);
        selectedImages.add(image);
        displayImage();
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

    private void displayImage(){
        if (selectedImages != null&& selectedImages.size() > 0) {
            gridView.setVisibility(View.VISIBLE);
            gridView.setAdapter(new MyGridAdapter(AddMomentActivity.this, R.layout.gridview_item, selectedImages));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String[] temp = new String [selectedImages.size()];
                    for (int i = 0;i< selectedImages.size();i++){
                        temp[i] = selectedImages.get(i);
                    }
                    imageBrower(position,temp);
                }
            });

            gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    new AlertDialog.Builder(AddMomentActivity.this).setMessage("Delete is photo ?").setTitle("Hint").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            selectedImages.remove(position);
                            displayImage();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
                    return true;
                }
            });
        }else{
            gridView.setVisibility(View.GONE);
        }
//        viewHolder.images.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                imageBrower(position,moment.getImageUrl());
//            }
//        });
    }

    private void imageBrower(int position, String[] urls) {
        Intent intent = new Intent(AddMomentActivity.this, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
        intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
        startActivity(intent);
    }
}
