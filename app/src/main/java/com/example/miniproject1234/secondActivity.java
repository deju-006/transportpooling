package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class secondActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void findRide(View v) {
        Intent i=new Intent(secondActivity.this,findActivity2.class);
         finish();
        startActivity(i);

    }

    public void provideRide(View v) {
        Intent i=new Intent(secondActivity.this,provideActivity2.class);
        finish();
        startActivity(i);
    }



}







