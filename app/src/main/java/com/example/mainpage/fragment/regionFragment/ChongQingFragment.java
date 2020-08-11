package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;

import org.w3c.dom.Text;


public class ChongQingFragment extends BaseFragment implements View.OnClickListener {
private TextView tv1;
private RecyclerView mRecyclerView;
    @Override
    protected int initLayout() {
        return R.layout.fragment_chong_qing;
    }

    @Override
    protected void initView(View v) {
   tv1=(TextView)v.findViewById(R.id.tv_1);
    tv1.setOnClickListener(this);



    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s="重庆市";
        switch (view.getId()){
            case R.id.tv_1:
                s="重庆市";
                break;
        }
        ((RegionActivity)(getActivity())).getFinish(s);
    }
}