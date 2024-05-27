public class HistoricPoint {
    private String title;
    private String introductory_text;
    private String area;
    private ArrayList<File> photos;
    private Location location;
    private User contributor;
    private User approved_by;

    public HistoricPoint(String title, String introductory_text, String area, ArrayList<File> photos, Location location, User contributor, User approved_by) {
        this.title = title;
        this.introductory_text = introductory_text;
        this.area = area;
        this.photos = photos;
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

    public ArrayList<File> getMultimedia() {
        return this.photos;
    }

    public Location getPointCoordinates(){
        return this.location;
    }

    public ArrayList<Report> getReports(){
        //TODO : speak to db and get reports
        return null;
    }

    public User getContributor() {
        return this.contributor;
    }

    public void storeInDatabase(){
        //TODO : store in db
    }
}
