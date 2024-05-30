package com.cooltoor;
/*
import org.bson.Document;
import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.io.*;

public class ContributionsList {
    
    private ArrayList<Contribution> contributions;

    public ContributionsList(FindIterable<Document> cursor) {
        for(Document doc : cursor){
            String title = doc.getString("title");
            String text = doc.getString("introductory_text");
            String area = doc.getString("area");
            Location location = new Location(doc.get("location").getDouble("lat"));
        }
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
*/