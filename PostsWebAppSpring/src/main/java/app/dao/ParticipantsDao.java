package app.dao;

import app.models.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParticipantsDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_ALL = "SELECT * FROM participant";
    private final String SQL_SELECT_ONE = "SELECT * FROM participant where email = ?";
    private final String SQL_ADD_NEW_PARTICIPANT = "INSERT INTO participant(\"name\", \"city\", \"email\") VALUES(?, ?, ?)";


    @Autowired
    public ParticipantsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Participant> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    public void save(String name, String city, String email) {
        jdbcTemplate.update(SQL_ADD_NEW_PARTICIPANT, name, city, email);
    }

    public void save(String text, Long id) {

    }

    private RowMapper<Participant> rowMapper = (resultSet, i) -> Participant.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .city(resultSet.getString("city"))
            .email(resultSet.getString("email"))
            .build();

    public Participant logIn(String email) {
        return jdbcTemplate.query(SQL_SELECT_ONE, rowMapper, email).get(0);
    }

    public Participant getParticipant(String email) {
        return (Participant) jdbcTemplate.query(SQL_SELECT_ONE, rowMapper, email);
    }
}



