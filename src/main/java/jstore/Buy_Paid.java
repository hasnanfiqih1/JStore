package jstore;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Buy_Paid extends Invoice
{
   private static final InvoiceType INVOICE_TYPE=InvoiceType.BUY;
   private static final InvoiceStatus INVOICE_STATUS=InvoiceStatus.PAID;
   private boolean isActive;
   private SimpleDateFormat form = new SimpleDateFormat ("dd mm yyyy");
   public Buy_Paid(ArrayList<Integer> item){
       super(item);
       isActive = false;
    }
   public InvoiceStatus getInvoiceStatus(){
    return INVOICE_STATUS;
   }
   public InvoiceType getInvoiceType(){
    return INVOICE_TYPE;
    }
    public void setInvoiceStatus(InvoiceStatus status){
    }
    @Override
    public String toString(){
        
        System.out.println("ID = " + super.getId());
        for(int id : DatabaseInvoice.getInvoice(super.getId()).getItem())
        {
            System.out.println("Item = " + DatabaseItem.getItemFromID(id).getName());
            System.out.println("Price = " + DatabaseItem.getItemFromID(id).getPrice());
            System.out.println("Supplier Id = " + DatabaseItem.getItemFromID(id).getSupplier().getId());
            System.out.println("Supplier Name = " + DatabaseItem.getItemFromID(id).getSupplier().getName());
        }
        System.out.println("Buy date = " + form.format(super.getDate().getTime()));
        System.out.println("Total Price = " + super.getTotalPrice());
        System.out.println("Status = " + getInvoiceStatus());
        return "";
    }
}
