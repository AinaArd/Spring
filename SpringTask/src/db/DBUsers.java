package db;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DBUsers {
    User getUser(String name);
    List<User> getUsers();
}
