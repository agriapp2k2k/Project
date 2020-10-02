package com.example.agriproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import static android.content.Context.LOCATION_SERVICE;

public class RegisterFragment extends Fragment {
    LocationManager manager;
    TextView tv;
    double lat, log;
    ImageView psign;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        tv = v.findViewById(R.id.loc);
        manager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat = location.getLatitude();
                log = location.getLongitude();
            }
        };
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, listener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, listener);
        tv.setText(lat+","+log);
        return v;
    }
}