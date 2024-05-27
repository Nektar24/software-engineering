import java.util.ArrayList;

public class VisitingsHistory{
    
    private User visitings_history_user;
    private ArrayList<HistoricPoint> visited_historic_points;


    public VisitingsHistory(User visitings_history_user, ArrayList<HistoricPoint> visited_historic_points){
        this.visitings_history_user = visitings_history_user;
        this.visited_historic_points = visited_historic_points;
    }

    public VisitingsHistory(FindIterable<Document> visitings_history){
        
    }

    public HistoricPoint getHistoricPoint(ArrayList<Float> l){
        return this.visited_historic_points.get(location:l);
    }

    public void deleteHistoricPoint(ArrayList<Float> location){
        this.visited_historic_points.delete(location:location);
    }

    public void modifyInDatabase(){
        //TODO : modify in db
    }
}