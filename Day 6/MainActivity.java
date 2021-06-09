package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.tale);
        mediaPlayer.start();
//


        Thread thread = new Thread() {
            @Override
            public void run() {

                try {
                    setContentView(R.layout.activity_main);
                    sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                finally {
                    Intent intent = new Intent(MainActivity.this, Splash2.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();

    }


}