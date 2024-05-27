import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class DatabaseManager {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBManager() {
        mongoClient = MongoClients.create(this.mongoClient);
        database = mongoClient.getDatabase(this.database);
    }

    public FindIterable<Document> fetchHistoricPoints() {
        return database.getCollection("HistoricPoints");
    }

    public void storeHistoricPoint(HistoricPoint historic_point) {
        database.getCollection("HistoricPoints").insertOne(historic_point);
    }

    
}
