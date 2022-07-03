package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {
    ImageView start,pause,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        start=(ImageView) findViewById(R.id.imgStart);
        pause=(ImageView) findViewById(R.id.imgPause);
        stop=(ImageView) findViewById(R.id.imgStop);
        //creating media player
        MediaPlayer mp=new MediaPlayer();

        MediaController mc = new MediaController(this);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                try {
                    mp.setDataSource("/sdcard/Download/music.mp3");
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });


    }




}
