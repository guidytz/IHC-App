package com.example.ihcapp.LocationApp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class GPSTracker implements LocationListener {

    Context context;
    LocationManager locationManager;

    public GPSTracker(Context ctx) {
        context = ctx;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
    @Override
    public void onProviderDisabled(String provider) {

    }

    public Location getLocation(){
         if(ContextCompat.checkSelfPermission(context,
            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
             Toast.makeText(context, "Permission denied!", Toast.LENGTH_LONG).show();
             return null;
         }

         locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
         boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
         if(isGPSEnabled) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return loc;
         } else {
            Toast.makeText(context, "Please enable GPS", Toast.LENGTH_LONG).show();
         }
         return null;
    }

    public void turnOffGPS() {
        if (locationManager != null) locationManager.removeUpdates(GPSTracker.this);
    }

}
