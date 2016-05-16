package com.foodie.bjtu.foodie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.activity.LineUpActivity;
import com.foodie.bjtu.foodie.adapter.RestaurantAdapter;
import com.foodie.bjtu.foodie.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao on 2016/5/15.
 */
public class NFCFragment extends Fragment {

    public static NFCFragment newInstance(){
        NFCFragment rf = new NFCFragment();
        Bundle b = new Bundle();
        rf.setArguments(b);
        return rf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nfc_fragment,container,false);
        Button button = (Button)view.findViewById(R.id.line_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LineUpActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
