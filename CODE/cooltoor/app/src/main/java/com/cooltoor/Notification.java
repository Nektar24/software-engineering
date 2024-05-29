package com.cooltoor;

public class Notification{

    private User notification_user;
    private String title;
    private String text;
    private String date;

    public Notification(User notification_user,String title,String text,String date){

        this.notification_user=notification_user;
        this.title=title;
        this.text=text;
        this.date=date;
    }

    public void storeInDatabase(){
        DatabaseManager dbm = new DatabaseManager();
        dbm.storeNotification(this);
    }
}