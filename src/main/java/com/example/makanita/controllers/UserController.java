package com.example.makanita.controllers;

import com.example.makanita.dao.Item;
import com.example.makanita.services.ItemService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ItemService itemService;

    @JsonSerialize
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Item> getProduct() {

        List<Item>  items =  itemService.addNewItem();

        return items;

    }

    class User {
        String firstName;
        String LastName;
    }
}
