package com.example.mainpage.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    private ArrayList<Fragment> mFragments;
    public MyPagerAdapter(@NonNull FragmentManager fm, String[] mTitles,ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments=mFragments;
        this.mTitles=mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
