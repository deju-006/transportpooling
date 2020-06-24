package com.example.miniproject1234;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    int Request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == 100 || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // TODO: Grab an instance of FirebaseAuth
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v) {
        // TODO: Call attemptLogin() here
        attemptLogin();
    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, com.example.miniproject1234.registerActivity.class);
        finish();
        startActivity(intent);
    }

    // TODO: Complete the attemptLogin() method
    private void attemptLogin() {


        // TODO: Use FirebaseAuth to sign in with email & password
        final String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (email.equals("") || password.equals("")) {
            return;
        }

        Toast.makeText(this, "Login in progress...", Toast.LENGTH_LONG).show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("FlashChat", "signInWithEmail() onComplete:" + task.isSuccessful());

                if (!task.isSuccessful()) {
                    Log.d("FlashChat", "Problem signing in:" + task.getException());
                    showErrorDialog("There was a problem signing in");
                } else {
                    Intent intent = new Intent(MainActivity.this, secondActivity.class);
                    intent.putExtra("email", email);
                    startActivityForResult(intent, Request_code);
                }
            }
        });

    }

    // TODO: Show error on screen with an alert dialog
    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}
