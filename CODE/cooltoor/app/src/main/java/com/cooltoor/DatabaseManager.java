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

    public MongoDBManager(String connectionString, String dbName) {
        this.mongoClient = MongoClients.create(connectionString);
        this.database = mongoClient.getDatabase(dbName);
    }

    public FindIterable<Document> fetchHistoricPoints(){
        MongoCollection<Document> collection = database.getCollection("HistoricPoint");
        return collection.find();
    }

    public void storeHistoricPoint(HistoricPoint historic_point){
        MongoCollection<Document> collection = database.getCollection("historic_points");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(historic_point);
        Document document = Document.parse(jsonString);
        collection.insertOne(document);
    }

}
