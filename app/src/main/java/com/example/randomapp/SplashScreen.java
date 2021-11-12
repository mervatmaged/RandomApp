package com.example.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    long a = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        Timer runSplash= new Timer();
        TimerTask showSplash =new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
            }
        };
        runSplash.schedule(showSplash,a);

    }
}