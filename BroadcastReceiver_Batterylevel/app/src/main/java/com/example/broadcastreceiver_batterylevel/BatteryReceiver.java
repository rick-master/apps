package com.example.broadcastreceiver_batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int percentage = intent.getIntExtra("level",0);
        if(percentage!=0){
            Toast.makeText(context, String.valueOf(percentage)+" %", Toast.LENGTH_SHORT).show();
        }
    }
}
