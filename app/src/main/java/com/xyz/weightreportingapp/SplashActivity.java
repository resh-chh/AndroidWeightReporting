package com.xyz.weightreportingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    Animation animation;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv1= (ImageView) findViewById(R.id.iv1);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();

            }
        }).start();

        animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_main);
        iv1.startAnimation(animation);

    }
}
