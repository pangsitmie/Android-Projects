package com.example.e_tuku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText emailtxt, passTxt;
    Button signInBtn, forgotPassBtn, signUpBtn, homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        emailtxt=findViewById(R.id.inputEmail);
        passTxt=findViewById(R.id.inputPassword);

        signInBtn=findViewById(R.id.SignInButton);
        forgotPassBtn=findViewById(R.id.ForgotPasswordButton);
        signUpBtn=findViewById(R.id.SignUpButton);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });



        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}