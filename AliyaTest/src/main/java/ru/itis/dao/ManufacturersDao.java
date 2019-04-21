package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Manufacturer;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ManufacturersDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "SELECT * FROM manufacturer where \"name\" =?";
    private final String SQL_ADD_NEW_MANUFACTURER = "INSERT INTO manufacturer(\"name\") VALUES(?)";

    @Autowired
    public ManufacturersDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Manufacturer> manufacturerRowMapper = (resultSet, i) -> Manufacturer.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .build();

    public List<Manufacturer> find(String name) {
        return jdbcTemplate.query(SQL_FIND, manufacturerRowMapper, name);
    }

    public void save(String manufacturerName) {
        jdbcTemplate.update(SQL_ADD_NEW_MANUFACTURER, manufacturerName);
    }
}
