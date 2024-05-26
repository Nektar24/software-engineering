public class Contribution{

    private String title;
    private String introductory_text;
    private String area;
    private String type;
    private ArrayList<File> photos;
    private ArrayList<File> sound_clips;
    private ArrayList<HistoricPoint> walk_nodes;
    private User contributor;

    public Contribution(String title, String introductory_text, String area, String type, ArrayList<File> photos, ArrayList<File> sound_clips, ArrayList<HistoricPoint> walk_nodes, User contributor) {
        this.title = title;
        this.introductory_text = introductory_text;
        this.area = area;
        this.type = type;
        this.photos = photos;
        this.sound_clips = sound_clips;
        this.walk_nodes = walk_nodes;
        this.contributor = contributor;
    }

}