package com.example.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    Button btnlocation;
    TextView textview1, textview2, textview3, textview4, textview5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnlocation = findViewById(R.id.bt_location);
        textview1 = findViewById(R.id.t1);
        textview2 = findViewById(R.id.t2);
        textview3 = findViewById(R.id.t3);
        textview4 = findViewById(R.id.t4);
        textview5 = findViewById(R.id.t5);
        Button back = findViewById(R.id.btnGoback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(SecondActivity.this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(SecondActivity.this, Locale.getDefault());
                        List<Address> address = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        textview1.setText(Html.fromHtml("<font color='#6200EE'><b>Latitude:</b><br></font>" + address.get(0).getLatitude()
                        ));
                        textview2.setText(Html.fromHtml("<font color='#6200EE'><b>Longitude:</b><br></font>" + address.get(0).getLongitude()
                        ));
                        textview3.setText(Html.fromHtml("<font color='#6200EE'><b>Country:</b><br></font>" + address.get(0).getCountryName()
                        ));
                        textview4.setText(Html.fromHtml("<font color='#6200EE'><b>Locality:</b><br></font>" + address.get(0).getLocality()
                        ));
                        textview5.setText(Html.fromHtml("<font color='#6200EE'><b>Address</b><br></font>" + address.get(0).getAddressLine(0)
                        ));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
