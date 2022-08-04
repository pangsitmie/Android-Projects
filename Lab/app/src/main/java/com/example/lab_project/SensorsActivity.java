package com.example.lab_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

public class SensorsActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private Sensor accSensor, gyroSensor, lightSensor;
    TextView tvAcc, tvGyro, tvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        tvAcc = findViewById(R.id.tvAcc);
        tvGyro = findViewById(R.id.tvGyro);
        tvLight = findViewById(R.id.tvLight);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        lightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        //        TABHOST
        final TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec TS;
        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab1);
        TS.setIndicator("Accelerometer");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab2);
        TS.setIndicator("Gyroscope");
        tabHost.addTab(TS);

        TS = tabHost.newTabSpec("");
        TS.setContent(R.id.tab3);
        TS.setIndicator("Light Sensor");
        tabHost.addTab(TS);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(accSensorListener, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(gyroSensorListener, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(lightSensorListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(accSensorListener);
        mSensorManager.unregisterListener(gyroSensorListener);
        mSensorManager.unregisterListener(lightSensorListener);
    }

    //acSensor Listener
    SensorEventListener accSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            Sensor sensor = sensorEvent.sensor;
            String sensorName = String.valueOf(sensor.getName());
            String sensorType = String.valueOf(sensor.getType());
            String sensorPower = String.valueOf(sensor.getPower());


            String value0 = String.valueOf(sensorEvent.values[0]);
            String value1 = String.valueOf(sensorEvent.values[1]);
            String value2 = String.valueOf(sensorEvent.values[2]);

            String display = "Sensor name: " +sensorName +
                            "\nSensor type: " + sensorType +
                            "\nUsed power: "+ sensorPower+
                            "\nval[0]"+ value0 +
                            "\nval[1]"+ value1 +
                            "\nval[2]"+ value2;
            tvAcc.setText(display);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
//            Do Nothing
        }
    };

    //acSensor Listener
    SensorEventListener gyroSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            Sensor sensor = sensorEvent.sensor;
            String sensorName = String.valueOf(sensor.getName());
            String sensorType = String.valueOf(sensor.getType());
            String sensorPower = String.valueOf(sensor.getPower());


            String value0 = String.valueOf(sensorEvent.values[0]);
            String value1 = String.valueOf(sensorEvent.values[1]);
            String value2 = String.valueOf(sensorEvent.values[2]);

            String display = "Sensor name: " +sensorName +
                    "\nSensor type: " + sensorType +
                    "\nUsed power: "+ sensorPower+
                    "\nval[0]"+ value0 +
                    "\nval[1]"+ value1 +
                    "\nval[2]"+ value2;
            tvGyro.setText(display);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
//            Do Nothing
        }
    };

    //acSensor Listener
    SensorEventListener lightSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            Sensor sensor = sensorEvent.sensor;
            String sensorName = String.valueOf(sensor.getName());
            String sensorType = String.valueOf(sensor.getType());
            String sensorPower = String.valueOf(sensor.getPower());


            String value0 = String.valueOf(sensorEvent.values[0]);


            String display = "Sensor name: " +sensorName +
                    "\nSensor type: " + sensorType +
                    "\nUsed power: "+ sensorPower+
                    "\nval[0]"+ value0;

            tvLight.setText(display);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
//            Do Nothing
        }
    };
}