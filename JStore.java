
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
       
       Item item1 = new Item (99, "Laptop", 9, ItemStatus.New, 12000000, supplier1, ItemCategory.Electronics);
       Transaction.orderNewItem(item1);
       Transaction.sellItemPaid(item1);
       Transaction.sellItemUnpaid(item1);
       Transaction.sellItemInstallment(item1);
   } 
   
   public JStore()
   {
    
   }
   
}
