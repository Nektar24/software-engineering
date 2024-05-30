package com.cooltoor;

import java.util.ArrayList;

public class HistoricPointsList {
    private ArrayList<HistoricPoint> historic_points;

    public HistoricPointsList(ArrayList<HistoricPoint> historic_points){
        this.historic_points = historic_points;
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
}
