
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class DatabaseItem
{
   private String[] listItem;
   private Item item;
   
   public boolean addItem(Item item)
   {
       return true;
   }
   
   public boolean removeItem(Item item)
   {
       return true;
   }
   
   public Item getItem()
   {
       return item;
   }
   
   public String[] getItemDatabase()
   {
       return listItem;
   }
}
