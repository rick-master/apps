    package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.notificationmessage);
        Button send = findViewById(R.id.Notify);

        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String message = et1.getText().toString();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "100")
                        .setContentText(message)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle("Status Notification");


                NotificationManager manager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationChannel channel =new NotificationChannel("100", "sample", NotificationManager.IMPORTANCE_DEFAULT);
                manager.createNotificationChannel(channel);
                manager.notify(0,builder.build());

            }
        });

    }
}