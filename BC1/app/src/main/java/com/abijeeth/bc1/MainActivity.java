package com.abijeeth.bc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AirplaneModeReceiver ar = new AirplaneModeReceiver();
    Receiver r1 = new Receiver();
    ConnectivityReceiver cr = new ConnectivityReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(r1,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        registerReceiver(ar,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        registerReceiver(cr,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(r1);
        unregisterReceiver(ar);
        unregisterReceiver(cr);
    }
}