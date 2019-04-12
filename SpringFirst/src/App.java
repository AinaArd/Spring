import org.springframework.orm.jpa.vendor.Database;

public class App {
    private DBInterface db;

    public App(DBInterface db) {
        this.db = db;
    }

    void connectToDataBase() {
        db.connect();
    }
}
