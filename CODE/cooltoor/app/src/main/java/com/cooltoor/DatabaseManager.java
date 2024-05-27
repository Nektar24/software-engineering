import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class DatabaseManager {
    private String connectionString = "<YOUR_CONNECTION_STRING>";
    private String dbName = "<YOUR_DB_NAME>";

    public MongoClient getMongoClient() {
        return MongoClients.create(this.connectionString);
    }

    public FindIterable<Document> fetchHistoricPoints() {
        return database.getCollection("HistoricPoints");
    }

    public void storeHistoricPoint(HistoricPoint historic_point) {
        MongoClient mongoClient = this.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase(this.dbName);

        database.getCollection("HistoricPoints").insertOne(historic_point);

        mongoClient.close();
    }
    
}
