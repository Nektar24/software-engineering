package com.cooltoor;

import java.util.ArrayList;
import org.bson.Document;

import java.util.*;
import java.io.*;

public class VisitingsHistory{
    
    private User visitings_history_user;
    private ArrayList<HistoricPoint> visited_historic_points;

    public VisitingsHistory(User visitings_history_user, ArrayList<HistoricPoint> visited_historic_points){
        this.visitings_history_user = visitings_history_user;
        this.visited_historic_points = visited_historic_points;
    }

    public HistoricPoint getHistoricPoint(Location location){
        for(HistoricPoint point : this.visited_historic_points){
            if(point.getPointCoordinates().equals(location)){
                return point;
            }
        }
        return null;
    }

    public void deleteHistoricPoint(Location location){
        for(int i=0; i<this.visited_historic_points.size(); i++){
            if(this.visited_historic_points.get(i).getPointCoordinates().equals(location)){
                this.visited_historic_points.remove(i);
                break;
            }
        }
    }

    public void modifyInDatabase(){
        /*DatabaseManager dbm = new DatabaseManager();
        dbm.modifyVisitingsHistory(this);*/
    }
}