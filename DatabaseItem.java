
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class DatabaseItem
{
   private String[] listItem;
   public static Item itemDB;
   
   public static boolean addItem(Item item)
   {
       itemDB = item;
       return true;
   }
   
   public static boolean removeItem(Item item)
   {
       return true;
   }
   
   public static Item getItem()
   {
       return itemDB;
   }
   
   public String[] getItemDatabase()
   {
       return listItem;
   }
}
