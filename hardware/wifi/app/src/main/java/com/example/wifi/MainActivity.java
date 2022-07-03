package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button enableButton,disableButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableButton=(Button)findViewById(R.id.button);
        disableButton=(Button)findViewById(R.id.button2);

        enableButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v)
        {
            WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            wifi.setWifiEnabled(true);
        }
        });
        disableButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
        WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(false);
        }});
}

}
