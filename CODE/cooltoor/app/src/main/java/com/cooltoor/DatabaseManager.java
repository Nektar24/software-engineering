package com.cooltoor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import java.util.ArrayList;
import java.io.*;

public class DatabaseManager{
    private MongoClient mongoClient;
    private MongoDatabase database;

    public DatabaseManager(String connectionString, String dbName) {
        this.mongoClient = MongoClients.create(connectionString);
        this.database = mongoClient.getDatabase(dbName);
    }

    public FindIterable<Document> fetchHistoricPoints(){
        MongoCollection<Document> collection = database.getCollection("HistoricPoint");
        return collection.find();
    }

    public void storeHistoricPoint(HistoricPoint historic_point){
        MongoCollection<Document> collection = database.getCollection("HistoricPoint");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(historic_point);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

    public FindIterable<Document> fetchVisitingsHistory(User user){
        MongoCollection<Document> collection = database.getCollection("VisitingsHistory");
        return collection.find({username: user.getUsername()});
    }

    public FindIterable<Document> fetchRating(User user, HistoricPoint historic_point){

    }

    public void storeRating(Rating rating){
        MongoCollection<Document> collection = database.getCollection("Rating");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(rating);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

    public void modifyRating(Rating rating, int stars, String comment){
        MongoCollection<Document> collection = database.getCollection("Rating");
        collection.updateOne({username: rating.getUsername()}, {$set: {stars: stars, comment: comment}} );
    }

    public void modifyVisitingsHistory(VisitingsHistory visitings_history) {
        MongoCollection<Document> collection = database.getCollection("VisitinsHistory");

        collection.updateOne({username: visitings_history.getUsername()}, {$set: {visited_historic_points: visitings_history.getHistoricPoints()}})
    }

    public ArrayList<String> fetchCitiesWithContributions() {
        MongoCollection<Document> collection = database.getCollection("Contribution");

        FindIterable<Document> contributions = database.find();

        ArrayList<String> cities = new ArrayList<>();
        for(Document doc:contributions) {
            cities.add(doc.getString("area"));
        }

        return cities;
    }

    publlic FindIterable<Document> fetchContributions() {
        MongoCollection<Document> collection = database.getCollection("Contribution");

        return collection.find();
    }

    public void storeHistoricWalk(HistoricWalk historic_walk) {
        MongoCollection<Document> collection = database.getCollection("HistoricWalk");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(historic_walk);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

    public void storeNotification(Notification notification) {
        MongoCollection<Document> collection = database.getCollection("Notification");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(notification);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

    public FindIterable<Document> fetchTours() {
        MongoCollection<Document> collection = database.getCollection("Tour");

        return collection.find();
    }

    public void storeReservation(Reservation reservation) {
        MongoCollection<Document> collection = database.getCollection("Reservation");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(reservation);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    } 

    public void updateTourAvailableSeats(Tour tour, int seats) {
        MongoCollection<Document> collection = database.getCollection("Tour");

        collection.updateOne({title: rating.getTitle()}, {$set: {avilable_seats: tour.getAvailableSeats()-seats}} );
    }

    public FindIterable<Document> fetchHistoricPointsWithReports() {
        MongoCollection<Document> collection = database.getCollection("Report");

        return collection.find();
    }

    public FindIterable<Docuemnt> fetchHistoricPointReports(HistoricPoint historic_point) {
        MongoCollection<Document> collection = database.getCollection("Report");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(historic_point);
        Document document = Document.parse(jsonString);
        return collection.find({reported_historic_point: document});
    }

    public void deleteHistoricPointReports(HistoricPoint historic_point) {
        MongoCollection<Document> collection = database.getCollection("Report");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(historic_point);
        Document document = Document.parse(jsonString);
        collection.deleteMany({reported_historic_point: document});
    }

    public void deleteHistoricPoint(HistoricPoint historic_point) {
        MongoCollection<Document> collection = database.getCollection("HistoricPoint");

        collection.deleteOne({title: historic_point.getTitle()});
    }

    public void storeContribution(Contribution contribution) {
        MongoCollection<Document> collection = database.getCollection("Contribution");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(contribution);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

    public FindIterable<Document> fetchHistoricPoitsInArea(Location location) {
        MongoCollection<Document> collection = database.getCollection("HistoricPoint");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(location);
        Document document = Document.parse(jsonString);
        collection.find({location: document});
    }

    public void storeReport(Report report) {
        MongoCollection<Document> collection = database.getCollection("Report");
    
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(report);
        Document document = Document.parse(jsonString);
        collection.insertOne(document); 
    }
}