package com.example.lab1ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RatingBar ratingBar;
    private TextView textView;
    float rate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        everytime button is pressed add the rating bar value by 1
//        use setOnRatingBarChangeListener to display the value on text view in real time

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        rate = ratingBar.getRating();


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate = ratingBar.getRating();
                textView.setText(String.valueOf(rating));
                Log.d("TAG", String.valueOf(rating));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate += 1f;
                ratingBar.setRating(rate);
                Toast.makeText(getApplicationContext(), String.valueOf(rate), Toast.LENGTH_SHORT).show();

            }
        });

    }
}