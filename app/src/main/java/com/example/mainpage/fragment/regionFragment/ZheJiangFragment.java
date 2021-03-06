package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;


public class ZheJiangFragment extends BaseFragment implements View.OnClickListener{

private RecyclerView mRecyclerView;
    private TextView[] textViews = new TextView[17];
    @Override
    protected int initLayout() {
        return R.layout.fragment_zhe_jiang;
    }

    @Override
    protected void initView(View v) {
        textViews[0] = v.findViewById(R.id.tv_1);
        textViews[1] = v.findViewById(R.id.tv_2);
        textViews[2] = v.findViewById(R.id.tv_3);
        textViews[3] = v.findViewById(R.id.tv_4);
        textViews[4] = v.findViewById(R.id.tv_5);
        textViews[5] = v.findViewById(R.id.tv_6);
        textViews[6] = v.findViewById(R.id.tv_7);
        textViews[7] = v.findViewById(R.id.tv_8);
        textViews[8] = v.findViewById(R.id.tv_9);
        textViews[9] = v.findViewById(R.id.tv_10);
        textViews[10] = v.findViewById(R.id.tv_11);
        textViews[11] = v.findViewById(R.id.tv_12);



        textViews[0].setOnClickListener(this);
        textViews[1].setOnClickListener(this);
        textViews[2].setOnClickListener(this);
        textViews[3].setOnClickListener(this);
        textViews[4].setOnClickListener(this);
        textViews[5].setOnClickListener(this);
        textViews[6].setOnClickListener(this);
        textViews[7].setOnClickListener(this);
        textViews[8].setOnClickListener(this);
        textViews[9].setOnClickListener(this);
        textViews[10].setOnClickListener(this);
        textViews[11].setOnClickListener(this);







    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s = "";
        switch (view.getId()) {
            case R.id.tv_1:
                s = "杭州市";
                break;
            case R.id.tv_2:
                s = "嘉兴市";
                break;
            case R.id.tv_3:
                s = "湖州市";
                break;
            case R.id.tv_4:
                s = "绍兴市";
                break;
            case R.id.tv_5:
                s = "金华市";
                break;
            case R.id.tv_6:
                s = "衢州市";
                break;
            case R.id.tv_7:
                s = "舟山市";
                break;
            case R.id.tv_8:
                s = "台州市";
                break;
            case R.id.tv_9:
                s = "瑞安市";
                break;
            case R.id.tv_10:
                s = "德清县";
                break;
            case R.id.tv_11:
                s = "建德市";
                break;
            case R.id.tv_12:
                s = "龙游县";
                break;



        }
        ((RegionActivity) (getActivity())).getFinish(s);
    }
}