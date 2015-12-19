package com.example.kaving.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KavinG on 10/27/2015.
 */
public class SensorListActivity extends AppCompatActivity {
    SensorManager sensorManager;
    TextView tvSensorsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensors_list_activity);
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tvSensorsList = (TextView)findViewById(R.id.tvSensorsList);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorData = new StringBuilder();
        for(Sensor sensor:sensorList){
            sensorData.append("Name: "+sensor.getName()+"\n"+"Vendor: "+sensor.getVendor()+"\n"+"Power: "+sensor.getPower()+"\n");
        }
        tvSensorsList.setText(sensorData);
    }
}
