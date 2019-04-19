package app.dao;

import app.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PostsDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_ALL_BY_PARTICIPANT = "SELECT * FROM post where author = ?";
    private final String SQL_ADD_NEW_POST = "INSERT INTO post(text, author) VALUES(?, ?)";

    @Autowired
    public PostsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Post> getAll(Long id) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_PARTICIPANT, rowMapper, id);
    }

    public void save(String name, String city, String email) {

    }

    public void save(String text, Long id) {
        jdbcTemplate.update(SQL_ADD_NEW_POST, text, id);
    }

    private RowMapper<Post> rowMapper = (resultSet, i) -> Post.builder()
            .id(resultSet.getLong("id"))
            .text(resultSet.getString("text"))
            .author(resultSet.getLong("author"))
            .build();
}
