package com.example.makanita.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class ItemDao {
    private final String INSERT_SQL = "INSERT INTO items (id, itemname, description,price)  values (:id,:itemname,:description,:price)";
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addItemToDb() {

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", 432432)
                .addValue("itemname", "Iphone")
                .addValue("description", "mobile phone")
                .addValue("price", 312321);
        jdbcTemplate.update(INSERT_SQL, parameters);
    }

    public List<Item> getAll() {
        String sql = "SELECT * FROM items";
        List<Item> items = jdbcTemplate.query(sql, new ItemsMapper());
        return items;
    }

    public class ItemsMapper implements RowMapper<Item> {
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.itemname = rs.getString("itemname");
            item.description = rs.getString("description");
            item.price = rs.getDouble("price");
            return item;
        }
    }
}


