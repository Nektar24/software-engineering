import java.util.ArrayList;

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


    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.introductory_text;
    }

    public ArrayList<File> getMultimedia() {
        return this.photos;
    }

    public String getType() {
        return this.type;
    }

    public User getContributor() {
        return this.contributor;
    }

    public void addSoundClip(File sound_clip) {
        this.sound_clips.add(sound_clip);
    }

    public void addPoint(HistoricPoint historic_point) {
        this.walk_nodes.add(historic_point);
    }

    public void deletePoint(HistoricPoint historic_point) {
        for (int i=0; i<this.walk_nodes.size(); i++) {
            if(this.walk_nodes.get(i).equals(historic_point)) {
                this.walk_nodes.remove(i);
            }
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.introductory_text = text;
    }

}