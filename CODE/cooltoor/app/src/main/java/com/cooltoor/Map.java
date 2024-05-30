package com.cooltoor;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Map extends FrameLayout implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;

    public Map(@NonNull Context context) {
        super(context);
        initialize(context);
    }

    public Map(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public Map(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        mapView = new MapView(context);
        addView(mapView);

        // Initialize the MapView
        try {
            MapsInitializer.initialize(context);
        } catch (Exception e) {
            Log.e("Map", "MapsInitializer failed: " + e.getMessage());
        }

        mapView.onCreate(null);
        mapView.onResume(); // Needed to get the map to display immediately
        mapView.getMapAsync(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);
    }

    public void onResume() {
        mapView.onResume();
    }

    public void onPause() {
        mapView.onPause();
    }

    public void onDestroy() {
        mapView.onDestroy();
    }

    public void onLowMemory() {
        mapView.onLowMemory();
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        mapView.getMapAsync(callback);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        // Additional setup for GoogleMap if needed
    }

    public GoogleMap getGoogleMap() {
        return googleMap;
    }
}
