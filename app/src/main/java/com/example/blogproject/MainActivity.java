package com.example.blogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"woshizhouyi",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, FakerTest.class);
                startActivity(intent);
            }
        });
        /*
        angoakganlkgnaojgjoag
        aengaiugaenigtaijegfnkja
        awtgarfaljtrnjwaejklrar
         */
    }
}