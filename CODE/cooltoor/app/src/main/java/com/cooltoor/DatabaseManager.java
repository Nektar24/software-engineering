package com.cooltoor;
/*
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

    public void modifyRating(Rating rating){
        MongoCollection<Document> collection = database.getCollection("Rating");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(rating);
        Document document = Document.parse(jsonString);
        collection.updateOne({username: rating.getUsername(), historic_point: rating.getHistoricPoint()}, document);
    }

}
*/