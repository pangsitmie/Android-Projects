package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Button saveBtn, readBtn;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button)findViewById(R.id.save);
        readBtn = (Button)findViewById(R.id.read);
        msg = (TextView)findViewById(R.id.msg);



        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePref();
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readPref();
            }
        });
    }

    private void savePref(){
        preferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        editor = preferences.edit();

        editor.putString("user", "a");
        editor.putInt("level", 100);
        editor.putInt("highScore", 10000);
        editor.putBoolean("darkTheme", true);
        editor.commit();
        Toast.makeText(this, "Preference Saved", Toast.LENGTH_SHORT).show();
    }
    private void readPref(){
        preferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);

        String user = preferences.getString("user", "anonymous");
        int level = preferences.getInt("level", 0);
        int highScore = preferences.getInt("high score", 0);
        Boolean darkTheme = preferences.getBoolean("darkTheme", false);

        msg.setText(user + ", "+ level + ", "+ highScore + ", "+ darkTheme );
    }
}