package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ProductsDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_ALL = "SELECT * FROM product";
    private final String SQL_FIND = "SELECT * FROM product where name =? or price =? or manufacturer_id=?";
    private final String SQL_ADD_NEW_PRODUCT = "INSERT INTO product(\"name\", \"price\") VALUES(?, ?)";



    @Autowired
    public ProductsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
    }

    public void save(String name, String price) {
        jdbcTemplate.update(SQL_ADD_NEW_PRODUCT, name, price);
    }

    private RowMapper<Product> rowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getString("price"))
            .manufacturer(resultSet.getLong("manufacturer_id"))
            .build();

    public boolean findProduct(String name, String price, Long id) {
        List<Product> products = jdbcTemplate.query(SQL_FIND, name, price, id);
        if(!products.isEmpty()){
            return true;
        }
        return false;
    }
}
