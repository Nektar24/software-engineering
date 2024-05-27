package com.cooltoor;
import java.util.ArrayList;

public class Tour{

    private String title;
    private String description;
    private String language;
    private ArrayList<HistoricPoint> tour_nodes;
    private float duration;
    private String date;
    private int seats;
    private int available_seats;
    private User tour_guide;

    public Tour(String title,String description,String language,ArrayList<HistoricPoint> tour_nodes,float duration,String date,int seats,int available_seats,User tour_guide){
            this.title=title;
            this.description=description;
            this.language=language;
            this.tour_nodes=tour_nodes;
            this.duration=duration;
            this.date=date;
            this.seats=seats;
            this.available_seats=available_seats;
            this.tour_guide=tour_guide;
    }

    
    public String getTitle() {
        return this.title;
    }

    
    public String getDescription() {
        return this.description;
    }

    
    public String getLanguage() {
        return this.language;
    }

    
    public float Duration() {
        return this.duration;
    }

    
    public String getDate() {
        return this.date;
    }

    
    public int getSeats() {
        return this.seats;
    }
    
    public int getAvailableSeats() {
        return this.available_seats;
    }

    public void updateAvailableSeats(int s){
        this.available_seats=this.available_seats-s;
    }
}