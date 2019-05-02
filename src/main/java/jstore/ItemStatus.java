package jstore;
/**
 * Write a description of class ItemCategory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public enum ItemStatus
{
   NEW("New"),
   SECOND("Second"),
   REFURBISHED("Refurbished"),
   SOLD("Sold");
   
   private String status;
   ItemStatus(String status){
    this.status = status;
   }
   
   public String toString(){
    return status;    
   }
    
}