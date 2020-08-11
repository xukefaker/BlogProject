package com.example.mainpage.api;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {
    private static String mRequestUrl;
    private static HashMap<String,Object> mParams;
    public static Api api=new Api();
   private static OkHttpClient client;
    public Api(){}
    public static Api config(String url, HashMap<String,Object> params){
        client = new OkHttpClient.Builder().build();
        mRequestUrl=ApiConfig.BASE_URL+url;
        mParams=params;
        return api;
    }
    public static void postRequest(final TtitCallback callback){
        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        RequestBody requestBodyJson = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonStr);
      //第三步创建Request
        Request request = new Request.Builder().url(mRequestUrl)
                .addHeader("contentType", "application/json;charset=UTF-8")
                .post(requestBodyJson).build();
        //第四步创建call回调函数
        final Call call = client.newCall(request);
        //第五步发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("onFailure",e.getMessage());
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                 callback.onSuccess(result);
            }
        });
    }
}
