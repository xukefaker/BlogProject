package com.example.mainpage.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mainpage.R;
import com.example.mainpage.adapter.LooperPageAdapter;
import com.example.mainpage.adapter.MyHorRecyclerListViewAdapter;
import com.example.mainpage.adapter.MyVirRecyclerListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import view.MyViewPager;


public class RecommendationFragment extends BaseFragment implements MyViewPager.OnViewPagerTouchListener, ViewPager.OnPageChangeListener {

    private MyViewPager mLoopPager;
    private LooperPageAdapter mLooperPageAdapter;
    private static List<Integer> sPic = new ArrayList<>();
    private Handler mHandler;
    private boolean mIsTouch = true;
    private LinearLayout mPointContainer;
    final static int delayMillions = 4000;
    private Runnable mLooperTask;
    private RecyclerView mRv;
   // private RecyclerView mRv2;
    private LinearLayout mHorRecycler;
    static {
        sPic.add(R.drawable.f);
        sPic.add(R.drawable.g);
        sPic.add(R.drawable.h);
        sPic.add(R.drawable.d);
        sPic.add(R.drawable.e);
    }
    @Override
    protected int initLayout() {
        return R.layout.fragment_recomment;
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
        //设置初始为1000，并显示动画
        mLoopPager.setCurrentItem(mLooperPageAdapter.getDataRealSize() * 100-1 , true);
        mHandler = new Handler();
        mLooperTask = new Runnable() {
            @Override
            public void run() {

                if (mIsTouch) {
                    //切换图片
                    int currentItem = mLoopPager.getCurrentItem();
                    mLoopPager.setCurrentItem(++currentItem, true);
                }
                mHandler.postDelayed(this, delayMillions);
            }
        };


        mRv=(RecyclerView)v.findViewById(R.id.rv);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//设置成水平的
        mRv.setLayoutManager(linearLayoutManager);
        mRv.setAdapter(new MyHorRecyclerListViewAdapter(v.getContext()));

    }

    @Override
    protected void initData() {
        mHandler.post(mLooperTask);
    }

    private void insertPots(View v) {
        for (int i = 0; i < sPic.size(); i++) {
            View point = new View(v.getContext());
            point.setBackground(getResources().getDrawable(R.drawable.ic_main_point_white));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 30;
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
                layoutParams.leftMargin = 30;
                point.setLayoutParams(layoutParams);
                point.setBackgroundResource(R.drawable.ic_main_point_white);

            } else {
                //选中的颜色
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
                layoutParams.leftMargin = 30;
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
    //这个方法的调用，其实是viewPager停下来以后选中的位置
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
        mIsTouch = isTouch;
    }
}