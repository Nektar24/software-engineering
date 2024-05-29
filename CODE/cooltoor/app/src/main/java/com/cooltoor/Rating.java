package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class Rating{

    private User rating_user;
    private HistoricPoint rating_historic_point;
    private int stars;
    private String comment;

    public Rating(User rating_user,HistoricPoint rating_historic_point,int stars,String comment){

            this.rating_user=rating_user;
            this.rating_historic_point=rating_historic_point;
            this.stars=stars;
            this.comment=comment;
    }

    public void storeInDatabase(){
        DatabaseManager dbm = new DatabaseManager();
        dbm.storeRating(this);
    }

    public void modifyInDatabase(){
        DatabaseManager dbm = new DatabaseManager();
        dbm.modifyRating(this);
    }

    public void setStars(int stars){
        this.stars=stars;
    }

    public void setComment(String comment){
        this.comment=comment;
    }
}
