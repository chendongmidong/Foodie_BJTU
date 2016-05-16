package com.foodie.bjtu.foodie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foodie.bjtu.foodie.Constant;
import com.foodie.bjtu.foodie.R;
import com.foodie.bjtu.foodie.activity.MomentListActivity;
import com.foodie.bjtu.foodie.activity.SearchMomentActivity;

/**
 * Created by zhao on 2016/5/15.
 */
public class MomentFragment extends Fragment {

    public static MomentFragment newInstance(){
        MomentFragment rf = new MomentFragment();
        Bundle b = new Bundle();
        rf.setArguments(b);
        return rf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moment_fragment, container, false);
        TextView friendsMoments = (TextView) view.findViewById(R.id.friends_moments);
        TextView addMoment = (TextView) view.findViewById(R.id.add_moment);
        TextView myMoments = (TextView) view.findViewById(R.id.my_moments);
        TextView searchMoments = (TextView) view.findViewById(R.id.search_moments);

        friendsMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MomentListActivity.class);
                intent.putExtra("flag", Constant.FRIENDS_MOMENTS);
                startActivity(intent);
            }
        });

        addMoment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent photoIntent = new Intent(getContext(), AddMomentAcitvity.class);
//                startActivity(photoIntent);
            }
        });

        myMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MomentListActivity.class);
                intent.putExtra("flag",Constant.MY_MOMENTS);
                startActivity(intent);
            }
        });

        searchMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchMomentActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


}

