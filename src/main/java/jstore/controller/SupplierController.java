package jstore.controller;

import jstore.DatabaseItem;
import jstore.DatabaseSupplier;
import jstore.Item;
import jstore.Supplier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SupplierController {
    @RequestMapping(value="/suppliers", method = RequestMethod.GET)
    public ArrayList<Supplier> supplierList()
    {
        ArrayList<Supplier> supplier = DatabaseSupplier.getSupplierDatabase();
        return supplier;
    }


    @RequestMapping("/suppliers/{id}")
    public Supplier getSupplier(@PathVariable int id)
    {
        Supplier supplier_id = DatabaseSupplier.getSupplier(id);
        return supplier_id;
    }

}

