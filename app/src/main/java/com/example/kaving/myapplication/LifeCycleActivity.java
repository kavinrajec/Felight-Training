package com.example.kaving.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by KavinG on 10/22/2015.
 */
public class LifeCycleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_cycle);
        Toast.makeText(this, "oncreate", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onstart", Toast.LENGTH_LONG).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onstop", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onresume", Toast.LENGTH_LONG).show();
    }

    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onpause", Toast.LENGTH_LONG).show();
    }
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onrestart", Toast.LENGTH_LONG).show();
    }
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ondestroy", Toast.LENGTH_LONG).show();
    }
}

