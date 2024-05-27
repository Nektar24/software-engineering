public class Admin{
    private String expertise;
    private int admin_level;

    public Admin(String expertise,int admin_level){
        this.expertise=expertise;
        this.admin_level=admin_level;
    }

    public int getLevel(){
        return this.admin_level;
    }

    public String getExpertise(){
        return this.expertise;
    }
}