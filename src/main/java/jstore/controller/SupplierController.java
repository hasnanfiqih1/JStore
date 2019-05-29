package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SupplierController {

    DatabaseSupplierPostgre db = new DatabaseSupplierPostgre();

    @RequestMapping("/suppliers")
    public ArrayList<Supplier> getAll(){
        db.connect();
        ArrayList<Supplier> temp = db.getSupplierDatabase();
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/newsupplier", method = RequestMethod.POST)
    public Supplier addSup(@RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "phoneNumber") String phoneNumber,
                           @RequestParam(value = "city", defaultValue = "Depok") String city,
                           @RequestParam(value = "province", defaultValue = "Jawa Barat") String province,
                           @RequestParam(value = "description", defaultValue = "MantaP!") String description
                           )
    {
        db.connect();
        Supplier temp = db.insertSupplier(name, email, phoneNumber, city, province, description);
        db.disconnect();
        return temp;
    }

    @RequestMapping("/suppliers/{id}")
    public Supplier getSup(@PathVariable int id) {
        db.connect();
        Supplier temp;
        try {
            temp = db.getSupplier(id);
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
            temp = null;
        }
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/deletesupplier/{id}", method = RequestMethod.DELETE)
    public Supplier deleteSup(@PathVariable int id) {
        db.connect();
        Supplier temp;
        try {
            temp = db.deleteSupplier(id);
        } catch (SupplierNotFoundException e) {
            e.printStackTrace();
            temp = null;
        }
        db.disconnect();
        return temp;
    }
}
