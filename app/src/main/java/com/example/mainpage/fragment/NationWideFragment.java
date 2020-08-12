package com.example.mainpage.fragment;

import android.view.View;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.adapter.NationWideAdapter;
import com.example.mainpage.entity.NationWideEntity;

import java.util.ArrayList;
import java.util.List;

public class NationWideFragment extends BaseFragment {
    private String mTitle;
    private RecyclerView mRecyclerView;
     private   ArrayList<NationWideEntity> mDates;
    @Override
    protected int initLayout() {
        return R.layout.fragment_nation_wide;
    }

    @Override
    protected void initView(View v) {
        mDates=new ArrayList<>();
        mRecyclerView=v.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
         //向mDate中添加数据
         addItems();

        NationWideAdapter nationWideAdapter=new NationWideAdapter(getActivity(),mDates);
        mRecyclerView.setAdapter(nationWideAdapter);




    }
public void  addItems(){


    NationWideEntity[] ves=new NationWideEntity[6];
for(int i=0;i<ves.length;i++){
    ves[i]=new NationWideEntity();
}
    ves[5].setTitle("每天给居民送瓜果蔬菜");
    ves[5].setAuthor("全远方");
    ves[5].setHead(R.drawable.ic_he_1);
    ves[5].setPic(R.drawable.ic_he_3);

    ves[4].setTitle("志愿值勤点");
    ves[4].setAuthor("吴才兵");
    ves[4].setHead(R.drawable.ic_he_1_1);
    ves[4].setPic(R.drawable.ic_he_3_1);


    ves[3].setTitle("电瓶违法行为劝导");
    ves[3].setAuthor("章鑫荣");
    ves[3].setHead(R.drawable.ic_he_1_2);
    ves[3].setPic(R.drawable.ic_he_3_2);

    ves[2].setTitle("内蒙古第一百例造血干细胞捐献成功");
    ves[2].setAuthor("王舒韵");
    ves[2].setHead(R.drawable.ic_he_1_3);
    ves[2].setPic(R.drawable.ic_he_3_3);


    ves[1].setTitle("创全活动需要居民参与");
    ves[1].setAuthor("张平");
    ves[1].setHead(R.drawable.ic_he_1_4);
    ves[1].setPic(R.drawable.ic_he_3_4);


    ves[0].setTitle("敬老助老活动");
    ves[0].setAuthor("阴建华");
    ves[0].setHead(R.drawable.ic_he_1_5);
    ves[0].setPic(R.drawable.ic_he_3_5);

int time=2;
    for(int i=0;i<ves.length;i++){
                ves[i].setTime(time+"分钟前");
        mDates.add(ves[i]);
        time+=5;
    }






}
    @Override
    protected void initData() {

    }
}