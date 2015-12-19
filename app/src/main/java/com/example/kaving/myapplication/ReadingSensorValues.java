package com.example.kaving.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KavinG on 10/27/2015.
 */
public class ReadingSensorValues extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    TextView tvSensorValues;
    ImageView imageView;
    Sensor sensor;
    private float x,y,z,last_x,last_y,last_z;
    private static final int SHAKE_THRESHOLD = 800;
    private long lastUpdate;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_sensor_values);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER);
        tvSensorValues = (TextView)findViewById(R.id.tvSensorValues);
        mp = MediaPlayer.create(ReadingSensorValues.this, R.raw.music);

    }

    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
        mp.stop();
    }

    public void onSensorChanged(SensorEvent event) {
            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                x = event.values[0];
                y = event.values[1];
                z = event.values[2];

                float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;
                if (speed > SHAKE_THRESHOLD) {
                    mp.start();
                    Log.d("sensor", "shake detected w/ speed: " + speed);
                    Toast.makeText(this, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                   tvSensorValues.setText("shake shake detected..!!" + "X: " + event.values[0] + "\n" + "Y: "
                           + event.values[1] + "\n" + "Z: " + event.values[2]+"\n");
                }
                last_x = x;
                last_y = y;
                last_z = z;
            }

        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

