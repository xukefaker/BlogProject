package com.example.mainpage.fragment;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mainpage.R;
import com.example.mainpage.util.EncodingUtils;

import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

public class SignFragment extends BaseFragment {
   private ImageView imageView;
   private Button button;
   private String s;
    private SharedPreferences mSharedPreferences;
    private    Random r=new Random(100);
    @Override
    protected int initLayout() {
        return R.layout.fragment_sign;
    }

    @Override
    protected void initView(final View v) {
        imageView=v.findViewById(R.id.iv);
        button=v.findViewById(R.id.btn);
        s="ro";

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               qrCode2(v);
           }
       });
       mSharedPreferences=getActivity().getSharedPreferences("data",MODE_PRIVATE);

       s=mSharedPreferences.getString("name","root").toString();



    }

    @Override
    protected void initData() {

    }
    /**
     * 生成不带Logo的二维码点击事件
     * @param view
     */
    public void qrCode1(View view){
        if ("".equals(s)){
           // Toast.makeText(this, "请在输入框中输入内容", Toast.LENGTH_SHORT).show();
            return;
        }
        //生成二维码
        Bitmap codeBitmap = EncodingUtils.createQRCode(s,500,500,null);
        imageView.setImageBitmap(codeBitmap);//显示二维码
    }
    /**
     * 生成带Logo的二维码
     * @param view
     */
    public void qrCode2 (View view){
        if ("".equals(s)){
           // Toast.makeText(this, "请在输入框中输入内容", Toast.LENGTH_SHORT).show();
            return;
        }

        //获取logo资源,
        //R.drawable.logo为logo图片
        String temp=s;
        s="{account="+s+";mobile="+s+";id="+r.nextInt()+";}";
        Bitmap logoBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_my_7);
        //生成二维码
        Bitmap codeBitmap = EncodingUtils.createQRCode(s,250,250,logoBitmap);
        imageView.setImageBitmap(codeBitmap);//显示二维码
        s=temp;
    }
}