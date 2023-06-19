package com.example.helpfromhomeproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    // Declare variables
    Button register;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    TextView username;
    TextView password_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Find views by their IDs
        register = findViewById(R.id.reg);
        username = findViewById(R.id.email);
        password_text = findViewById(R.id.password);

        // Check if register button is not null before setting OnClickListener
        if(register != null) {
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get email and password from EditText fields
                    String email, password;
                    email = String.valueOf(username.getText());
                    password = String.valueOf(password_text.getText());

                    // Check if email and password fields are not empty
                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Create new user with email and password
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If registration is successful, show toast message and start MainActivity
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Register.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    // If registration fails, show toast message
                                    else {
                                        Toast.makeText(Register.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            });
        }
    }
}






