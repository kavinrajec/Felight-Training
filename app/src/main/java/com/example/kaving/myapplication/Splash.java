package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Kavin on 10/21/2015.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Handler han = new Handler();
        Runnable obj = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide, R.anim.slideout);
                finish();
            }
        };
        han.postDelayed(obj,3000);
    }
}
