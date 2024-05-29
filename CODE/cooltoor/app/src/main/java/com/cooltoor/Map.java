package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class Map {
    MapView map;

    public Map(){
        this.map = new MapView();
    }

    public Map(Location){
        this.map = new MapView(Location);
    }

    public void addHistoricPoints(HistoricPointsList historic_points){
        
    }

    public void addNavigationInstructions(NavigationInstructions instructions){
        
    }
}
