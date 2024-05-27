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
}
