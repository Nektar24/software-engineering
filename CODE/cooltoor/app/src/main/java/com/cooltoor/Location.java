package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class Location {
    private float lat;
    private float lon;
    String city;
    
    public Location(float lat,float lon){

        this.lat=lat;
        this.lon=lon;
    }

    public String getCity(){
        return this.city;
    }

    public void updateLocation(ArrayList<Float> location){
        this.lat = location.get(0);
        this.lon = location.get(1);
    }

    public ArrayList<Float> getLocation(){
        ArrayList<Float> l = new ArrayList<Float>();
        l.add(this.lat);
        l.add(this.lon);
        return l;
    }

}
