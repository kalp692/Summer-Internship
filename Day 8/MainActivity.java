package com.example.customactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView lv1;
    int[] image={R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd};
    String[] name={"This is Image-1","This is Image-2","This is Image-3","This is Image-4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=findViewById(R.id.lv1);

        Myadapter myadapter=new Myadapter(image,name,MainActivity.this);
        lv1.setAdapter(myadapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(MainActivity.this,ListDataActivity.class);
                i.putExtra("I1",image[position]);
                i.putExtra("T1",name[position]);
                startActivity(i);

            }
        });


    }
}