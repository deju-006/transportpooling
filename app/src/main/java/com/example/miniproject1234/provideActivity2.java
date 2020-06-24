package com.example.miniproject1234;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class provideActivity2 extends AppCompatActivity {
    private AutoCompleteTextView startpoint;
    private AutoCompleteTextView Destination;
    private AutoCompleteTextView amount;
    private AutoCompleteTextView cost;
    private EditText time;
    private FirebaseAuth mAuth;
    private DatabaseReference mRideDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide2);
      startpoint=(AutoCompleteTextView) findViewById(R.id.start_point);
      Destination=(AutoCompleteTextView) findViewById(R.id.destination_point);
      amount=(AutoCompleteTextView) findViewById(R.id.amount_bags);
      cost=(AutoCompleteTextView) findViewById(R.id.cost_rs);
      time= (EditText) findViewById(R.id.editTextTime);
      mRideDatabase= FirebaseDatabase.getInstance().getReference().child("Rides");
      mAuth=FirebaseAuth.getInstance();
      mRideDatabase.child(mAuth.getCurrentUser().getUid()).setValue();



    }
}