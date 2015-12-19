package com.example.kaving.myapplication;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by KavinG on 10/27/2015.
 */
public class AnimationActivity extends AppCompatActivity {
    Button btnAnimate;
    ImageView ivResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);
        btnAnimate = (Button)findViewById(R.id.btnAnimate);
        ivResult = (ImageView)findViewById(R.id.ivResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivResult,"rotation",0,100,200,360,-500,360,200,100,0);
                objectAnimator.setDuration(6000);
                objectAnimator.start();
            }
        });
    }
}
