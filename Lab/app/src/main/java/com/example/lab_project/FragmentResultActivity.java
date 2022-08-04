package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentResultActivity extends AppCompatActivity {
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_result);

        Bundle bundle = getIntent().getExtras();
        int key = bundle.getInt("key");
        key++;
        String title = "Key from fragment " + key;

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);

        textView.setText(title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FragmentActivity.class);
                startActivity(intent);
            }
        });

    }
}