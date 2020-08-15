package com.example.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultOfSaoActivity extends AppCompatActivity {
private ImageView ivBack;
private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_sao);
        final Bundle bundle=getIntent().getExtras();
       String s= bundle.getString("result");
        ivBack=findViewById(R.id.back);
        tvResult=findViewById(R.id.result);
        tvResult.setText(s);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}