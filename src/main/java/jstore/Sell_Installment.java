package jstore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Write a description of class Sell_Installment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Installment extends Invoice
{
   private static InvoiceType INVOICE_TYPE=InvoiceType.SELL;
   private static InvoiceStatus INVOICE_STATUS=InvoiceStatus.INSTALLMENT;
   private int installmentPeriod,installmentPrice;
   private Customer customer;
 private SimpleDateFormat form = new SimpleDateFormat ("dd MMMM yyyy");
   private boolean isActive = true;
   public Sell_Installment(ArrayList<Integer> item,int installmentPeriod,Customer customer){
    super(item);
    isActive = true;
    this.customer = customer;
    this.installmentPeriod = installmentPeriod;
    }
   public int getInstallmentPeriod(){
    return installmentPeriod;
    }
   public int getInstallmentPrice(){
   return installmentPrice;
   }
   public Customer getCustomer(){
   return customer; 
   }
   public InvoiceStatus getInvoiceStatus(){
   return INVOICE_STATUS;
   }
   public InvoiceType getInvoiceType(){
   return INVOICE_TYPE;
   }
   public void setInstallmentPrice(){
   installmentPrice= getTotalPrice() / installmentPeriod * 102/100;
   }
   public void setCustomer(Customer customer){
   this.customer=customer; 
   }
   public void setTotalPrice(int price){
   setTotalPrice(installmentPrice * installmentPeriod);
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
