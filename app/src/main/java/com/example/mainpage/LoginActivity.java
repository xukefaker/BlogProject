package com.example.mainpage;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mainpage.api.Api;
import com.example.mainpage.api.ApiConfig;
import com.example.mainpage.api.TtitCallback;
import com.example.mainpage.entity.LoginResponse;
import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {
    private SharedPreferences mSharedPreferences;
    private EditText mEtAccount;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;
    private SharedPreferences.Editor mEditor;
    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mEtAccount = (EditText) findViewById(R.id.et_account);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = mEtAccount.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                login(account, password);

            }
        });
        mBtnRegister=(Button)findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(RegisterActivity.class);

                finish();

            }
        });
    }

    @Override
    protected void initData() {

    }

    private void login(final String account, String password) {
        if ("".equals(account) || account == null) {
            Toast.makeText(LoginActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password) || password == null) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String,Object> params = new HashMap<>();
        params.put("mobile", account);
        params.put("password", password);

        Api.config(ApiConfig.LOGIN, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {

                Gson gson=new Gson();
                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
                if(loginResponse.getCode()==0){
                    String token=loginResponse.getToken();

                    saveStringToSharePreference("token",token);
                    navigateTo(MainActivity.class);
                    finish();

                    mSharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
                    mEditor=mSharedPreferences.edit();
                    mEditor.putString("name",account);
                    mEditor.commit();

               //   String string=  mSharedPreferences.getString("name","").toString();
                    showToastSync("登录成功");


                }else {
                    showToastSync("登录失败");
                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure",e.getMessage());
            }
        });
    }
}