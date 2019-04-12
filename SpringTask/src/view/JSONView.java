package view;

import db.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JSONView implements View {
    @Override
    public String showUser(User user) {
        return "{\"userame\": " + user.getUsername() + "}";
    }

    @Override
    public String showUsers(List<User> users) {
        String result = "{\n" +
                "    \"users\" : [";

        for(User user : users) {
            result += "{\n" +
                    "        \"username\": " + user.getUsername() + "\n" +
                    "        \"city\": " + user.getCity() + "\n" +
                    "        \"year\": " + user.getYear() + "\n" +
                    "    },";
        }
        return result + "]\n" +
                "}";
    }
}
