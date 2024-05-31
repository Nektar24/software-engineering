package com.cooltoor;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

public class MapManager {

    public static Map requestMap(Context context) {
        MapView mapView = new MapView(context);

        // Initialize the MapView
        try {
            MapsInitializer.initialize(context);
        } catch (Exception e) {
            Log.e("MapManager", "MapsInitializer failed: " + e.getMessage());
        }

        mapView.onCreate(null);
        mapView.onResume(); // Needed to get the map to display immediately

        // SEQUENCE 1 - ARROW 5 create Map instance called area_map
        Map area_map = new Map(context, mapView);

        return area_map;
    }
}