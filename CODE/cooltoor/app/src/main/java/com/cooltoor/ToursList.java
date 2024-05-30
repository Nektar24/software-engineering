package com.cooltoor;

import java.util.*;
import java.io.*;

public class ToursList {
    private ArrayList<Tour> tours;

    public ToursList(ArrayList<Tour> tours){
        this.tours = tours;
    }

    public Tour getTour(String title){
        for(Tour tour : this.tours){
            if(tour.getTitle().equals(title)){
                return tour;
            }
        }
        return null;
    }
    
}
