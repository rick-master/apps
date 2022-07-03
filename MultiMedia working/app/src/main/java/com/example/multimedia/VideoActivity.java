package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    ImageView vstart,vpause,vstop;
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        vstart=(ImageView) findViewById(R.id.vidStart);
        vpause=(ImageView) findViewById(R.id.vidPause);
        vstop=(ImageView) findViewById(R.id.imgStop);
        vv = (VideoView) findViewById(R.id.videoView1);
        //creating media player
        MediaPlayer mp=new MediaPlayer();

        MediaController mc = new MediaController(this);


        vstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mc.setAnchorView(vv);
                Uri uri = Uri.parse("/sdcard/Download/vdo.mp4");
                vv.setVideoURI(uri);
                vv.start();
            }
        });

        vpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vv.pause();
            }
        });



    }
}