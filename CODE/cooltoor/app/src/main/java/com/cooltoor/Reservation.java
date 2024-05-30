package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class Reservation{

    private Tour tour;
    private User reservation_user;
    private int seats;

    public Reservation(Tour tour,User reservation_user,int seats){
        this.tour = tour;
        this.reservation_user = reservation_user;
        this.seats = seats;
    }

    public void storeInDatabase(){
        //DatabaseManager dbm = new DatabaseManager();
        //dbm.storeNotification(this);
    }
}
