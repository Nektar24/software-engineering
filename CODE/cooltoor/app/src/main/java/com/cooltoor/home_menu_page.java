package com.cooltoor;

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

    public void show(){

    }


    public void visitHistoricPoint(){
        requestUserLocation();
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

    }



}