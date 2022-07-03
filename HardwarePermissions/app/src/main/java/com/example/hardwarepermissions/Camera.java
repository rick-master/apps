package com.example.hardwarepermissions;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    ImageView imageview;
    Button button1;
    private static final int CAMERA_REQUEST=1888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        button1=(Button) findViewById(R.id.button);
        imageview=(ImageView) findViewById(R.id.imageView);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQUEST);
            }
        });
    }
    protected void onActivityResult(int Request_code,int result_code,Intent data) {

        super.onActivityResult(Request_code, result_code, data);
        if (Request_code==CAMERA_REQUEST)
        {
            Bitmap photo=(Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(photo);
        }
    }
}