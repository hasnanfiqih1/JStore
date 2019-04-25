package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InvoiceController {
    @RequestMapping(value="/invoicecustomer/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceCust(@PathVariable int id_customer)
    {
        Customer customer = DatabaseCustomer.getCustomer(id_customer);
        try {
            ArrayList<Invoice> invoice = DatabaseInvoice.getActiveOrder(customer);
            return invoice;
        }
        catch (CustomerDoesntHaveActiveException e)
        {
            ArrayList<Invoice> invoice = null;
            return invoice;
        }

    }

    @RequestMapping(value = "/invoice/{id_invoice}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id_invoice)
    {
        Invoice invoice = DatabaseInvoice.getInvoice(id_invoice);
        return invoice;
    }

    @RequestMapping(value = "createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value = "listitem") ArrayList<Integer> itemList,
                                     @RequestParam(value = "idcustomer") int idCustomer)
    {
        Invoice sellpaid = new Sell_Paid(itemList, DatabaseCustomer.getCustomer(idCustomer));
        return sellpaid;
    }

    @RequestMapping(value = "createinvoiceunpaid", method = RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value = "listitem") ArrayList<Integer> itemList,
                                     @RequestParam(value = "idcustomer") int idCustomer)
    {
        Invoice sellunpaid = new Sell_Unpaid(itemList, DatabaseCustomer.getCustomer(idCustomer));
        return sellunpaid;
    }

    @RequestMapping(value = "createinvoiceinstallment", method = RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value = "listitem") ArrayList<Integer> itemList,
                                     @RequestParam(value = "idcustomer") int idCustomer,
                                            @RequestParam(value = "period") int period)
    {
        Invoice sellinstallment = new Sell_Installment(itemList, period, DatabaseCustomer.getCustomer(idCustomer));
        return sellinstallment;
    }

    @RequestMapping(value = "canceltransaction", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value = "idinvoice") int idinvoice)
    {
        Transaction.cancelTransaction(DatabaseInvoice.getInvoice(idinvoice));
        return DatabaseInvoice.getInvoice(idinvoice);
    }

    @RequestMapping(value = "finishtransaction", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value = "idinvoice") int idinvoice)
    {
        Transaction.finishTransaction(DatabaseInvoice.getInvoice(idinvoice));
        return DatabaseInvoice.getInvoice(idinvoice);
    }
}
