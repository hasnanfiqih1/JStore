package jstore;
/**
 * Write a description of class ItemCategory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum InvoiceStatus
{
   PAID("Paid"),
   UNPAID("Unpaid"),
   INSTALLMENT("Installment");
   
   private String status;
   InvoiceStatus(String status){
    this.status = status;
   }
   
   public String toString(){
    return status;    
   }
    
}