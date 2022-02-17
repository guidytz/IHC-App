package com.example.ihcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ihcapp.AccelerometerApp.AccelerometerMain;
import com.example.ihcapp.LocationApp.LocationApp;
import com.example.ihcapp.SensorsApp.Sensors;
import com.example.ihcapp.SumApp.SumApp;
import com.example.ihcapp.SwitchActivityApp.SwitchActivityMain;

public class MainActivity extends AppCompatActivity {

    Button sumApp;
    Button switchActApp;
    Button accelerometerApp;
    Button sensorsApp;
    Button locationApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumApp = findViewById(R.id.sum_app);
        sumApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sumApp_i = new Intent(MainActivity.this, SumApp.class);
                startActivity(sumApp_i);
            }
        });

        switchActApp = findViewById(R.id.switch_act);
        switchActApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchApp_i = new Intent(MainActivity.this, SwitchActivityMain.class);
                startActivity(switchApp_i);
            }
        });

        accelerometerApp = findViewById(R.id.acc_app);
        accelerometerApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accApp_i = new Intent(MainActivity.this, AccelerometerMain.class);
                startActivity(accApp_i);
            }
        });

        sensorsApp = findViewById(R.id.sensors_app);
        sensorsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sensorsApp_i = new Intent(MainActivity.this, Sensors.class);
                startActivity(sensorsApp_i);
            }
        });

        locationApp = findViewById(R.id.location_app);
        locationApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent locationApp_i = new Intent(MainActivity.this, LocationApp.class);
                startActivity(locationApp_i);
            }
        });
    }
}