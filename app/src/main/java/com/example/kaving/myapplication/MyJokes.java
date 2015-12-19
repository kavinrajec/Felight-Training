package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by KavinG on 10/14/2015.
 */
public class MyJokes extends AppCompatActivity implements SensorEventListener {

    String[] myJokes = {"Hi dude!!! Click NEXT to Laugh!!!! ","Teacher: What is the name of the capital city of Punjab ?", "Pappu: Amritsar.",
            "Teacher: Pappu, you are wrong, you need to focus more on your studies.", "Pappu: Please madam, can I ask you a few questions.",
            "Teacher: Yes, go ahead.", "Pappu: Do you know Jeeto ?", "Teacher: No.", "Pappu: Do you know Preeto ?",
            "Teacher: No.", "Pappu: Do you know Banto?", "Teacher: (Angry) Hell no! Who are all these people and why do you ask ?",
            "Pappu: Teacher, you need to Focus more on your husband.","Thanks for Reading..!!! Bye"};

    int jokeIndex = 0;
    TextView tvJokes;
    float [] history = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_layout);
        tvJokes = (TextView) findViewById(R.id.tvJokes);
        tvJokes.setText(myJokes[jokeIndex]);
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);

    }

   /* public void onClickButton(View v) {
        tvJokes = (TextView) findViewById(R.id.tvJokes);
        switch (v.getId()) {
            case R.id.btnNext:
                if (jokeIndex < myJokes.length-1) {
                    jokeIndex++;
                    tvJokes.setText(myJokes[jokeIndex]);
                }
                break;
            case R.id.btnPrev:
                if (jokeIndex > 0) {
                    jokeIndex--;
                    tvJokes.setText(myJokes[jokeIndex]);
                }
                break;
        }
    }
  */  @Override
    public void onSensorChanged(SensorEvent event) {

        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];

        history[0] = event.values[0];
        history[1] = event.values[1];

        if (xChange > 4){
           // direction[0] = "LEFT";
            if (jokeIndex > 0) {
                jokeIndex--;
                tvJokes.setText(myJokes[jokeIndex]);
            }

        }
        else if (xChange < -4){
            //direction[0] = "RIGHT";
            if (jokeIndex < myJokes.length-1) {
                jokeIndex++;
                tvJokes.setText(myJokes[jokeIndex]);
            }
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // nothing to do here
    }
}
