package com.cooltoor;

import org.bson.Document;
import java.util.ArrayList;
import java.io.*;

public class ContributionsList {
    
    private ArrayList<Contribution> contributions;

    public ContributionsList(ArrayList<Contribution> contributions) {
        this.contributions = contributions;
    }

    public Contribution getContribution(String title){
        for(Contribution contribution : contributions){
            if(contribution.getTitle().equals(title)){
                return contribution;
            }
        }

        return null;
    }
}
