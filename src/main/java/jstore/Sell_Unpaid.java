package jstore;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Sell_Unpaid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Unpaid extends Invoice
{
   private static InvoiceType INVOICE_TYPE=InvoiceType.SELL;
   private static InvoiceStatus INVOICE_STATUS=InvoiceStatus.UNPAID;
   private Calendar dueDate;
   private Customer customer;
    private SimpleDateFormat form = new SimpleDateFormat ("dd MMMM yyyy");
   private boolean isActive;
   public Sell_Unpaid(ArrayList<Integer> item, Customer customer){
       super(item);
       this.customer = customer;
       isActive = true;
   }
   public InvoiceStatus getInvoiceStatus(){
    return INVOICE_STATUS;
   }
   public InvoiceType getInvoiceType(){
    return INVOICE_TYPE;
   }
   public Customer getCustomer(){
   return customer; 
   }
   public Calendar getDueDate(){
    return dueDate;
   }
   public void setCustomer(Customer customer){
   this.customer = customer;
   }
   public void setDueDate(Calendar dueDate){
   this.dueDate = dueDate; 
   }
    public void setIsActive(boolean isActive){
        this.isActive=isActive;
    }
    public boolean getIsActive(){
        return isActive;
    }
       public void setInvoiceStatus(InvoiceStatus status){
    }
    public String toString(){
        System.out.println("=========INVOICE==========");
       System.out.println("ID = " + super.getId());
        for(int id : DatabaseInvoice.getInvoice(super.getId()).getItem())
        {
            System.out.println("Item = " + DatabaseItem.getItemFromID(id).getName());
            System.out.println("Price = " + DatabaseItem.getItemFromID(id).getPrice());
            System.out.println("Supplier Id = " + DatabaseItem.getItemFromID(id).getSupplier().getId());
            System.out.println("Supplier Name = " + DatabaseItem.getItemFromID(id).getSupplier().getName());
        }
        System.out.println("Sell date = " + form.format(super.getDate().getTime()));
        System.out.println("Total Price = " + super.getTotalPrice());
        System.out.println("Status = " + getInvoiceStatus());
        System.out.println("is Active = " + getIsActive());
        return "";   
   }
}