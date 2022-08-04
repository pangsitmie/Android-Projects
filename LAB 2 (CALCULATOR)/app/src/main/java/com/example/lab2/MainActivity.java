package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    TextView result;

    Button btn7, btn8, btn9, btnPlus;
    Button btn4, btn5, btn6, btnMin;
    Button btn1, btn2, btn3, btnMul;
    Button btnDot, btn0, btnAc, btnDiv, btnResult,btnDel;


    String operation ="";
    ArrayList<String> array;
    int idx;
    float finalRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        array = new ArrayList<String>();
        idx=0;
        finalRes=0;



//        btn0 = findViewById(R.id.btn0);
//        btn1 = findViewById(R.id.btn1);
//        btn2 = findViewById(R.id.btn2);
//        btn3 = findViewById(R.id.btn3);
//
//        btn4 = findViewById(R.id.btn4);
//        btn5 = findViewById(R.id.btn5);
//        btn6 = findViewById(R.id.btn6);
//        btn7 = findViewById(R.id.btn7);
//
//        btn8 = findViewById(R.id.btn8);
//        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMin = findViewById(R.id.btnMin);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDot = findViewById(R.id.btnDot);
        btnAc = findViewById(R.id.btnAc);
        btnDel = findViewById(R.id.btnDel);
        btnResult = findViewById(R.id.btnResult);






        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "+";
                array.add(result.getText().toString()) ;
                result.setText("");
                Log.d("TAG", "array ("+idx+"):" + array.get(idx));
                finalRes += Float.parseFloat(array.get(idx));
                idx++;

            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "-";
                array.add(result.getText().toString()) ;
                Log.d("TAG", "array ("+idx+"):" + array.get(idx));
                finalRes -= Float.parseFloat(array.get(idx));
                idx++;
                result.setText("");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "*";
                array.add(result.getText().toString()) ;
                Log.d("TAG", "array ("+idx+"):" + array.get(idx));
                finalRes = finalRes * Float.parseFloat(array.get(idx));
                idx++;
                result.setText("");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = "/";
                array.add(result.getText().toString()) ;
                Log.d("TAG", "array ("+idx+"):" + array.get(idx));
                finalRes = finalRes / Float.parseFloat(array.get(idx));
                idx++;
                result.setText("");
            }
        });

        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idx=0;
                finalRes=0;
                array.clear();
                result.setText("");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append(".");
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = result.getText().toString();
                result.setText(text.substring(0, text.length() - 1));
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array.add(result.getText().toString()) ;
                if(idx>0){
                    if(operation == "+")
                        finalRes +=Float.parseFloat(array.get(idx));
                    if(operation == "-")
                        finalRes -=Float.parseFloat(array.get(idx));
                    if(operation == "*")
                        finalRes = Float.parseFloat(array.get(idx-1)) * Float.parseFloat(array.get(idx));
                    if(operation == "/")
                        finalRes = Float.parseFloat(array.get(idx-1)) / Float.parseFloat(array.get(idx));
                }

                Log.d("TAG", "array ("+idx+"):" + array.get(idx));
                Log.d("FINAL", "result"+finalRes);
                result.setText(String.valueOf(finalRes));
                idx=0;
                finalRes=0;
                array.clear();

            }
        });
    }
    public void buttonPress(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                Log.d("TAG", "0");
                result.append("0");
                break;
            case R.id.btn1:
                Log.d("TAG", "1");
                result.append("1");
                break;
            case R.id.btn2:
                Log.d("TAG", "2");
                result.append("2");
                break;
            case R.id.btn3:
                Log.d("TAG", "3");
                result.append("3");
                break;
            case R.id.btn4:
                Log.d("TAG", "4");
                result.append("4");
                break;
            case R.id.btn5:
                Log.d("TAG", "5");
                result.append("5");
                break;
            case R.id.btn6:
                Log.d("TAG", "6");
                result.append("6");
                break;
            case R.id.btn7:
                Log.d("TAG", "7");
                result.append("7");
                break;
            case R.id.btn8:
                Log.d("TAG", "8");
                result.append("8");
                break;
            case R.id.btn9:
                Log.d("TAG", "9");
                result.append("9");
                break;
        }
    }
}