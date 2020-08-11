package com.example.mainpage.fragment.regionFragment;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.RegionActivity;
import com.example.mainpage.fragment.BaseFragment;


public class JiLinFragment extends BaseFragment implements View.OnClickListener {

private RecyclerView mRecyclerView;
    private TextView[] textViews = new TextView[10];
    @Override
    protected int initLayout() {
        return R.layout.fragment_ji_lin;
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





    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        String s = "";
        switch (view.getId()) {
            case R.id.tv_1:
                s = "长春市";
                break;
            case R.id.tv_2:
                s = "吉林市";
                break;
            case R.id.tv_3:
                s = "四平市";
                break;
            case R.id.tv_4:
                s = "辽源市";
                break;
            case R.id.tv_5:
                s = "通化市";
                break;
            case R.id.tv_6:
                s = "白山市";
                break;
            case R.id.tv_7:
                s = "松原市";
                break;
            case R.id.tv_8:
                s = "白城市";
                break;
            case R.id.tv_9:
                s = "延边州";
                break;
            case R.id.tv_10:
                s = "梅河口市";
                break;

        }
        ((RegionActivity) (getActivity())).getFinish(s);
    }
}