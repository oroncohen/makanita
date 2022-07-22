package com.example.makanita.dao;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Item {
    int id;
    String itemname;
    String description;
    double price;
}
