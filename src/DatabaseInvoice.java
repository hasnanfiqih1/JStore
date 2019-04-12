import java.util.*;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;

    public DatabaseInvoice()
    {

    }

    public static ArrayList<Invoice> getInvoiceDatabse()
    {
        return INVOICE_DATABASE;
    }

    public static int getLastInvoiceId()
    {
        return LAST_INVOICE_ID;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        INVOICE_DATABASE.add(invoice);
        return true;
    }

    public static Invoice getInvoice(int id)
    {
        for(Invoice temp : INVOICE_DATABASE)
        {
            if(temp.getId() == id)
            {
                return temp;
            }
        }
        return null;
    }

    public static Invoice getActiveOrder(Customer customer)
    {
        for(Invoice temp : INVOICE_DATABASE)
        {
            if((temp.getInvoiceStatus() == InvoiceStatus.Unpaid ||
                    temp.getInvoiceStatus() == InvoiceStatus.Installment) &&
                    temp.getIsActive() == true)
            {
                return temp;
            }
        }
        return null;
    }

    public static boolean removeInvoice(int id)
    {
        for(Invoice temp : INVOICE_DATABASE)
        {
            if(temp.getId() == id)
            {
                if(temp.getIsActive() == true)
                {
                    temp.setIsActive(false);
                    INVOICE_DATABASE.remove(temp);
                    return true;
                }
            }
        }
        return false;
    }

}
