package com.example.kaving.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by KavinG on 11/4/2015.
 */
public class BackGroundColorActivity extends AppCompatActivity {
    public  static final String COLOR="color";
    RadioGroup rgColor;
    Intent intentRed,intentGreen,intentBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_ground_color_activity);
        rgColor = (RadioGroup) findViewById(R.id.rgColor);
        rgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbtRed:
                        intentRed = new Intent();
                        intentRed.putExtra(COLOR,Color.RED);
                        setResult(RESULT_OK,intentRed);
                        Toast.makeText(getApplicationContext(), "choice: Red",
                                Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case R.id.rbtGreen:
                        Toast.makeText(getApplicationContext(), "choice: Green",
                                Toast.LENGTH_SHORT).show();
                        intentGreen = new Intent();
                        intentGreen.putExtra(COLOR,Color.GREEN);
                        setResult(RESULT_OK,intentGreen);
                        finish();
                        break;
                    case R.id.rbtBlue:
                        Toast.makeText(getApplicationContext(), "choice: Blue",
                                Toast.LENGTH_SHORT).show();
                        intentBlue = new Intent();
                        intentBlue.putExtra(COLOR,Color.BLUE);
                        setResult(RESULT_OK,intentBlue);
                        finish();
                        break;
                }
            }
        });
    }
}
