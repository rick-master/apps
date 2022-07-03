package com.example.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Fragment fragment = new MapFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();

    }
}