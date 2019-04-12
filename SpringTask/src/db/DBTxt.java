package db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class DBTxt implements DBUsers {
    private Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public User getUser(String name) {
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            if (data[0].equals(name)) {
                return new User(data[0], data[1], Integer.parseInt(data[2]));
            }
        }
        return null;
    }


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            users.add(new User(data[0], data[1], Integer.parseInt(data[2])));
        }
        return users;
    }
}
