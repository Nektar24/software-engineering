package com.cooltoor;

import java.util.ArrayList;
import org.bson.Document;
/*
=======
import java.io.*;

>>>>>>> 99672186b791488703b683c2f58c7dd2464f4182
public class VisitingsHistory{
    
    private User visitings_history_user;
    private ArrayList<HistoricPoint> visited_historic_points;


    public VisitingsHistory(User visitings_history_user, ArrayList<HistoricPoint> visited_historic_points){
        this.visitings_history_user = visitings_history_user;
        this.visited_historic_points = visited_historic_points;
    }

    public VisitingsHistory(FindIterable<Document> visitings_history){

        ArrayList<String> interests = new ArrayList<String>();
        for(String str : visitings_history.getList("interests", String.class)){
            interests.add(str);
        }

        this.visitings_history_user = new User(visitings_history.get("user").getString("full_name"),
                                               visitings_history.get("user").getString("username"),
                                               visitings_history.get("user").getString("password"),
                                               visitings_history.get("user").getString("email"),
                                               visitings_history.get("user").getLong("phone_number"),
                                               visitings_history.get("user").getString("adress"),
                                               visitings_history.get("user").getString("country"),
                                               visitings_history.get("user").getString("birth_date"),
                                               interests);

        for(Document point : visitings_history.getList("visited_historic_points", Document.class)){
            historic_points.add(new HistoricPoint(point.getString("title"),
                                                  point.getString("text"),
                                                  point.getString("area"),

                                                  new Location(point.getList("location", Float.class)),
                                                  point.getString("date"),
                                                  point.getString("time")));
        } 

        this.visited_historic_points = new HistoricPointsList(visited_historic_points);;
    }

    public HistoricPoint getHistoricPoint(Location location){
        for(HistoricPoint point : this.visited_historic_points){
            if(point.getLocation().equals(location)){
                return point;
            }
        }
    }

    public void deleteHistoricPoint(ArrayList<Float> location){
        this.visited_historic_points.delete(location:location);
    }

    public void modifyInDatabase(){
        //TODO : modify in db
    }
}
*/