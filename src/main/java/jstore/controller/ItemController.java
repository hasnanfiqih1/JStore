package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ItemController {

    DatabaseItemPostgre db = new DatabaseItemPostgre();

    @RequestMapping("/items")
    public ArrayList<Item> itemList(){
        db.connect();
        ArrayList<Item> temp = db.getItemDatabase();
        db.disconnect();
        return temp;
    }

    @RequestMapping("/getitembycategory")
    public  ArrayList<Item> getItemsByCategory(@RequestParam (value = "category") ItemCategory category){
        db.connect();
        ArrayList<Item> temp = db.getItemFromCategory(category);
        db.disconnect();
        return temp;
    }

    @RequestMapping("/getitembysupplier")
    public ArrayList<Item> getItemBySupplier(@RequestParam (value = "idSupplier") int idSupplier){
        db.connect();
        ArrayList<Item> temp = db.getItemFromSupplier(idSupplier);
        db.disconnect();
        return temp;
    }

    @RequestMapping("/getitembystatus")
    public ArrayList<Item> getItemByStatus(@RequestParam (value = "status") ItemStatus status){
        db.connect();
        ArrayList<Item> temp = db.getItemFromStatus(status);
        db.disconnect();
        return temp;
    }

    @RequestMapping("/items/{id_item}")
    public Item getItemFromId(@PathVariable int id_item){
        db.connect();
        Item item;
        try {
            item = db.getItemById(id_item);
        } catch (ItemNotFoundException e) {
            item = null;
            e.printStackTrace();
        }
        db.disconnect();
        return item;
    }

    @RequestMapping(value = "/newitem", method = RequestMethod.POST)
    public Item newItem(@RequestParam (value = "name") String name,
                        @RequestParam (value = "status", defaultValue = "New") ItemStatus status,
                        @RequestParam (value = "price", defaultValue = "10000") int price,
                        @RequestParam (value = "idSupplier") int idSupplier,
                        @RequestParam (value = "category", defaultValue = "Electronics") ItemCategory category)
    {
        db.connect();
        Item temp = db.insertItem(name, price, category, status, idSupplier);
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/deleteitem/{id}", method = RequestMethod.DELETE)
    public Item deleteItem(@PathVariable int id){
        db.connect();
        Item temp;
        try {
            temp = db.deleteItem(id);
        } catch (ItemNotFoundException e) {
            temp = null;
            e.printStackTrace();
        }
        db.disconnect();
        return temp;
    }
}
