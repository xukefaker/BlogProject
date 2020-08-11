package com.example.mainpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        setContentView(initLayout());
        initView();
        initData();

    }
    public void  navigateTo(Class cl){
        Intent intent=new Intent(mContext,cl);
        startActivity(intent);
    };
    public void showToastSync(String msg){
        Looper.prepare();
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
        Looper.loop();

    }
    protected void saveStringToSharePreference(String key,String val){

        SharedPreferences sharedPreferences=getSharedPreferences("sp_ttit",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,val);
        editor.commit();
    }
    //布局的初始化
    protected abstract int initLayout();
    //控件的初始化
    protected  abstract void initView();
    //给控件赋值和添加事件
    protected abstract void initData();
}
