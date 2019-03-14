
/**
 * Write a description of class JStore here.
 *
 * @author Hasnan Fiqih
 * @version (a version number or a date)
 */
public class JStore
{ 
   public static void main (String[] args)
   {
       Location location1 = new Location("Jakarta Selatan", "DKI Jakarta", "Testing");
       Supplier supplier1 = new Supplier(99, "hasnanfiqih@gmail.com", "Hasnan", "085719994355", location1);
       location1.printData();
       supplier1.printData();
       
       
       Transaction.orderNewItem(supplier1);
       Transaction.orderSecondItem(supplier1);
       Transaction.orderRefurbishedItem(supplier1);
       Transaction.sellItemPaid(DatabaseItem.getItem());
       Transaction.sellItemUnpaid(DatabaseItem.getItem());
       Transaction.sellItemInstallment(DatabaseItem.getItem());
   } 
   
   public JStore()
   {
    
   }
   
}
