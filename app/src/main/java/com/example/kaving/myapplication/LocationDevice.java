package com.example.kaving.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.example.kaving.myapplication.R.id.tvLocation;

/**
 * Created by KavinG on 11/2/2015.
 */
public class LocationDevice extends Activity implements LocationListener {
    Button btnPress;
    String message;
    String numb;
    TextView tv;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    String provider;
    protected boolean gps_enabled, network_enabled;
    Double Latitude, Longitude;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_device);
        tv = (TextView) findViewById(R.id.tvLocation);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
    }
  /*  public void Send(View view){
        // http://www.google.com/maps/place/49.46800006494457,17.11514008755796
        String msg = "DUDE got Trapped in...   "+"/n"+" https://maps.google.com/maps?q=loc:"+Latitude +","+Longitude;
        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("9900175672  ",null,msg,null,null);
            Toast.makeText(this, "SMS SUCCESS", Toast.LENGTH_LONG).show();
        }catch (Exception ex){
            Toast.makeText(this,"SMS FAILED",Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }*/

    @Override
    public void onLocationChanged(Location location) {

        Latitude = location.getLatitude();
        Longitude = location.getLongitude();
        tv = (TextView) findViewById(R.id.tvLocation);
        tv.setText("Latitude:" + Latitude + ", Longitude:" + Longitude);

    }
    public  void getLocationDevice(View v){

    }


    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }
}
