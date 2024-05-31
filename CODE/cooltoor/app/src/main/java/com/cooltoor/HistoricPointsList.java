package com.cooltoor;

import java.util.ArrayList;

public class HistoricPointsList {
    private ArrayList<HistoricPoint> historic_points;

    public HistoricPointsList(String jsonString){
        int I = 10;
        for (int i = 0 ; i < I ; i++){
            this.historic_points.add(new HistoricPoint());
        }
    }

    public HistoricPoint getHistoricPoint(Location location){
        for(HistoricPoint historic_point : this.historic_points){
            if(historic_point.getPointCoordinates().equals(location)){
                return historic_point;
            }
        }
        return null;
    }

    public ArrayList<HistoricPoint> filterBasedOnSearch(String search){
        ArrayList<HistoricPoint> filtered_points = new ArrayList<>();

        for(HistoricPoint historic_point : this.historic_points){
            if(historic_point.getTitle().contains(search) || historic_point.getText().contains(search)){
                filtered_points.add(historic_point);
            }
        }
        return filtered_points;
    }

    public int size() {
        return this.historic_points.size();
    }
}
