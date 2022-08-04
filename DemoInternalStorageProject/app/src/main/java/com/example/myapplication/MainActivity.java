package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnRead;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        text = findViewById(R.id.text);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean success = saveFile();
                if (success)
                    text.setText("File saved!");
                else
                    text.setText("File save failed!");
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean success = readFile();
                if (!success)
                    text.setText("File read failed!");
            }
        });
    }


    private boolean saveFile(){
        String data = "Hello, Internal\nThis is From Leonchen data";

        FileOutputStream fos;
        try {
            fos = openFileOutput("internal.txt", MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private Boolean readFile(){
        FileInputStream fis;

        try {
            fis = openFileInput("internal.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;
            text.setText("");

            while((line = br.readLine()) != null){
                text.append(line +"\n");
            }
            br.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}