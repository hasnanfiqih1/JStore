import java.util.*;
import java.text.*;

/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Buy_Paid extends Invoice
{
    // instance variables - replace the example below with your own
    private InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    private boolean isActive;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyy");

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Buy_Paid(ArrayList<Integer> item)
    {
        super(item);
        isActive = false;
    }
    
    public InvoiceStatus getInvoiceStatus() 
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType() 
    {
        return INVOICE_TYPE;
    }
    
    //public void printData()
    //{
     //  System.out.println("===== INVOICE =====");
     //   System.out.println("ID: "+this.getId());
      //  System.out.println("Date: "+this.getDate());
       // System.out.println("Item: "+this.getItem().getName());
        //System.out.println("status: "+this.INVOICE_STATUS);
        //System.out.println("type: "+this.INVOICE_TYPE);
        //System.out.println("Total price: "+this.totalPrice);
    //}

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
        System.out.println("Status = " + this.getInvoiceStatus());
        System.out.println("Buy success.");
        return "";
    }
}
