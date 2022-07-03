package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView out = (TextView) findViewById(R.id.textView);
        final Button button1 = (Button) findViewById(R.id.on);
        final Button button2 = (Button) findViewById(R.id.dis);
        final Button button3 = (Button) findViewById(R.id.off);
        final BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
        if (ba == null) {
            out.append("device not supported");
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ba.isEnabled()) {
                    Intent i1 = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

                    startActivityForResult(i1, REQUEST_ENABLE_BT);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ba.isDiscovering()) {
                    out.append("MAKING YOUR DEVICE DISCOVERABLE");
                    Toast.makeText(getApplicationContext(),"MAKING YOUR DEVICE DISCOVERABLE",Toast.LENGTH_LONG);
                    Intent i2 = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                    startActivityForResult(i2, REQUEST_DISCOVER_BT);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    ba.disable();
                    Toast.makeText(getApplicationContext(),"Turning off",Toast.LENGTH_LONG);


            }
        });
    }
}