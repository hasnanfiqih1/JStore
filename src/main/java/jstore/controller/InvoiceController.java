package jstore.controller;


import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InvoiceController {

    DatabaseInvoicePostgre db = new DatabaseInvoicePostgre();

    @RequestMapping("invoicecustomer/{id_customer}")
    public ArrayList<Invoice> invCust(@PathVariable int id_customer){
        db.connect();
        ArrayList<Invoice> invoices = db.getActiveInvoice(id_customer);
        db.disconnect();
        return invoices;
    }

    @RequestMapping("allinvoicecustomer/{id_customer}")
    public ArrayList<Invoice> invCusts(@PathVariable int id_customer){
        db.connect();
        ArrayList<Invoice> invoices = db.getAllInvoice(id_customer);
        db.disconnect();
        return invoices;
    }

    @RequestMapping("invoice/{id_invoice}")
    public Invoice getInv(@PathVariable int id_invoice){
        db.connect();
        Invoice invoice = db.getInvoice(id_invoice);
        db.disconnect();
        return invoice;
    }

    @RequestMapping(value = "/createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam (value = "listItem") ArrayList<Integer> listItem,
                                     @RequestParam (value = "idCustomer") int idCustomer)
    {
        db.connect();
        Invoice invoice = db.insertInvoicePaid(listItem,idCustomer);
        db.disconnect();
        return invoice;
    }

    @RequestMapping(value = "/createinvoiceunpaid", method = RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam (value = "listItem") ArrayList<Integer> listItem,
                                       @RequestParam (value = "idCustomer") int idCustomer)
    {
        db.connect();
        Invoice invoice = db.insertInvoiceUnpaid(listItem,idCustomer);
        db.disconnect();
        return invoice;
    }

    @RequestMapping(value = "/createinvoiceinstallment", method = RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam (value = "listItem") ArrayList<Integer> listItem,
                                            @RequestParam (value = "installmentPeriod") int installmentPeriod,
                                            @RequestParam (value = "idCustomer") int idCustomer)
    {
        db.connect();
        Invoice invoice = db.insertInvoiceInstallment(listItem,idCustomer,installmentPeriod);
        db.disconnect();
        return invoice;
    }

    @RequestMapping(value = "/canceltransaction", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam (value = "idInvoice") int idInvoice){
        db.connect();
        Invoice invoice = db.cancelTransaction(idInvoice);
        db.disconnect();
        return invoice;
    }

    @RequestMapping(value = "/finishtransaction", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam (value = "idInvoice") int idInvoice) {
        db.connect();
        Invoice invoice = db.finishTransaction(idInvoice);
        db.disconnect();
        return invoice;
    }
}
