package edu.neu.madcourse.numad22summer_lipingding1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;

public class A6LocationActivity extends AppCompatActivity {

    private LocationManager locationManager;

    private static final String[] LOCATION_PERMISSIONS = new String[]{
            android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private double distance = 0;
    private Location lastLocation = null;

    private static final String KEY_DISTANCE = "distance";
    private static final int REQUEST_LOCATION = 0;

    private TextView tvPosition;
    private TextView tvDistance;
    private SeekBar seekBar;
    private Location originalLocation;
    private int resId = R.string.position_2;

    private static final String TAG = "LocationActivity";

    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            distance += originalLocation.distanceTo(location);
            lastLocation = location;
            updateLocationInfo(location);
//            for test
            Toast.makeText(A6LocationActivity.this, location.getLongitude() + " " +
                    location.getLatitude() + "", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "location change：" + location.getLongitude() + "   " + location.getLatitude());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        tvPosition = findViewById(R.id.tvPosition);
        tvDistance = findViewById(R.id.tvDistance);
        seekBar = findViewById(R.id.seekBar);
        Button btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                originalLocation = getLastKnownLocation();
                distance = 0;
                updateLocationInfo(originalLocation);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updatePrecision(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        getCurrentPosition();
        if (savedInstanceState != null) {
            distance = savedInstanceState.getDouble(KEY_DISTANCE);
            tvDistance.setText(getString(R.string.distance, distance));
        }
    }

    private void updatePrecision(int i) {
        switch (i) {
            case 1:
                resId = R.string.position_1;
                break;
            case 2:
                resId = R.string.position_2;
                break;
            case 3:
                resId = R.string.position_3;
                break;
            case 4:
                resId = R.string.position_4;
                break;
        }
        if (lastLocation != null) {
            updateLocationInfo(lastLocation);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(KEY_DISTANCE, distance);
    }


    private void updateLocationInfo(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        Log.d(TAG, "oldPos: " + originalLocation + "newPos" + location);
        tvPosition.setText(getString(resId, longitude, latitude));
        tvDistance.setText(getString(R.string.distance, distance));
    }

    private void getCurrentPosition() {
        // ask for permission
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(LOCATION_PERMISSIONS, REQUEST_LOCATION);
            }
            return;
        }
        Location location = getLastKnownLocation();
        originalLocation = location;
        if (location != null) {
            updateLocationInfo(location);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (hasLocationPermission()) {
                getCurrentPosition();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private boolean hasLocationPermission() {
        int result = ContextCompat.checkSelfPermission(this, LOCATION_PERMISSIONS[0]);
        return result == PackageManager.PERMISSION_GRANTED;
    }


    private Location getLastKnownLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(LOCATION_PERMISSIONS, REQUEST_LOCATION);
            }
            return null;
        }
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
            locationManager.requestLocationUpdates(provider, 20, 0, locationListener);
        }
        return bestLocation;
    }
}
