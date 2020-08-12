package com.example.mainpage;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends BaseActivity {

    private Timer mTimer;
    private Handler mHandler;
    private TextView mChange;
    private LinearLayout mEnter;
    private static int longTime;

    static {
        longTime = 4;
    }

    private Runnable mLooperTask = new Runnable() {
        @Override
        public void run() {
            longTime--;
            mChange.setText(String.valueOf(longTime));
            if (longTime != 0) {
                mHandler.postDelayed(this, 1000);
            }else {
                longTime=4;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mHandler = new Handler();
        mEnter = findViewById(R.id.ll_enter);
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimer.cancel();
                navigateTo(MainActivity.class);
                finish();


            }
        });
        mTimer = new Timer();
        TimerTask timeTask = new TimerTask() {
            @Override
            public void run() {
                navigateTo(MainActivity.class);
                finish();

            }
        };
        mTimer.schedule(timeTask, 3100);
        mChange = findViewById(R.id.tv_change);
        mHandler.post(mLooperTask);

    }

    @Override
    protected void initData() {

    }
}
