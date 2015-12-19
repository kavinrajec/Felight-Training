package com.example.kaving.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigate);
       // MediaPlayer mp = new MediaPlayer();

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnGreet:
                Intent greet = new Intent(this,GreetUser.class);
                startActivity(greet);
                overridePendingTransition(R.anim.slide, R.anim.slideout);
                finish();
                break;
            case R.id.btnCalci:
                Intent calci = new Intent(this,Calculator.class);
                startActivity(calci);
                break;
            case R.id.btnJokes:
                Intent jokes = new Intent(this,MyJokes.class);
                startActivity(jokes);
                break;
            case R.id.btnInstagram:
                Intent instagram = new Intent(this,InstagramCloneActivity.class);
                startActivity(instagram);
                break;
            case R.id.btnNewsActivity:
                Intent newsActivity = new Intent(this,NewsActivity.class);
                startActivity(newsActivity);
                break;
            case R.id.btnAudioPlayer:
                Intent audioPlayer= new Intent(this,AudioPlayer.class);
                startActivity(audioPlayer);
                break;
            case R.id.btnUserData:
                Intent userData= new Intent(this,UserDataActivity.class);
                startActivity(userData);
                break;
            case R.id.btnLifeCycle:
                Intent lifeCycle= new Intent(this,LifeCycleActivity.class);
                startActivity(lifeCycle);
                break;
            case R.id.btnMyCamera:
                Intent myCamera= new Intent(this,MyCamera.class);
                startActivity(myCamera);
                break;
            case R.id.btnMyContacts:
                Intent myContacts= new Intent(this,OpenContacts.class);
                startActivity(myContacts);
                break;
            case R.id.btnCallMsg:
                Intent callMsg= new Intent(this,CallMsg.class);
                startActivity(callMsg);
                break;
            case R.id.btnVideoPlayer:
                Intent videoPlayer= new Intent(this,VideoPlayer.class);
                startActivity(videoPlayer);
                break;
            case R.id.btnSensorList:
                Intent sensorList= new Intent(this,SensorListActivity.class);
                startActivity(sensorList);
                break;
            case R.id.btnSensorValues:
                Intent sensorValues= new Intent(this,ReadingSensorValues.class);
                startActivity(sensorValues);
                break;
            case R.id.btnAnimation:
                Intent animation= new Intent(this,AnimationActivity.class);
                startActivity(animation);
                break;
            case R.id.btnGoogleMap:
                Intent googleMap= new Intent(this,MapsActivity.class);
                startActivity(googleMap);
                break;
            case R.id.btnCompass:
                Intent compass= new Intent(this,CompassActivity.class);
                startActivity(compass);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add("Help");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
