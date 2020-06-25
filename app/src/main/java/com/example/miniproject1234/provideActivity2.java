package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class provideActivity2 extends AppCompatActivity {
    private AutoCompleteTextView startpoint;
    private AutoCompleteTextView Destination;
    private AutoCompleteTextView amount;
    private AutoCompleteTextView cost;
    private Button save;
    private EditText time;
    private FirebaseAuth mAuth;
    private DatabaseReference mRideDatabase;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide2);
        startpoint = (AutoCompleteTextView) findViewById(R.id.start_point);
        Destination = (AutoCompleteTextView) findViewById(R.id.destination_point);
        amount = (AutoCompleteTextView) findViewById(R.id.amount_bags);
        cost = (AutoCompleteTextView) findViewById(R.id.cost_rs);
        date=(EditText) findViewById((R.id.editTextDate));
        time = (EditText) findViewById(R.id.editTextTime);

        save = (Button) findViewById(R.id.search);

        mRideDatabase = FirebaseDatabase.getInstance().getReference().child("Rides");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String start = startpoint.getText().toString();
                final String end = Destination.getText().toString();
                final String quantity = amount.getText().toString();
                final String price = cost.getText().toString();
                final String dat=date.getText().toString();
                final String tme = time.getText().toString();

                mAuth = FirebaseAuth.getInstance();
                Rides r = new Rides(start, end, quantity, price, dat,tme);
                mRideDatabase.child(mAuth.getCurrentUser().getUid()).setValue(r).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "uploded successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Unsuccesfull ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }
}

