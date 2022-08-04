package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MoveImageActivity extends AppCompatActivity {
    DisplayMetrics metrics;
    ImageView img;

    //sensors
    private SensorManager mSensorManager;
    private Sensor mSensor;

    //variable
    float X;
    float Y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_image);
        img = findViewById(R.id.img);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        View view = getWindow().getDecorView();
        int uiOptions = ViewStub.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(uiOptions);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        Log.d("Metrics", height+"  "+width);



        view.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        // Layout has happened here.

                        X = img.getX();
                        Y = img.getY();

                        Log.d("XY", X+"  "+Y);
                        // Don't forget to remove your listener when you are done with it.
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorListener);
    }
    SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            Sensor sensor = sensorEvent.sensor;
//            String sensorName = String.valueOf(sensor.getName());
//            String sensorType = String.valueOf(sensor.getType());
//            String sensorPower = String.valueOf(sensor.getPower());

            X -= (int) sensorEvent.values[0];
            Y += (int) sensorEvent.values[1];

            img.setX(X);
            img.setY(Y);

            Log.d("TAG", "XY sensor: "+X+"\t"+Y);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
//            Do Nothing
        }
    };
}