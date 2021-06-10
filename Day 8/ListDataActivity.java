package com.example.customactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDataActivity extends AppCompatActivity {
ImageView iv2;
TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        iv2=findViewById(R.id.iv2);
        tv2=findViewById(R.id.tv2);

        Intent i=getIntent();

        String name=i.getStringExtra("T1");
        tv2.setText(name);

        int image= i.getIntExtra("I1",R.drawable.aa);
        iv2.setImageResource(image);

    }
}