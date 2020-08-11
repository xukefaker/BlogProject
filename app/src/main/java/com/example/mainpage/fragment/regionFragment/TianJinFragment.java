package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;


public class TianJinFragment extends BaseFragment implements View.OnClickListener{

private RecyclerView mRecyclerView;
    private TextView[] textViews=new TextView[1];
    @Override
    protected int initLayout() {
        return R.layout.fragment_tian_jin;
    }

    @Override
    protected void initView(View v) {
        textViews[0]=(TextView)v.findViewById(R.id.tv_1);
        textViews[0].setOnClickListener(this);



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s="";
        switch (view.getId()){
            case R.id.tv_1:
                s="天津市";
                break;
        }
        ((RegionActivity)(getActivity())).getFinish(s);
    }
}