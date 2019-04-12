package app.dao;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UsersDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_ALL = "SELECT * FROM \"user\"";
    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM \"user\" WHERE id=?";


    @Autowired
    public UsersDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    public List<User> find(Long id) {
        return jdbcTemplate.query(SQL_SELECT_USER_BY_ID, userRowMapper, id);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .email(resultSet.getString("email"))
            .password(resultSet.getString("password"))
            .build();
}



