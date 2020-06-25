package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
    DatabaseReference df;
    private AutoCompleteTextView start;
    private AutoCompleteTextView stop;
    private TextView space;
    private TextView time;
    private TextView number;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2);
        start = (AutoCompleteTextView) findViewById(R.id.start_point);
        stop = (AutoCompleteTextView) findViewById(R.id.destination_point);
        space = (TextView) findViewById(R.id.textView);
        time = (TextView) findViewById(R.id.textView2);
        number = (TextView) findViewById(R.id.textView3);
        //String UserId=mAuth.getCurrentUser().getUid();
        df = FirebaseDatabase.getInstance().getReference().child("Rides");


    }
    public void bookRide(View v){
        df.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               // List<Rides> start = new ArrayList<>();
                for (DataSnapshot startSnapshot : snapshot.getChildren()) {
                   Rides ride=startSnapshot.getValue(Rides.class);
                   if(start.getText().toString().equals(ride.getStart())&&stop.getText().toString().equals(ride.getEnd())){
                       space.setText(ride.getQuantity());
                       time.setText(ride.getTme());
                       number.setText(ride.getPh());
                       break;
                   }
                }
                //Log.d("f", start.get(0).getStart());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}

