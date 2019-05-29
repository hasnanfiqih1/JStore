package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

    private DatabaseCustomerPostgre db = new DatabaseCustomerPostgre();

    @RequestMapping("/getallcustomer")
    public ArrayList<Customer> getAll(){
        db.connect();
        ArrayList<Customer> temp = db.getCustomerDatabase();
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="username") String username,
                            @RequestParam(value="password") String password,
                            @RequestParam(value="year", defaultValue = "1999") int year,
                            @RequestParam(value="month", defaultValue = "7") int month,
                            @RequestParam(value="dayOfMonth", defaultValue = "24") int dayOfMonth
                            )
    {
        db.connect();
        Customer temp = db.insertCustomer(name,email,username,password,year,month,dayOfMonth);
        db.disconnect();
        return temp;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        db.connect();
        Customer temp;
        try {
            temp = db.getCustomer(id);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            temp = null;
        }
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.DELETE)
    public Customer deleteCust(@PathVariable int id){
        db.connect();
        Customer temp;
        try {
            temp = db.deleteCustomer(id);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            temp = null;
        }
        db.disconnect();
        return temp;
    }

    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer loginCust(@RequestParam (value = "email") String email,
                          @RequestParam (value = "password") String password)
    {
        db.connect();
        Customer temp = db.loginCustomer(email,password);
        db.disconnect();
        return temp;
    }
}