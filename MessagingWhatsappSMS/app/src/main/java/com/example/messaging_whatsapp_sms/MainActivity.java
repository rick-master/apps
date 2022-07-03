package com.example.messaging_whatsapp_sms;

import android.content.Intent;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView pno,msg;
    Button sms,wa;
    String number,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pno=findViewById(R.id.editText);
        msg=findViewById(R.id.editText2);

    }

    public void sendsms(View view) {
        number=pno.getText().toString();
        message=msg.getText().toString();

        try {
            SmsManager smsmanager = SmsManager.getDefault();
            smsmanager.sendTextMessage(number, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent"+message, Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {

            Toast.makeText(getApplicationContext(), "Empty fields"+message+" "+number, Toast.LENGTH_SHORT).show();
        }
    }

    public void sendwhatsapp(View view) {
        number=pno.getText().toString();
        message=msg.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if(intent.resolveActivity(getPackageManager())==null)
        {
            Toast.makeText(getApplicationContext(),"install whatsapp",Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }
}
