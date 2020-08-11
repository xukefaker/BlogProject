package com.example.mainpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private PopupWindow mPopupWindow;
    private TextView mTvType;
    private ImageView mIvBack;
    private View viewL;
    private TextView mTvType1;
    private TextView mTvType2;
    private TextView mTvType3;
    private EditText mEditText;

    //布局的初始化
    @Override
    protected int initLayout() {
        return R.layout.activity_search;
    }

    //控件的初始化
    @Override
    protected void initView() {
        mTvType = (TextView) findViewById(R.id.type);
        viewL = findViewById(R.id.ll_search);
        View view = getLayoutInflater().inflate(R.layout.layout_type_act, null);
        mPopupWindow = new PopupWindow(view);
        mTvType.setOnClickListener(this);
        mIvBack = (ImageView) findViewById(R.id.back);
        mIvBack.setOnClickListener(this);
        mTvType1 = view.findViewById(R.id.tv_ac);
        mTvType1.setOnClickListener(this);
        mTvType2 = view.findViewById(R.id.tv_text);
        mTvType2.setOnClickListener(this);
        mTvType3 = view.findViewById(R.id.tv_or);
        mTvType3.setOnClickListener(this);
       mEditText=findViewById(R.id.search_content);
        mEditText.setFocusable(true);
        mEditText.setFocusableInTouchMode(true);
        mEditText.requestFocus();
        //设置键盘200毫秒弹出
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputManager.showSoftInput(mEditText, 0);
                           }
                       },
                200);
    }



    //给控件赋值和添加事件
    @Override
    protected void initData() {

    }

    //处理一些点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.type:
                setPopupWindow();
                break;
            case R.id.back:
                backToMainActivity();
                break;
            case R.id.tv_or:
                mTvType.setText("组织");
                mPopupWindow.dismiss();
                break;
            case R.id.tv_text:
                mTvType.setText("文章");
                mPopupWindow.dismiss();
                break;
            case R.id.tv_ac:
                mTvType.setText("活动");
                mPopupWindow.dismiss();
                break;
        }
    }

    private void setPopupWindow() {

        mPopupWindow.setWidth(viewL.getWidth());
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
  mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(false);
        mPopupWindow.showAsDropDown(mTvType);

    }

    private void backToMainActivity() {


        finish();


    }

}
