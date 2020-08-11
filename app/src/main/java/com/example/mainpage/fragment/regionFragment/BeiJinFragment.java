package com.example.mainpage.fragment.regionFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.adapter.MyGirdAdapter;
import com.example.mainpage.fragment.BaseFragment;


public class BeiJinFragment extends BaseFragment implements View.OnClickListener{

private RecyclerView mRecyclerView;
private TextView tv1;
    @Override
    protected int initLayout() {
        return R.layout.fragment_bei_jin;
    }

    @Override
    protected void initView(View v) {
//      mRecyclerView=v.findViewById(R.id.rv_grid);
//      mRecyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
//       mRecyclerView.setAdapter(new MyGirdAdapter(v.getContext()));
    tv1=v.findViewById(R.id.tv_1);
    tv1.setOnClickListener(this);



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s="北京市";
        switch (view.getId()){
            case R.id.tv_1:
                s="北京市";
                break;
                  }
        ((RegionActivity)(getActivity())).getFinish(s);
    }
}