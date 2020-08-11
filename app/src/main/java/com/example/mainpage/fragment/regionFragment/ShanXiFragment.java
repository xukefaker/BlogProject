package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;


public class ShanXiFragment extends BaseFragment implements View.OnClickListener {

private RecyclerView mRecyclerView;
    private TextView[] textViews = new TextView[12];
    @Override
    protected int initLayout() {
        return R.layout.fragment_shan_xi;
    }

    @Override
    protected void initView(View v) {
//      mRecyclerView=v.findViewById(R.id.rv_grid);
//      mRecyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),3));
//       mRecyclerView.setAdapter(new MyGirdAdapter(v.getContext()));

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




    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s = "";
        switch (view.getId()) {
            case R.id.tv_1:
                s = "太原市";
                break;
            case R.id.tv_2:
                s = "大同市";
                break;
            case R.id.tv_3:
                s = "阳泉市";
                break;
            case R.id.tv_4:
                s = "长治市";
                break;
            case R.id.tv_5:
                s = "晋城市";
                break;
            case R.id.tv_6:
                s = "朔州市";
                break;
            case R.id.tv_7:
                s = "晋中市";
                break;
            case R.id.tv_8:
                s = "运城市";
                break;
            case R.id.tv_9:
                s = "忻州市";
                break;
            case R.id.tv_10:
                s = "临汾市";
                break;
            case R.id.tv_11:
                s = "吕梁市";
                break;


        }
        ((RegionActivity) (getActivity())).getFinish(s);
    }
}