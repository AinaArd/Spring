package db;

import db.DBUsers;
import db.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBUsersPostgres implements DBUsers {

    private static final String GET_USERS = "select * from \"user\" ";
    private static final String GET_USER_BY_ID = "select * from \"user\" where name = ?";


    @Override
    public User getUser(String name) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement(GET_USER_BY_ID);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                return new User(rs.getString("name"), rs.getString("city"), rs.getInt("year"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement(GET_USERS);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("city"), rs.getInt("year")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
