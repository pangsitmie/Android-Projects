package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RadioButtonActivity3 extends AppCompatActivity {

    TextView tv;
    Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button3);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        tv = findViewById(R.id.tv1);
        tv.setText(title);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RadioButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}