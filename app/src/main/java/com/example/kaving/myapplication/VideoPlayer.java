package com.example.kaving.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by KavinG on 10/26/2015.
 */
public class VideoPlayer extends AppCompatActivity {
    Uri uri;
    VideoView vwResult;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);
        vwResult = (VideoView)findViewById(R.id.vwResult);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(vwResult);
       // VideoView videoView =(VideoView)findViewById(R.id.videoView1);

        //Creating MediaController
       // MediaController mediaController= new MediaController(this);
        //mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/media/1.mp4");

        //Setting MediaController and URI, then starting the videoView
        vwResult.setMediaController(mediaController);
        vwResult.setVideoURI(uri);
        vwResult.requestFocus();
        vwResult.start();
    }

  /*  public  void selectVideo(View v){
        Intent intent = new Intent();
        intent.setType("video*//*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        startActivityForResult(Intent.createChooser(intent,"choose video file"),1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri = Uri.parse(data.getData().getPath());
        vwResult.setMediaController(mediaController);
        vwResult.setVideoURI(uri);
        vwResult.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vwResult.start();
            }
        });
    }*/
}
