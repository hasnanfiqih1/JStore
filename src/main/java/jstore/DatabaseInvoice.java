package jstore;
import java.util.ArrayList;
/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int LAST_INVOICE_ID = 0;
    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastInvoiceId(){
        return LAST_INVOICE_ID;
    }
    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException{
        for (Invoice inv : INVOICE_DATABASE){
            if((invoice.getCustomer() == inv.getCustomer()) && (invoice.getItem() == inv.getItem())) {
                INVOICE_DATABASE.add(invoice);
                LAST_INVOICE_ID = invoice.getId();
                return true;
            }
        }
        throw new InvoiceAlreadyExistsException(invoice);
    }
    public static Invoice getInvoice(int id) {

        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }
    public static ArrayList<Invoice> getActiveOrder(Customer customer) throws CustomerDoesntHaveActiveException{
        ArrayList<Invoice> listInv = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE){
            if((invoice.getCustomer().getId() == customer.getId()) && invoice.getIsActive() == true ){
                listInv.add(invoice);
            }
            return listInv;
        }
        throw new CustomerDoesntHaveActiveException(customer);
    }
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for(Invoice invoice: INVOICE_DATABASE){
            if(invoice.getId() == id){
                if(invoice.getIsActive() == true){
                    invoice.setIsActive(false);
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                } else
                {
                    INVOICE_DATABASE.remove(invoice);
                    return true;
                }
            }

        }
        throw new InvoiceNotFoundException(id);
    }


    // public Invoice[] getListInvoice(){

    // }
}