package com.example.mainpage;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.mainpage.adapter.MyPagerAdapter;
import com.example.mainpage.entity.TabEntity;
import com.example.mainpage.fragment.HeartFragment;
import com.example.mainpage.fragment.HomeFragment;
import com.example.mainpage.fragment.MessageFragment;
import com.example.mainpage.fragment.MyFragment;
import com.example.mainpage.fragment.SignFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private Context context = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"首页", "消息","签到", "公益秀", "我的"};

    private int[] mIconUnSelectIds = {
            R.drawable.ic_main_home_unselect, R.drawable.ic_main_message_unselect,R.drawable.ic_main_sign_unselect,
            R.drawable.ic_main_xun_unselect, R.drawable.ic_main_my_unselect
    };

    private int[] mIconSelectIds = {
            R.drawable.ic_main_home_select, R.drawable.ic_main_message_select,R.drawable.ic_main_sign_select,
            R.drawable.ic_main_xun_select, R.drawable.ic_main_my_select
    };
    private ViewPager mViewPager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private CommonTabLayout mTabLayout;
private HomeFragment homeFragment;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.commonTabLayout);
    }
    //关闭该Activity并跳转至LoginActivity
    public void getFinish(){
        navigateTo(EnterActivity.class);
        this.finish();
    }
    @Override
    protected void initData() {

        mFragments.add( new HomeFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new SignFragment());
        mFragments.add(new HeartFragment());
        mFragments.add(new MyFragment());
        for (int i = 0; i < mTitles.length; i++) {
            //里面数据是图片信息（标题，被选中时显示的图片，未被选中时显示的图片）
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);
        //当底部导航栏进行点击时
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        //当页面滑动时

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

}