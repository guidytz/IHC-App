package com.example.ihcapp.LocationApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.ihcapp.R;

public class LocationApp extends AppCompatActivity {

    GPSTracker gps;

    Button gpsButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        gpsButton = findViewById(R.id.gps_button);

        if(ContextCompat.checkSelfPermission(LocationApp.this,
            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(LocationApp.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        }
        gps = new GPSTracker(getApplicationContext());

        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location loc = gps.getLocation();
                if (loc != null) {
                    double lat = loc.getLatitude();
                    double lon = loc.getLongitude();
                    Toast.makeText(getApplicationContext(), "Lat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        gps.turnOffGPS();
    }


}