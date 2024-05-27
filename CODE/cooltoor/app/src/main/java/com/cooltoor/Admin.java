import java.util.ArrayList;

public class Admin extends User{
    private String expertise;
    private int admin_level;

    public Admin(String full_name, String username, String password, String email, long phone_number, String address, String country, String birth_date, ArrayList<String> interests, String expertise, int admin_level) {
       super(String full_name, String username, String password, String email, long  phone_number, String address, String country, String birth_date, ArrayList<String> interests);
        this.expertise = expertise;
        this.admin_level = admin_level;
    }

    public int getLevel(){
        return this.admin_level;
    }

    public String getExpertise(){
        return this.expertise;
    }
}