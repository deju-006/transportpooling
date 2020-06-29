package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class bookedActivity extends AppCompatActivity {

    private DatabaseReference bookedDatabase;
    FirebaseAuth mAuth;
    private TextView start,end,quantity,phone,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        start=findViewById(R.id.booked_start);
        end=findViewById(R.id.booked_end);
        quantity=findViewById(R.id.booked_quantity);
        phone=findViewById(R.id.booked_phone);
        price = findViewById(R.id.booked_price);
        mAuth=FirebaseAuth.getInstance();
        String userId=mAuth.getCurrentUser().getUid();
        bookedDatabase= FirebaseDatabase.getInstance().getReference().child("Booked").child(userId);
        bookedDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    Rides ride=snapshot.getValue(Rides.class);
                    start.setText("Starting Point: "+ride.getStart());
                    end.setText("Ending Point: "+ride.getEnd());
                    quantity.setText("Quantity: "+ride.getQuantity());
                    phone.setText("Phone Number : "+ride.getPh());
                    price.setText("Price : "+ride.getPrice());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}