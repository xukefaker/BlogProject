package com.example.mainpage.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainpage.MainActivity;
import com.example.mainpage.R;
import com.example.mainpage.SetActivity;
import com.example.mainpage.util.ToastUtil;

import static android.content.Context.MODE_PRIVATE;


public class MyFragment extends BaseFragment {
    private TextView textView;
    private SharedPreferences mSharedPreferences;
    private String s;
    private LinearLayout ll_set;

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View v) {
        textView = v.findViewById(R.id.tv_user);
        mSharedPreferences = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        s = mSharedPreferences.getString("name", "root").toString();
        textView.setText(s);
         ll_set=v.findViewById(R.id.ll_set);
         ll_set.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(getActivity(),SetActivity.class);

            startActivityForResult(intent,0);
             }
         });

    }

    @Override
    protected void initData() {

    }
    public  void enterEntryActivity(){

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {

            String s = data.getExtras().getString("close");
            if (!("".equals(s)) && s != null) {
                ( (MainActivity)getActivity() ).getFinish();
            }
        }

    }

}