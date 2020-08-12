package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnterActivity extends BaseActivity{

    private Button btnLogin;
    private  Button btnRegister;
    @Override
    protected int initLayout() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initView() {
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnRegister=(Button)findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(LoginActivity.class);
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(RegisterActivity.class);

            }
        });
    }

    @Override
    protected void initData() {

    }
}