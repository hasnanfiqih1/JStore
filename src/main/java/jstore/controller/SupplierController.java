package jstore.controller;
import org.springframework.web.bind.annotation.*;

import jstore.*;

import java.util.ArrayList;
@RestController
public class SupplierController {
    @RequestMapping(value = "/suppliers" , method = RequestMethod.GET)
    public ArrayList<Supplier> supplierList(){
        ArrayList<Supplier> sup = DatabaseSupplier.getSupplierDatabase();
        return sup;
    }
    @RequestMapping(value = "/suppliers/{id_supplier}", method = RequestMethod.GET)
    public Supplier getSupplierFromId(@PathVariable int id_supplier) {
        Supplier supplier_id = DatabaseSupplier.getSupplier(id_supplier);
        return supplier_id;
    }
}
