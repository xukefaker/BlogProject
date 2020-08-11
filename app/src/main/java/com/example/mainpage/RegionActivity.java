package com.example.mainpage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mainpage.adapter.MyPagerAdapter;

import com.example.mainpage.fragment.regionFragment.BeiJinFragment;
import com.example.mainpage.fragment.regionFragment.ChongQingFragment;
import com.example.mainpage.fragment.regionFragment.HeBeiFragment;
import com.example.mainpage.fragment.regionFragment.JiLinFragment;
import com.example.mainpage.fragment.regionFragment.LiaoLinFragment;
import com.example.mainpage.fragment.regionFragment.MengGuFragment;
import com.example.mainpage.fragment.regionFragment.ShanXiFragment;
import com.example.mainpage.fragment.regionFragment.ShangHaiFragment;
import com.example.mainpage.fragment.regionFragment.TianJinFragment;

import java.util.ArrayList;


import view.NoScrollViewPager;

public class RegionActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout mLinBack;
    private NoScrollViewPager mFixedViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String [] mTitles;
    private TextView[] textViews=new TextView[9];
private LinearLayout mLinSearch;

    @Override
    protected int initLayout() {
        return R.layout.activity_region;
    }

    @Override
    protected void initView() {
 mLinBack=(LinearLayout)findViewById(R.id.ll_back);
 mLinBack.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         getFinish("");
     }
 });
 mLinSearch=(LinearLayout)findViewById(R.id.ll_search);
 mLinSearch.setOnClickListener(this);
 mFixedViewPager=(NoScrollViewPager)findViewById((R.id.viewPager));


        mFragments.add(new BeiJinFragment());
        mFragments.add(new ShangHaiFragment());
        mFragments.add(new TianJinFragment());
        mFragments.add(new ChongQingFragment());
        mFragments.add(new HeBeiFragment());
        mFragments.add(new ShanXiFragment());
        mFragments.add(new MengGuFragment());
        mFragments.add(new LiaoLinFragment());
        mFragments.add(new JiLinFragment());
        mFixedViewPager.setOffscreenPageLimit(mFragments.size());
        mFixedViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));


        textViews[0]=(TextView) findViewById(R.id.btn_1);
        textViews[0].setOnClickListener(this);
        textViews[1]=(TextView)findViewById(R.id.btn_2);
        textViews[1].setOnClickListener(this);
        textViews[2]=(TextView) findViewById(R.id.btn_3);
        textViews[2].setOnClickListener(this);
        textViews[3]=(TextView)findViewById(R.id.btn_4);
        textViews[3].setOnClickListener(this);
        textViews[4]=(TextView) findViewById(R.id.btn_5);
        textViews[4].setOnClickListener(this);
        textViews[5]=(TextView) findViewById(R.id.btn_6);
        textViews[5].setOnClickListener(this);
        textViews[6]=(TextView)findViewById(R.id.btn_7);
        textViews[6].setOnClickListener(this);
        textViews[7]=(TextView) findViewById(R.id.btn_8);
        textViews[7].setOnClickListener(this);
        textViews[8]=(TextView)findViewById(R.id.btn_9);
        textViews[8].setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setBackground(0);
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return super.startForegroundService(service);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                setBackground(0);
                mFixedViewPager.setCurrentItem(0);
                break;
            case R.id.btn_2:
                setBackground(1);
                mFixedViewPager.setCurrentItem(1);
                break;
            case R.id.btn_3:
                setBackground(2);
                mFixedViewPager.setCurrentItem(2);
                break;
            case R.id.btn_4:
                setBackground(3);
                mFixedViewPager.setCurrentItem(3);
                break;
            case R.id.btn_5:
                setBackground(4);
                mFixedViewPager.setCurrentItem(4);
                break;
            case R.id.btn_6:
                setBackground(5);
                mFixedViewPager.setCurrentItem(5);
                break;
            case R.id.btn_7:
                setBackground(6);
                mFixedViewPager.setCurrentItem(6);
                break;
            case R.id.btn_8:
                setBackground(7);
                mFixedViewPager.setCurrentItem(7);
                break;
            case R.id.btn_9:
                setBackground(8);
                mFixedViewPager.setCurrentItem(8);
                break;
            case R.id.ll_search:
                Intent intent=new Intent(RegionActivity.this,SearchRegionActivity.class);
                startActivity(intent);
                break;
        }




    }
    //设置背景的方法
    public void setBackground(int position){
        for (int i = 0; i < textViews.length; i++) {
            if(i==position){
                textViews[i].setBackgroundResource(R.color.colorWhite);
            }else {
                textViews[i].setBackgroundResource(R.color.colorGrey);
            }
        }
    }
    //关闭该Activity并跳转至MainActivity传入选择的城市名
    public void getFinish(String city){

        Intent intent=new Intent();
        Bundle bundle1=new Bundle();
        bundle1.putString("region",city);
        intent.putExtras(bundle1);
        setResult(Activity.RESULT_OK,intent);

        this.finish();
    }

}
