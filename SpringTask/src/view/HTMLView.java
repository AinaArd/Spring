package view;

import db.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HTMLView implements View {
    @Override
    public String showUser(User user) {
        return "<h1>" + user.getUsername() + "</h1>";
    }

    private String wrapByTd(String x) {
        return "<td>" + x + "</td>";
    }
    @Override
    public String showUsers(List<User> users) {
        String result = "<table>";
        for (User user: users) {
            result += "<tr>" + wrapByTd(user.getUsername())
                    + wrapByTd(user.getCity())
                    + wrapByTd("" + user.getYear())
                    + "</tr>";
        }
        return result + "</table>";
    }
}