package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class findActivity2 extends AppCompatActivity {
    DatabaseReference df,bookRideDb;
    FirebaseAuth mAuth;
    private AutoCompleteTextView start;
    private AutoCompleteTextView stop;
    private TextView space;
    private TextView time;
    private TextView number;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2);
        start = (AutoCompleteTextView) findViewById(R.id.start_point);
        stop = (AutoCompleteTextView) findViewById(R.id.destination_point);
        space = (TextView) findViewById(R.id.textView);
        time = (TextView) findViewById(R.id.textView2);
        number = (TextView) findViewById(R.id.textView3);

        df = FirebaseDatabase.getInstance().getReference().child("Rides");

        mAuth=FirebaseAuth.getInstance();
        String userId=mAuth.getCurrentUser().getUid();
        bookRideDb = FirebaseDatabase.getInstance().getReference().child("Booked").child(userId);

    }
    Rides foundRides =null;
    public void searchRide(View v){
        df.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot startSnapshot : snapshot.getChildren()) {
                   Rides ride=startSnapshot.getValue(Rides.class);

                   if(start.getText().toString().equals(ride.getStart())&&stop.getText().toString().equals(ride.getEnd())){
                       space.setText(ride.getQuantity());
                       time.setText(ride.getTme());
                       number.setText(ride.getPh());
                       foundRides=ride;
                       break;

                   }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void bookRide(View view){
        Rides newRide=new Rides(start.getText().toString(),stop.getText().toString(),foundRides.getQuantity(),foundRides.getPrice(),foundRides.getDat(),foundRides.getTme(),foundRides.getPh());
        bookRideDb.setValue(newRide);
        Intent i=new Intent(findActivity2.this,secondActivity.class);
        startActivity(i);

    }


}

