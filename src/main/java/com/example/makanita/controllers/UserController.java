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
    ItemService itemService;

    @JsonSerialize
    @RequestMapping(path = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
        List<Item> items = itemService.getAllItems();
        return items;

    }
}
