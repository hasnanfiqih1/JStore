package jstore.controller;

import jstore.DatabaseItem;
import jstore.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ItemController {
    @RequestMapping(value="/items", method = RequestMethod.GET)
    public ArrayList<Item> itemList()
    {
        ArrayList<Item> items = DatabaseItem.getItemDatabase();
        return items;
    }


    @RequestMapping("/items/{id}")
    public Item getItem(@PathVariable int id)
    {
        Item item_id = DatabaseItem.getItemFromID(id);
        return item_id;
    }

}

