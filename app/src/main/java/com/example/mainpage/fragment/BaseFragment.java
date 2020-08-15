package com.example.mainpage.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainpage.R;

import static android.content.Context.MODE_PRIVATE;

public abstract  class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(initLayout(), null);
         initView(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }
    public void  navigateTo(Class cl){
        Intent intent=new Intent(getActivity(),cl);
        startActivity(intent);
    };

    protected void saveStringToSharePreference(String key,String val){

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("sp_ttit",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,val);
        editor.commit();
    }
    //布局的初始化
    protected abstract int initLayout();
    //控件的初始化给和控件赋值
    protected  abstract void initView(View v);
    //添加事件
    protected abstract void initData();


}
