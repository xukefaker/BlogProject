package com.example.mainpage.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    //都是使用同一个mToast对象，就可以实现只显示最新的Toast
    public static Toast mToast;
    public static void  showMessage(Context context,String msg){
        if(mToast==null){
            mToast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else {
            mToast.setText(msg);
        }
        mToast.show();


    }
}
