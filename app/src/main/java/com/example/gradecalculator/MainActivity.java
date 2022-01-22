package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home Screen");

    }
    public void valueActivity(View v) {
        Intent i = new Intent(this, ValueActivity.class);
        startActivity(i);


    }
}