package jstore;
import java.util.ArrayList;

public class DatabaseItem
{
   //inisialisasi Variabel
   private static ArrayList<Item> ITEM_DATABASE = new ArrayList<>();
   private static int LAST_ITEM_ID = 0;
   //temporary variable
   private static ArrayList<Item> tempList;
  public static ArrayList<Item> getItemDatabase(){
  return ITEM_DATABASE; 
  }
  
  public static int getLastItemId(){
   return LAST_ITEM_ID; 
   }
 
  public static boolean addItem(Item item) throws ItemAlreadyExistsException{
   for(Item it: ITEM_DATABASE){
        if((item.getName() == it.getName()) && (item.getStatus() == it.getStatus()) && item.getSupplier() == it.getSupplier() && (item.getCategory() == it.getCategory())){
            throw new ItemAlreadyExistsException(item);
        }    
    }
    ITEM_DATABASE.add(item);
    LAST_ITEM_ID = item.getId();
    return true;
    }
  
  public static Item getItemFromID(int id){
  for (Item item : ITEM_DATABASE) {
            if (item.getId() == id) {
                return item;
            } 
        }
        return null;
  }
  public static ArrayList<Item> getItemFromSupplier(Supplier supplier){
      for(Item item: ITEM_DATABASE){
      if(item.getSupplier() == supplier){
      tempList.add(item);  
      } else {
      return null;
      }
      }
      return tempList;
  }
  public static ArrayList<Item> getItemFromCategory(ItemCategory category){
      for(Item item: ITEM_DATABASE){
      if(item.getCategory() == category){
      tempList.add(item);  
      } else {
      return null;
      }
      }
      return tempList;
  }
  public static ArrayList<Item> getItemFromStatus(ItemStatus status){
      for(Item item: ITEM_DATABASE){
      if(item.getStatus() == status){
      tempList.add(item);  
      } 
      }
      return tempList;
  }
  public static boolean removeItem(int id) throws ItemNotFoundException{
      for(Item item : ITEM_DATABASE){
      if(item.getId() == id){
      ITEM_DATABASE.remove(item);
      return true;
      } 
    }
      throw new ItemNotFoundException(id);
      //return false;
  }
}
