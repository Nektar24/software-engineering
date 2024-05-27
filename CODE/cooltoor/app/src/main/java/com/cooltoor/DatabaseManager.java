package com.cooltoor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class DatabaseManager {
    private static final String connectionString = "mongodb+srv://webproject7:jsI7zni9lPb02XGY@cluster0.yqanhpf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private String dbName = "Cluster0";

    public static MongoClient getMongoClient() {
        System.out.println("aaaaaaaaaa11");
        return MongoClients.create("mongodb+srv://webproject7:jsI7zni9lPb02XGY@cluster0.yqanhpf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
    }

    /*
    public FindIterable<Document> fetchHistoricPoints() {
        return database.getCollection("HistoricPoints");
    }
    */

    public static void test() {
        try {
            MongoClient mongoClient = DatabaseManager.getMongoClient();
            MongoDatabase database = mongoClient.getDatabase("Cluster0");

            database.getCollection("test").insertOne(new Document("name", "test"));

            mongoClient.close();
        } catch (Exception e){
            System.out.println("Something went wrong with DB");
        }
    }
    
}
