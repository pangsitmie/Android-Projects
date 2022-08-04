package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int rand;

    private EditText startET, endET, countET;
    private Button randomBtn;
    private TextView resultTV;
    private Switch aSwitch;

    boolean switchState;


    public static ArrayList<Integer> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startET = findViewById(R.id.startET);
        endET = findViewById(R.id.endET);
        countET = findViewById(R.id.countET);

        randomBtn = findViewById(R.id.btnRandom);
        resultTV = findViewById(R.id.resultTV);
        aSwitch = findViewById(R.id.swRepeat);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    switchState = true;
                    Toast.makeText(getApplicationContext(), "on", Toast.LENGTH_SHORT).show();
                } else {
                    switchState = false;
                    Toast.makeText(getApplicationContext(), "off", Toast.LENGTH_SHORT).show();
                }
                Log.d("TAG", "switch State:" + switchState);
            }
        });

        //instantiate Random Class

        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.clear();
                resultTV.setText("");
                int start = Integer.parseInt(startET.getText().toString());
                int end = Integer.parseInt(endET.getText().toString());
                int count = Integer.parseInt(countET.getText().toString());

                if(count> end - start && switchState == true)
                {
                    Toast.makeText(getApplicationContext(), "Invalid Input! Count is out of range", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //pushing random integer to array list
                    if (switchState == true) {
                        for (int i = 0; i < count+1; i++) {
                            recursive(array, start, end);
                        }
                    }
                    else
                    {
                        for (int i = 0; i < count+1; i++) {
                            Random random = new Random();
                            rand = random.generateRandomInt(start, end);
                            array.add(rand);
                        }
                    }
                }


                //printing
                for(int i =0; i<array.size()-1;i++){
                    String randStr = String.valueOf(array.get(i));
                    resultTV.append(randStr + " ");
                }
            }
        });
    }

    public static boolean contains(final ArrayList<Integer> arr, final int key) {
        return arr.contains(key);
    }

    public void recursive(final ArrayList<Integer> arr, int start, int end){
        Random random = new Random();
        rand = random.generateRandomInt(start, end);
        boolean duplicate = contains(arr, rand);
        if(duplicate == true)
        {
            recursive(arr, start, end);
        }
        else
        {
            array.add(rand);
        }
    }
}