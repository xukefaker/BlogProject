package com.example.mainpage.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class LooperPageAdapter extends PagerAdapter {
    //    private List<Integer> mColors=null;
    private List<Integer> mPic = null;

    @Override
    public int getCount() {
        if (mPic != null) {
           // return mPic.size();
            return Integer.MAX_VALUE;
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition = position % mPic.size();
        ImageView imageView = new ImageView(container.getContext());
        //使图片撑满整个容器
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //imageView.setBackgroundColor(mColors.get(position));
        imageView.setImageResource(mPic.get(realPosition));
        //设置颜色以后，就添加到容器中
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    public void setData(List<Integer> pic) {
        this.mPic = pic;

    }
    public int getDataRealSize(){
        return mPic.size();
    }
    /*  */
}
