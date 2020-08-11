package com.example.mainpage;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mainpage.api.Api;
import com.example.mainpage.api.ApiConfig;
import com.example.mainpage.api.TtitCallback;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity{
    private Button button;
    private EditText mEtAccount;
    private EditText mEtPassword;
    private EditText mEtPassword2;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mEtAccount = (EditText) findViewById(R.id.et_account);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mEtPassword2= (EditText) findViewById(R.id.et_password2);
        button=(Button)findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = mEtAccount.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                String password2=mEtPassword2.getText().toString().trim();
                register(account, password,password2);
            }
        });
    }

    @Override
    protected void initData() {

    }

    private  void register(String account, String password,String password2) {
        if ("".equals(account) || account == null) {
            Toast.makeText(RegisterActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password) || password == null) {
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if ("".equals(password2) || password2 == null) {
            Toast.makeText(RegisterActivity.this, "请输入确认密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password2.equals(password)){
            Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String,Object> params = new HashMap<>();
        params.put("mobile", account);
        params.put("password", password);

        Api.config(ApiConfig.REGISTER, params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(RegisterActivity.this,res,Toast.LENGTH_LONG).show();
//                    }
//                });
                if(res.contains("数据库中已存在该记录")){
                    showToastSync("该账号已存在，请登陆");
                    return;
                }else {
                    finish();
                    navigateTo(LoginActivity.class);
                    showToastSync("注册成功,请登陆");


                }


//                Gson gson=new Gson();
//                LoginResponse loginResponse=gson.fromJson(res,LoginResponse.class);
//                if(loginResponse.getCode()==0){
//                    String token=loginResponse.getToken();
//                    SharedPreferences sharedPreferences=getSharedPreferences("sp_ttit",MODE_PRIVATE);
//                    SharedPreferences.Editor editor=sharedPreferences.edit();
//                    editor.putString("token",token);
//                    editor.commit();
//                    showToastSync("登录成功");
//                }else {
//                    showToastSync("登录失败");
//                }
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure",e.getMessage());
            }
        });





    }
}