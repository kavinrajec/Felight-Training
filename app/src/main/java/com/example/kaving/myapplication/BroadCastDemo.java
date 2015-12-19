package com.example.kaving.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by KavinG on 10/26/2015.
 */
public class BroadCastDemo extends BroadcastReceiver{
    private static final String AIRPLANE_MODE = "android.intent.action.AIRPLANE_MODE";
    private static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    private static final String BATTERY_LOW=  "android.intent.action.BATTERY_LOW";
    private static final String BOOT_COMPLETED= "android.intent.action.BOOT_COMPLETED";
    private static final String WALLPAPER_CHANGED= "android.intent.action.WALLPAPER_CHANGED";
    private static final String HEADSET_PLUG= "android.intent.action.HEADSET_PLUG";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(AIRPLANE_MODE)){
            Toast.makeText(context,"Hey Kullukki Airplane mode is Active...!!!", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(ACTION_POWER_CONNECTED)){
            Toast.makeText(context,"Hey Kullukki power connected...!!!", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(BATTERY_LOW)){
            Toast.makeText(context,"Hey Kullukki your Battery is low...!!!", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(BOOT_COMPLETED)){
            Toast.makeText(context,"Hey Kullukki your Boot Completed...!!!", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(WALLPAPER_CHANGED)){
            Toast.makeText(context,"Hey Kullukki u have changed your Wallpaper...!!!", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(HEADSET_PLUG)) {
            Toast.makeText(context, "Hey Kullukki Headset Detected...!!!", Toast.LENGTH_LONG).show();
        }


    }
}