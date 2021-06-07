package com.dreamproject.registrationactivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String Gender= intent.getStringExtra("gender");
        String email = intent.getStringExtra("Email");
        String mobile = intent.getStringExtra("mobile");
        String password = intent.getStringExtra("password");
        String hobby1 = intent.getStringExtra("hobby1");
        String hobby2 = intent.getStringExtra("hobby2");
        String hobby3 = intent.getStringExtra("hobby3");
        String hobby4 = intent.getStringExtra("hobby4");

        TextView mResultTv = findViewById(R.id.resultTV);
        mResultTv.setText("Name: "+name+"\nGender:"+Gender+"\n Email: "+email+"\nMobile:"+mobile+"\nPassword:"+password+"\nHobby1:"+hobby1+"\nHobby2:"+hobby2+"\nHobby3:"+hobby3+"\nHobby4:"+hobby4);



    }
}