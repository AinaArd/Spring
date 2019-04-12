package app;

import db.DBStudents;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import view.View;

import java.io.IOException;


@Component
public class App {

    public DBStudents db;

    public View view;

    public App(@Qualifier("DBTxt") DBStudents db, @Qualifier("HTMLView") View view) {
        this.db = db;
        this.view = view;
    }

    public String response(String request) throws IOException {
        String[] data = request.split("/");
        if (data[1].equals("students")) {
            switch (data.length) {
                case 2:
                    return view.showStudents(db.getStudents());
                case 3:
                    int id = Integer.parseInt(data[2]);
                    return view.showStudent(db.getStudent(id));
            }
        } else {
            System.out.println("Wrong link");
        }
        return "";
    }
}
