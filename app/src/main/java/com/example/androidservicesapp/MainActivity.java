package com.example.androidservicesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.edit_title);
    }

    public void startService(View view) {
        String input = title.getText().toString();
        Intent serviceIntent = new Intent(MainActivity.this, AndroidServiceClass.class);
        serviceIntent.putExtra("intentExtra", input);
        startForegroundService(serviceIntent);
    }

    public void stopService(View view) {
        Intent serviceIntent = new Intent(MainActivity.this, AndroidServiceClass.class);
        stopService(serviceIntent);
    }
}