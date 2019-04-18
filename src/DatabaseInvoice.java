import java.util.*;

public class DatabaseInvoice {
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;
    }

    public static int getLastInvoiceID() {
        return LAST_INVOICE_ID;
    }

    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException {
        for (Invoice InvoiceDB : INVOICE_DATABASE)
            if ((InvoiceDB.getItem() == invoice.getItem()) && (InvoiceDB.getCustomer() == invoice.getCustomer()))
            {
                throw new InvoiceAlreadyExistsException(invoice);
            }
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID = invoice.getId();
        return true;
    }

    public static Invoice getInvoice(int id) {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public static Invoice getActiveOrder(Customer customer) throws CustomerDoesntHaveActiveException {
        for (Invoice invoice : INVOICE_DATABASE) {
            if ((invoice.getInvoiceStatus() == InvoiceStatus.Unpaid
                    || invoice.getInvoiceStatus() == InvoiceStatus.Installment) && invoice.getIsActive() == true) {
                throw new CustomerDoesntHaveActiveException(customer);
            }
        }
        return null;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for (Invoice invoice : INVOICE_DATABASE) {
            if ((invoice.getId() == id) && (DatabaseInvoice.getInvoice(id).getIsActive() == true)) {
                invoice.setIsActive(false);
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}
