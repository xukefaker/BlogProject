package com.example.mainpage.fragment;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.View;


import com.example.mainpage.R;
import com.example.mainpage.adapter.HeartAdapter;


import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;


public class HeartFragment extends BaseFragment{
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"全国", "同城"};
    private ViewPager mViewPager;
  private SlidingTabLayout mSlidingTabLayout;
    @Override
    protected int initLayout() {
        return R.layout.fragment_heart;
    }
    //控件的初始化给和控件赋值
    @Override
    protected void initView(View v) {
    mFragments.add(new NationWideFragment());
    mFragments.add(new LocationFragment());
    mViewPager=(ViewPager)v.findViewById(R.id.viewPager);
    mSlidingTabLayout=(SlidingTabLayout)v.findViewById(R.id.slidingTabLayout);
    mViewPager.setOffscreenPageLimit(mFragments.size());

    mViewPager.setAdapter(new HeartAdapter(getChildFragmentManager(), mTitles, mFragments));

    mSlidingTabLayout.setViewPager(mViewPager);
    }
    //添加事件
    @Override
    protected void initData() {

    }
}