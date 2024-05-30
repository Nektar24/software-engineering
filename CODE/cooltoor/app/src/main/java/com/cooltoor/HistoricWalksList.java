package com.cooltoor;

import java.util.ArrayList;
import org.bson.Document;
import java.io.*;


public class HistoricWalksList {
    private ArrayList<HistoricWalk> historic_walks;

    public HistoricWalksList(ArrayList<HistoricWalk> historic_walks) {
        this.historic_walks = historic_walks;
    }

    public HistoricWalk getHistoricWalk(String title){
        for(HistoricWalk historic_walk : this.historic_walks){
            if(historic_walk.getTitle().equals(title)){
                return historic_walk;
            }
        }
        return null;
    }

    
}
