package com.example.kaving.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by KavinG on 10/30/2015.
 */
public class RightOrLeftDetection extends AppCompatActivity implements SensorEventListener {
    TextView textView;
    StringBuilder builder = new StringBuilder();

    float [] history = new float[2];
    String [] direction = {"NONE","NONE"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
        manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];
        float zChange = event.values[2];

        history[0] = event.values[0];
        history[1] = event.values[1];

        if (xChange > 2){
            direction[0] = "LEFT";
        }
        else if (xChange < -2){
            direction[0] = "RIGHT";
        }

        if (yChange > 2){
            direction[1] = "DOWN";
        }
        else if (yChange < -2){
            direction[1] = "UP";
        }

        builder.setLength(0);
        builder.append("x: ");
        builder.append(direction[0]);
        builder.append(" y: ");
        builder.append(direction[1]);

        textView.setText(zChange+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // nothing to do here
    }
}
