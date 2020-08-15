package com.example.mainpage;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mainpage.widger.CustomDialog;

import java.util.Set;

public class SetActivity extends BaseActivity {
private ImageView iv_back;
 private LinearLayout ll_exit;
private TextView tv_exit_button;
    @Override
    protected int initLayout() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
iv_back=findViewById(R.id.back);
ll_exit=findViewById(R.id.ll_exit);
tv_exit_button=findViewById(R.id.tv_exit_login);
iv_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
 tv_exit_button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {

         CustomDialog customDialog=new CustomDialog(SetActivity.this);
         customDialog.setCancel("取消", new CustomDialog.IOnCancelListener() {
             @Override
             public void onCancel(CustomDialog dialog) {
                // ToastUtil.showMessage(SetActivity.this,"cancel....");
             }
         }).setConfirm("确认退出登录", new CustomDialog.IOnConfirmListener() {
             @Override
             public void onConfirm(CustomDialog dialog) {
                // ToastUtil.showMessage(SetActivity.this,"confirm....");
                 getFinish("yes");
             }
         }).show();

     }
 });
    }

    @Override
    protected void initData() {

    }
    //关闭该Activity并跳转至MainActivity传入选择的城市名
    public void getFinish(String isClose){
      SharedPreferences mSharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
     SharedPreferences.Editor   mEditor=mSharedPreferences.edit();
        mEditor.putString("name","");
        mEditor.commit();

        Intent intent=new Intent();
        Bundle bundle1=new Bundle();
        bundle1.putString("close",isClose);

        intent.putExtras(bundle1);
        setResult(Activity. RESULT_FIRST_USER,intent);

        this.finish();
    }
}