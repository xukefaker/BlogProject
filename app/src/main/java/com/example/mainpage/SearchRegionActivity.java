package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SearchRegionActivity extends BaseActivity {
private LinearLayout mLinBack;
private EditText edittext;

    @Override
    protected int initLayout() {
        return R.layout.activity_search_region;
    }

    @Override
    protected void initView() {
mLinBack=(LinearLayout)findViewById(R.id.ll_back);
mLinBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
         edittext = (EditText)findViewById(R.id.editText);
        edittext.setFocusable(true);
        edittext.setFocusableInTouchMode(true);
        edittext.requestFocus();
       //设置键盘200毫秒弹出
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputManager.showSoftInput(edittext, 0);
                           }
                       },
                200);
    }

    @Override
    protected void initData() {

    }
}