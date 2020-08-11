package com.example.mainpage.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.mainpage.R;
import com.example.mainpage.adapter.LooperPageAdapter;

import java.util.ArrayList;
import java.util.List;

import view.MyViewPager;

public class SpecialAreaFragment extends BaseFragment implements MyViewPager.OnViewPagerTouchListener, ViewPager.OnPageChangeListener {
    private MyViewPager mLoopPager;
    private LooperPageAdapter mLooperPageAdapter;
    private static List<Integer> sPic = new ArrayList<>();
    private Handler mHandler;
    private LinearLayout mPointContainer;
    static {
        sPic.add(R.drawable.f);
        sPic.add(R.drawable.g);
    }
    @Override
    protected int initLayout() {
        return R.layout.fragment_special_area;
    }

    @Override
    protected void initView(View v) {
        //找到viewPager控件
        mLoopPager = (MyViewPager) v.findViewById(R.id.looper_pager);
        //设置适配器
        mLooperPageAdapter = new LooperPageAdapter();
        mLooperPageAdapter.setData(sPic);
        mLoopPager.setAdapter(mLooperPageAdapter);
        mLoopPager.addOnPageChangeListener(this);
        mLoopPager.setOnViewPagerTouchListener(this);
        //根据图片数，添加点的数量
        mPointContainer = (LinearLayout) v.findViewById(R.id.points_container);
        insertPots(v);

    }

    @Override
    protected void initData() {
            }
    private void insertPots(View v) {
        for (int i = 0; i < sPic.size(); i++) {
            View point = new View(v.getContext());
            LinearLayout.LayoutParams layoutParams;
            if (i != 0) {
                point.setBackground(getResources().getDrawable(R.drawable.ic_main_point_white));
                layoutParams = new LinearLayout.LayoutParams(15, 15);
            } else {
                point.setBackground(getResources().getDrawable(R.drawable.ic_home_heart));
                layoutParams = new LinearLayout.LayoutParams(30, 30);
            }
            layoutParams.leftMargin = 20;
            point.setLayoutParams(layoutParams);
            mPointContainer.addView(point);
        }
    }
        private void setSelectedPoint(int realPosition) {
        for (int i = 0; i < mPointContainer.getChildCount(); i++) {
            View point = mPointContainer.getChildAt(i);
            if (i != realPosition) {
                //那就白色
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
                layoutParams.leftMargin = 20;
                point.setLayoutParams(layoutParams);
                point.setBackgroundResource(R.drawable.ic_main_point_white);

            } else {
                //选中的颜色
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
                layoutParams.leftMargin = 20;
                point.setLayoutParams(layoutParams);
                point.setBackgroundResource(R.drawable.ic_home_heart);
            }
        }
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int realPosition;
        if (mLooperPageAdapter.getDataRealSize() != 0) {
            realPosition = position % mLooperPageAdapter.getDataRealSize();

        } else {
            realPosition = 0;
        }
        setSelectedPoint(realPosition);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPagerTouch(boolean isTouch) {

    }
}