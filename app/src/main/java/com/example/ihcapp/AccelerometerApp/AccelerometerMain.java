package com.example.ihcapp.AccelerometerApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ihcapp.R;

import java.text.MessageFormat;
import java.util.Objects;

public class AccelerometerMain extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static final float THRESHOLD = 11;

    TextView coordX;
    TextView coordY;
    TextView coordZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        coordX = findViewById(R.id.value_x);
        coordY = findViewById(R.id.value_y);
        coordZ = findViewById(R.id.value_z);

        Objects.requireNonNull(getSupportActionBar()).setTitle("IHC App - Acelerômetro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            coordX.setText(MessageFormat.format("x: {0}", sensorX));
            coordY.setText(MessageFormat.format("y: {0}", sensorY));
            coordZ.setText(MessageFormat.format("z: {0}", sensorZ));

            if (sensorX > THRESHOLD || sensorY > THRESHOLD || sensorZ > THRESHOLD)
                showNewActivity();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showNewActivity() {
        Intent accel2_i = new Intent(AccelerometerMain.this, Accelerometer2.class);
        startActivity(accel2_i);
    }
}