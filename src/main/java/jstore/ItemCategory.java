package jstore;
/**
 * Write a description of class ItemCategory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum ItemCategory
{
   ELECTRONICS("Electronics"),
   FURNITURE("Furniture"),
   STATIONERY("Stationery");
   
   private String category;
   ItemCategory(String category){
    this.category = category;
   }
   
   public String toString(){
    return category;    
   }
    
}
