package app;

import db.DBUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import view.View;

@Component
public class App {

    @Qualifier("DBTxt")
    @Autowired
    public DBUsers db;

    @Qualifier("HTMLView")
    @Autowired
    public View view;

    public App(@Qualifier("DBTxt") DBUsers db, @Qualifier("HTMLView") View view) {
        this.db = db;
        this.view = view;
    }
}
