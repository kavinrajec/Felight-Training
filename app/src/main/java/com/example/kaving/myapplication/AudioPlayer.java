package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by KavinG on 10/20/2015.
 */
public class AudioPlayer extends Activity {

    MediaPlayer mediaPlayer;
    Intent intent;
    /* Uri uri;
    ArrayList<Uri> songList;
   public void selectAudio(View view){
        Intent intent=new Intent();
        intent.setType("audio*//*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(Intent.createChooser(intent, "choose file"), 1);

    }*/
    public void play(View view){
        intent = new Intent(this,MusicService.class);
        startService(intent);
      /*  try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(getBaseContext(), uri);//for streaming online giveUri.parse("path"); instead of uri;
            mediaPlayer.prepare();
            mediaPlayer.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
*/
    }
    public void stop(View view){
        if(mediaPlayer!=null){
            mediaPlayer.stop();

        }
        else
            Toast.makeText(getBaseContext(),"Hello..Start Song First", Toast.LENGTH_SHORT).show();
    }
    public void pause(View view){

        mediaPlayer.pause();
    }

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        uri=Uri.parse(intent.getData().getPath());
        songList=new ArrayList<Uri>();
    }
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_player);
    }

    /*Intent intent;
    MediaPlayer sound;
    Button play,pause,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_player);
        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnStop);
        stop = (Button) findViewById(R.id.btnStop);
        initialize();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
                initialize();
            }
        });

    }
    public void initialize(){
        sound = MediaPlayer.create(AudioPlayer.this,R.raw.music);
    }*/
}
