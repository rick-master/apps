package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name, phone, mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.tvName);
        phone = findViewById(R.id.tvAge);
        mail = findViewById(R.id.tvEmail);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        String s2 = sh.getString("phone", " ");
        String s3 = sh.getString("mail", " ");


        name.setText(s1);
        phone.setText(s2);
        mail.setText(s3);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("name", name.getText().toString());
        myEdit.putString("phone", phone.getText().toString());
        myEdit.putString("mail", mail.getText().toString());
        myEdit.apply();
    }
}

