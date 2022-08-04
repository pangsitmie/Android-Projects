package com.example.e_tuku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText inputName, inputPhoneNumber,inputEmail,inputPassword;
    Button registerBtn, signInButton;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //DECLARE VARIABLE
        inputName = findViewById(R.id.inputName);
        inputPhoneNumber = findViewById(R.id.inputTelephone);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        registerBtn=findViewById(R.id.RegisterButton);
        signInButton=findViewById(R.id.SignInButton);
        //DECLARE DATABASE REFERENCE
        reff= FirebaseDatabase.getInstance().getReference().child("Member");

        
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String phoneNumber = inputPhoneNumber.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Toast.makeText(SignUpActivity.this, name+phoneNumber+email+password, Toast.LENGTH_SHORT).show();
                User user = new User(name,phoneNumber,email,password);

                reff.child("db_"+name).setValue(user);
                Toast.makeText(SignUpActivity.this, "Push database successful", Toast.LENGTH_SHORT).show();
            }
        });

        
       
    }
}