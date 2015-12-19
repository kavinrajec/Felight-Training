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
 * Created by KavinG on 10/28/2015.
 */
public class AutoReplyMsg extends BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent recieved: " + intent.getAction());

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[])bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                for(SmsMessage message : messages){
                    String strMessageFrom = message.getDisplayOriginatingAddress();
                    String strMessageBody = message.getDisplayMessageBody();

                    Toast.makeText(context, "Message recieved: " + strMessageFrom, Toast.LENGTH_LONG).show();
                    Toast.makeText(context, "Message Body: " + strMessageBody, Toast.LENGTH_LONG).show();
                    //String strMessageFrom = message.getDisplayOriginatingAddress();
                    if(strMessageFrom == "+919655698535"){
                        String strmessage = "I' am busy right now";
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(strMessageFrom, null, strmessage, null, null);
                        Toast.makeText(context, "Auto Replied message sent", Toast.LENGTH_LONG).show();
                    }

                }
            }
        }
    }
}
