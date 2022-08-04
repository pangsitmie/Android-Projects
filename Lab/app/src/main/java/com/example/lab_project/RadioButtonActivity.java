package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioButtonActivity extends AppCompatActivity {

    EditText lengthET, widthET;
    Button calculateBtn, listViewBtn;
    RadioGroup rg;
    RadioButton rb;

    float length, width;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        lengthET = findViewById(R.id.etWidth);
        widthET = findViewById(R.id.etHeight);

        calculateBtn = findViewById(R.id.calculateBtn);
        listViewBtn = findViewById(R.id.listViewBtn);

        rg = findViewById(R.id.rg);


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selectedId);

                length = Float.parseFloat(lengthET.getText().toString());
                width = Float.parseFloat(widthET.getText().toString());
                type = rb.getText().toString();
                Intent intent = new Intent(getApplicationContext(), RadioButtonActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("length",length);
                bundle.putFloat("width",width);
                bundle.putString("type", type);

                Log.d("TAG", "onClick: length:"+length+ "width"+ width +"type:"+ type);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        listViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListViewActivity2.class);
                startActivity(intent);
            }
        });


    }
}