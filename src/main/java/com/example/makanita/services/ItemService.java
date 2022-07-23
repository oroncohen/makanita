package com.example.makanita.services;

import com.example.makanita.dao.Item;
import com.example.makanita.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<Item> addNewItem(){
        itemDao.addItemToDb();
        return itemDao.getAll();
    }

    public List<Item> getAllItems(){
        return itemDao.getAll();
    }

}
