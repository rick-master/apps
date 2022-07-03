package com.example.whatsapp;




import androidx.appcompat
        .app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Taking reference of Edit Text
        final EditText messageEditText
                = findViewById(R.id.message);

        // Taking reference to button
        Button submit
                = findViewById(R.id.submit);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {

                        // Getting the text
                        // from edit text
                        String message
                                = messageEditText
                                .getText()
                                .toString();

                        // Calling the function
                        // to send message
                        sendMessage(message);
                    }
                });
    }

    private void sendMessage(String message)
    {

        // Creating new intent
        Intent intent
                = new Intent(
                Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");

        // Give your message here
        intent.putExtra(
                Intent.EXTRA_TEXT,
                message);

        // Checking whether Whatsapp
        // is installed or not
        if (intent
                .resolveActivity(
                        getPackageManager())
                == null) {
            Toast.makeText(
                    this,
                    "Please install whatsapp first.",
                    Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        // Starting Whatsapp
        startActivity(intent);
    }
}
