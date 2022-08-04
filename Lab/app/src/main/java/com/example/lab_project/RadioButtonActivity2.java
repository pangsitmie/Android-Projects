package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RadioButtonActivity2 extends AppCompatActivity {

    float length, width, result;
    TextView lengthTV, widthTV, resultTV;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button2);

        resultTV = findViewById(R.id.resultTV);
        lengthTV = findViewById(R.id.lengthTV);
        widthTV = findViewById(R.id.widthTV);
        backBtn = findViewById(R.id.backBtn);

        Bundle bundle = getIntent().getExtras();
        length = bundle.getFloat("length");
        width = bundle.getFloat("width");
        String type = bundle.getString("type");

        Log.d("TAG", "radio2: length:"+length+ "width"+ width +"type:"+ type);



        switch(type){
            case "Rectangle":
                result = Rectangle(length,width);
                break;
            case "Triangle":
                result = Triangle(length,width);
                break;
            case "Circle":
                result =Circle(length);
                break;
        }
        Log.d("TAG", "Area of: "+type+": "+ result);
        resultTV.setText(String.valueOf(result));
        lengthTV.setText(String.valueOf(length));
        widthTV.setText(String.valueOf(width));




        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RadioButtonActivity.class);
                startActivity(intent);
            }
        });
    }

    float Triangle(float length, float width){
        float area = length * width /2;
        return area;
    }
    float Rectangle(float length, float width){
        float area = length * width;
        return area;
    }
    float Circle(float length){
        double area = Math.PI * length * length;
        return Float.parseFloat(String.valueOf(area));
    }

}