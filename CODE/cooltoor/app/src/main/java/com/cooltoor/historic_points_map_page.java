package com.cooltoor;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.MapView;

public class historic_points_map_page extends AppCompatActivity {

    private Map map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historic_points_map_page);

        MapView mapView = MapManager.requestMap(this);  // Request MapView from MapManager
        map = new Map(this, mapView);                   // Create Map instance with MapView
        FrameLayout mapContainer = findViewById(R.id.map_container);
        mapContainer.addView(map);                      // Add Map to the container in the layout

        map.onCreate(savedInstanceState);
        map.getMapAsync(googleMap -> {
            // Additional setup for GoogleMap
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }
}
