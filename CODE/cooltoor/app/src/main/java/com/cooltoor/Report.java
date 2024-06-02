package com.cooltoor;

import java.util.ArrayList;
import java.io.*;

public class Report {
    
    private User report_user;
    private HistoricPoint reported_historic_point;
    private String report_reason;
    private String report_text;

    public Report(User report_user, HistoricPoint reported_historic_point, String report_reason, String report_text) {
        this.report_user = report_user;
        this.reported_historic_point = reported_historic_point;
        this.report_reason = report_reason;
        this.report_text = report_text;
    }

    public User getUser() {
        return this.report_user;
    }

    public HistoricPoint getHistoricPoint() {
        return this.reported_historic_point;
    }

    public String getReason() {
        return this.report_reason;
    }

    public String getText() {
        return this.report_text;
    }

    public void storeInDatabase() {
        DatabaseManager dbm = new DatabaseManager();
        dbm.storeReport(this);
    }
}
