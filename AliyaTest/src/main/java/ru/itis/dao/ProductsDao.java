package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Manufacturer;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ProductsDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "SELECT * FROM product where name =? and manufacturer_id=? and price=?";
    private final String SQL_ADD_NEW_PRODUCT = "with ins1 as (insert into manufacturer (name) VALUES (?)  returning id)\n" +
            "insert into product(name, price, manufacturer_id) values (?,?,(select id from ins1))";

    @Autowired
    public ProductsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Product> rowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getString("price"))
            .manufacturer(resultSet.getLong("manufacturer_id"))
            .build();

    public List<Product> findProduct(String name, String price, Manufacturer manufacturer) {
        return jdbcTemplate.query(SQL_FIND, rowMapper, name, manufacturer.getId(), price);
    }

    public void save(String name, String price, String manufacturerName) {
        jdbcTemplate.update(SQL_ADD_NEW_PRODUCT, manufacturerName, name, price);
    }
}
