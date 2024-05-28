package com.cooltoor;

//import com.mongodb.client.FindIterable;
import org.bson.Document;
import java.util.ArrayList;

public class HistoricPoint {
    private String title;
    private String introductory_text;
    private String area;
    //private ArrayList<File> photos;
    private Location location;
    private User contributor;
    private User approved_by;

    public HistoricPoint(String title, String introductory_text, String area /*,ArrayList<File> photos*/, Location location, User contributor, User approved_by) {
        this.title = title;
        this.introductory_text = introductory_text;
        this.area = area;
        //this.photos = photos;
        this.location = location;
        this.contributor = contributor;
        this.approved_by = approved_by;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.introductory_text;
    }
    /*
    public ArrayList<File> getMultimedia() {
        return this.photos;
    }
    */
    public Location getPointCoordinates(){
        return this.location;
    }
    /*
    public ArrayList<Report> getReports(){
        DatabaseManager dbm = new DatabaseManager();
        FindIterable<Document> results = new FindIterable<Document>();
        results = dbm.fetchHistoricPointReports(this);

        ArrayList<Report> reports = new ArrayList<Report>();
        for (Document doc : results) {
            reports.add(new Report(doc.get("report_user"), doc.get("report_reason"), doc.get("report_text")));
        }

        return reports;
    }
    */
    public User getContributor() {
        return this.contributor;
    }
    /*
    public void deleteFromDatabase(){
        DatabaseManager dbm = new DatabaseManager();
        dbm.deleteHistoricPoint(this);
    }

    public void deleteRepors(Report report){
        DatabaseManager dbm = new DatabaseManager();
        dbm.deleteHistoricPointReports(this);
    }

    public void addMultimedia(ArrayList<File> multimedia){
        for(File file : multimedia){
            this.photos.add(file);
        }
    }

    public void storeInDatabase(){
        DatabaseManager dbm = new DatabaseManager();
        dbm.storeHistoricPoint(this);
    }
    */
}
