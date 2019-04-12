

import java.util.*;
import java.text.*;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class Sell_Unpaid extends Invoice
{
    // instance variables - replace the example below with your own
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Customer customer;
    private Calendar dueDate;
    private boolean isActive;
    private SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMM yyy");

    /**
     * Constructor for objects of class Sell_Paid
     */
    public Sell_Unpaid(ArrayList<Integer> item, Customer customer)
    {
        // initialise instanc'e variables
        super(item);
        this.dueDate = new GregorianCalendar();
        dueDate.add((GregorianCalendar.DATE), 1);
        this.customer = customer;
        this.isActive = true;
    }
    
    public InvoiceStatus getInvoiceStatus() 
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType() 
    {
        return INVOICE_TYPE;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Calendar getDueDate() 
    {
        return dueDate;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setDueDate(Calendar dueDate)
    {
        this.dueDate = dueDate;
    }

    public String toString()
    {
        System.out.println("ID = " + super.getId());
        ArrayList<Integer> listItemID = DatabaseInvoice.getInvoice(super.getId()).getItem();
        for(int tempID : listItemID)
        {
            System.out.println("Item = " +
                    DatabaseItem.getItemFromID(tempID).getName());
            System.out.println("Price = " +
                    DatabaseItem.getItemFromID(tempID).getPrice());
            System.out.println("Supplier ID = " +
                    DatabaseItem.getItemFromID(tempID).getSupplier().getId());
            System.out.println("Supplier name = " +
                    DatabaseItem.getItemFromID(tempID).getSupplier().getName());
        }
        System.out.println("Buy date = " + dateFormat.format(super.getDate().getTime()));
        System.out.println("Price total = " + super.getTotalPrice());
        System.out.println("Customer ID = " + customer.getId());
        System.out.println("Customer name = " + customer.getName());
        System.out.println("Status = " + INVOICE_STATUS);
        System.out.println("Due date = " + dateFormat.format(dueDate));
        System.out.println(
                "If payment is not received by dueDate, transaction will be cancelled.");
        return "";
    }
}
