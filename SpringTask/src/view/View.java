package view;

import db.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface View {
    String showUser(User user);
    String showUsers(List<User> users);
}
