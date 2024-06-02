package com.cooltoor;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class home_menu_page extends AppCompatActivity {

    private UserLocationManager userlocationManager;
    private Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_menu_page);

        userlocationManager = new UserLocationManager(this);

        // Visit Historic Point Button
        Button button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SEQUENCE 1 - ARROW 1 visitHistoricPoint()
                visitHistoricPoint();
            }
        });
    }

    public void show(HistoricPointsList historic_points_in_the_area){
        Intent intent;
        if (historic_points_in_the_area.size() != 0){
            intent=new Intent(this,error_page.class);
        } else {
            intent=new Intent(this,historic_points_map_page.class);
            Bundle b = new Bundle();
            intent.putExtras(b);
        }
        startActivity(intent);
    }


    public void visitHistoricPoint(){
        requestUserLocation(); // request location from UserLocationManager (is a function in page because it keeps requesting if location changes
        map = MapManager.requestMap(this);  // Request Map from MapManager

        // SEQUENCE 1 - ARROW 6 fetchHistoricPointsInArea()

        // get from database manager
        String jsonString = null;

        // SEQUENCE 1 - ARROW 7 create new instance of HistoricPointsList called historic_points_in_the_area
        HistoricPointsList historic_points_in_the_area = new HistoricPointsList(jsonString);

        show(historic_points_in_the_area);

    }

    private void requestUserLocation() {
        // SEQUENCE 1 - ARROW 2 requestUserLocation()
        userlocationManager.requestUserLocation(this, new UserLocationManager.OnLocationReceivedListener() {
            @Override
            public void onLocationReceived(com.cooltoor.Location user_location) {
                // Got user Location
                ArrayList<Float> location = user_location.getLocation();
                System.out.println("User Location: Latitude = " + location.get(0) + ", Longitude = " + location.get(1));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, request location again
                requestUserLocation();
            } else {
                // Permission denied
            }
        }
    }

    public void goBack(View view){
        // Not yet implemented code
    }



}