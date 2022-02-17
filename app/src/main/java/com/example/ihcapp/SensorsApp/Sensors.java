package com.example.ihcapp.SensorsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.text.MessageFormat;

public class Sensors extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLight;
    private Sensor mGyroscope;

    TextView lightText;
    TextView gyroX;
    TextView gyroY;
    TextView gyroZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        lightText = findViewById(R.id.light);
        gyroX = findViewById(R.id.gyro_x);
        gyroY = findViewById(R.id.gyro_y);
        gyroZ = findViewById(R.id.gyro_z);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener((SensorEventListener) this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_LIGHT:
                updateLight(event);
                break;
            case Sensor.TYPE_GYROSCOPE:
                updateGyro(event);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void updateLight(SensorEvent event) {
        lightText.setText(MessageFormat.format("Light: {0}", event.values[0]));
    }

    public void updateGyro(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        gyroX.setText(MessageFormat.format("x: {0, number, #.##}", x));
        gyroY.setText(MessageFormat.format("y: {0, number, #.##}", y));
        gyroZ.setText(MessageFormat.format("z: {0, number, #.##}", z));
    }
}