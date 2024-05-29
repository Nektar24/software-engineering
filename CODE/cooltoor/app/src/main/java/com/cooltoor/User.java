package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class User{

    private String full_name;
    private String username;
    private String password;
    private String email;
    private long phone_number; 
    private String address;
    private String country;
    private String birth_date;
    private ArrayList<String> interests;

    public User(String full_name, String username, String password, String email, long phone_number, String address, String country, String birth_date, ArrayList<String> interests) {
        this.full_name = full_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.country = country;
        this.birth_date = birth_date;
        this.interests = interests;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhoneNumber() {
        return this.phone_number;
    }


}