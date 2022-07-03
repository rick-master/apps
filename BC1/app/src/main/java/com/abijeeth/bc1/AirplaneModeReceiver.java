package com.abijeeth.bc1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(AirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context, "Airplane mode ON", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Airplane mode OFF", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean AirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0;
    }


}
