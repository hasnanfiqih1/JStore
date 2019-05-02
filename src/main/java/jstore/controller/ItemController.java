package jstore.controller;


import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ItemController {

    @RequestMapping(value = "/items" , method = RequestMethod.GET)
    public ArrayList<Item> itemsList(){
        ArrayList<Item> items = DatabaseItem.getItemDatabase();
        return items;
    }

    @RequestMapping(value = "/items/{id_item}", method = RequestMethod.GET)
    public Item getItemFromId(@PathVariable int id_item) {
        Item item_id = DatabaseItem.getItemFromID(id_item);
        return item_id;
    }
}
