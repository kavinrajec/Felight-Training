package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import java.util.Locale;
import android.widget.Toast;

/**
 * Created by KavinG on 10/14/2015.
 */
public class GreetUser extends Activity {
   // MediaPlayer mp;
    TextToSpeech t1;
    Button b1;
    TextView tv1;
    EditText e1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greet_user_layout);
       // mp = MediaPlayer.create(GreetUser.this, R.raw.music);
        b1=(Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editText);
        //mp.start();
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getText().toString();
                if(name.equals("")){
                    Toast.makeText(getApplicationContext(),"oops type something..!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String toSpeak = "Welcome " + name +" have a nice day.";
                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                    t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    protected void onStop() {
        super.onStop();
       // mp.stop();
    }


    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home_intent = new Intent(GreetUser.this, MainActivity.class);
        overridePendingTransition( R.anim.slide,R.anim.slideout);
        startActivity(home_intent);
        finish();
    }
}
