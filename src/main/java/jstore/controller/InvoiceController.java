package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InvoiceController {
    @RequestMapping(value = "/invoicecustomer/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceCust(@PathVariable int id_customer) {
        Customer customer = DatabaseCustomer.getCustomer(id_customer);
        try {
            ArrayList<Invoice> inv = DatabaseInvoice.getActiveOrder(customer);
            return inv;
        } catch (CustomerDoesntHaveActiveException e) {
            ArrayList<Invoice> inv = null;
            return inv;
        }
    }
    @RequestMapping(value = "/invoice/{id_invoice}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id_invoice) {
        return DatabaseInvoice.getInvoice(id_invoice);
    }
    @RequestMapping(value = "/createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value = "itemlist") ArrayList<Integer> itemList, @RequestParam(value = "id_customer") int id_customer){
        Invoice invoiceSellPaid = new Sell_Paid(itemList,DatabaseCustomer.getCustomer(id_customer));
        try{
            DatabaseInvoice.addInvoice(invoiceSellPaid);
        }catch(InvoiceAlreadyExistsException e){
            System.out.println(e.getExMessage());
        }
        return invoiceSellPaid;
    }
    @RequestMapping(value = "/createinvoiceunpaid", method = RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value = "itemlist") ArrayList<Integer> itemList, @RequestParam(value = "id_customer") int id_customer){
        Invoice InvoiceSellUnpaid = new Sell_Unpaid(itemList,DatabaseCustomer.getCustomer(id_customer));
        try{
            DatabaseInvoice.addInvoice(InvoiceSellUnpaid);
        }catch(InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return InvoiceSellUnpaid;
    }
    @RequestMapping(value = "/createinvoiceinstallment", method = RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value = "itemlist") ArrayList<Integer> itemList,@RequestParam(value="durasi") int durasi, @RequestParam(value = "id_customer") int id_customer){
        Invoice InvoiceSellInstallment = new Sell_Installment(itemList,durasi,DatabaseCustomer.getCustomer(id_customer));
        try{
            DatabaseInvoice.addInvoice(InvoiceSellInstallment);
        }catch(InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return InvoiceSellInstallment;
    }
    @RequestMapping(value = "/canceltransaction", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="invoice") int id_invoice){
        Transaction.cancelTransaction(DatabaseInvoice.getInvoice(id_invoice));
        return DatabaseInvoice.getInvoice(id_invoice);
    }
    @RequestMapping(value = "/finishtransaction", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="invoice") int invoice){
        Transaction.finishTransaction(DatabaseInvoice.getInvoice(invoice));
        return DatabaseInvoice.getInvoice(invoice);
    }


}
