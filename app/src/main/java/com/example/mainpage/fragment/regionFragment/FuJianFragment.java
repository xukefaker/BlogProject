package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;


public class FuJianFragment extends BaseFragment implements View.OnClickListener {

private RecyclerView mRecyclerView;
    private TextView[] textViews = new TextView[12];
    @Override
    protected int initLayout() {
        return R.layout.fragment_fu_jian;
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


        textViews[0].setOnClickListener(this);
        textViews[1].setOnClickListener(this);
        textViews[2].setOnClickListener(this);
        textViews[3].setOnClickListener(this);
        textViews[4].setOnClickListener(this);
        textViews[5].setOnClickListener(this);
        textViews[6].setOnClickListener(this);
        textViews[7].setOnClickListener(this);
        textViews[8].setOnClickListener(this);





    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s = "";
        switch (view.getId()) {
            case R.id.tv_1:
                s = "福州市";
                break;
            case R.id.tv_2:
                s = "厦门市";
                break;
            case R.id.tv_3:
                s = "莆田市";
                break;
            case R.id.tv_4:
                s = "三明市";
                break;
            case R.id.tv_5:
                s = "泉州市";
                break;
            case R.id.tv_6:
                s = "漳州市";
                break;
            case R.id.tv_7:
                s = "南平市";
                break;
            case R.id.tv_8:
                s = "龙岩市";
                break;
            case R.id.tv_9:
                s = "宁德市";
                break;



        }
        ((RegionActivity) (getActivity())).getFinish(s);
    }
}