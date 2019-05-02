package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;



import java.util.Calendar;

@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer logincust(@RequestParam(value="email")String email, @RequestParam(value="password") String password){
        Customer customer = DatabaseCustomer.getCustomerLogin(email,password);
        return customer;
    }

    @RequestMapping("/newcustomer")
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="username") String username,
                            @RequestParam(value="password") String password
    )
    {
        Customer customer = new Customer(name, email, username, password, 1999, 10, 10);
        try {
            DatabaseCustomer.addCustomer(customer);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        }

        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomer.getCustomer(id);
        return customer;
    }
}