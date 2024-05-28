import android.content.Context;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.sync.SyncConfiguration;

public class DatabaseManager {

    private static DatabaseManager instance;
    private final Realm realm;

    private DatabaseManager(Context context) {
        Realm.init(context);
        App app = new App(new AppConfiguration.Builder("your-realm-app-id").build());
        SyncConfiguration config = new SyncConfiguration.Builder(app.currentUser(), "partition_key")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .syncConfiguration(config)
                .build());
        realm = Realm.getDefaultInstance();
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context.getApplicationContext());
        }
        return instance;
    }

    public void addTask(Task task) {
        realm.executeTransaction(realm -> realm.insertOrUpdate(task));
    }

    public RealmResults<Task> getAllTasks() {
        return realm.where(Task.class).findAllAsync();
    }

    public void closeRealm() {
        if (realm != null) {
            realm.close();
        }
    }
}
