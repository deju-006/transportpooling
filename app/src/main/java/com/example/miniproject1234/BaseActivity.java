package com.example.miniproject1234;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.EventListener;

public class BaseActivity extends AppCompatActivity  implements EventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}