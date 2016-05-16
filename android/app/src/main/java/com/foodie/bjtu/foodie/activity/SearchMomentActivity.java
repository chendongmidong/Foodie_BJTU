package com.foodie.bjtu.foodie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foodie.bjtu.foodie.R;

/**
 * Created by zhao on 2016/5/15.
 */
public class SearchMomentActivity extends AppCompatActivity {
    private Button backButton;
    private EditText keyWord;
    private Button searchButton;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.moment_search);
        backButton = (Button)findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        keyWord = (EditText)findViewById(R.id.key_word);
        keyWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                content = keyWord.getText().toString();
                Log.d("content",content);
                if (actionId == EditorInfo.IME_ACTION_SEND ||
                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:
                            if (content != null && !content.equals("")) {
                                Intent intent = new Intent(SearchMomentActivity.this, MomentListActivity.class);
                                intent.putExtra("flag", 3);
                                intent.putExtra("keyWord", content);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SearchMomentActivity.this, "type the keyword you want to search", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                        default:
                            return true;
                    }
                }
                return false;
            }
        });
        searchButton = (Button)findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = keyWord.getText().toString();
                Log.d("content",content);
                if (content != null&& !content.equals("")){
                    Intent intent = new Intent(SearchMomentActivity.this,MomentListActivity.class);
                    intent.putExtra("flag",3);
                    intent.putExtra("keyWord",content);
                    startActivity(intent);
                }else{
                    Toast.makeText(SearchMomentActivity.this,"type the keyword you want to search",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
