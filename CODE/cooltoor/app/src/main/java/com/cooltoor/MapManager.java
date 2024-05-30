package com.cooltoor;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapManager {

    private static final String TAG = "MapManager";

    public static MapView requestMap(Context context) {
        MapView mapView = new MapView(context);

        // Initialize the MapView
        try {
            MapsInitializer.initialize(context);
        } catch (Exception e) {
            Log.e(TAG, "MapsInitializer failed: " + e.getMessage());
        }

        mapView.onCreate(null);
        mapView.onResume(); // Needed to get the map to display immediately

        return mapView;
    }
}