import java.util.*;
/**

  * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public abstract class Invoice
{
   private int id;
   private Item item;
   private Calendar date = Calendar.getInstance();
   private int totalPrice;
   private int totalItem;
   private InvoiceStatus status;
   private InvoiceType type;
   
   
   public Invoice(int id, Item item, int totalItem)
   {
       this.id = id;
       this.item = item;
       this.totalItem = totalItem;
       setTotalPrice(); 
   }
   
   public int getId()
   {
    return id;
   }
    
   public Item getItem()
   {
    return item;
   }
    
   public Calendar getDate()
   {
    return date;
   }
    
   public int getTotalPrice()
   {
    return totalPrice;
   }
   
   public int getTotalItem()
   {
       return totalItem;
    }
   
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    
    public InvoiceType getInvoiceType()
    {
        return type;
    }
    
   public void setId(int id)
   {
       this.id = id;
   }
    
   public void setItem(Item item)
   {
       this.item = item;
   }
    
   public void setDate(Calendar date)
   {
       this.date = date;
   }
    
   public void setTotalPrice()
   {
       totalPrice = item.getPrice()*totalItem;
   }
    
   public void setTotalItem(int totalItem)
   {
       this.totalItem = totalItem;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
   
   //public abstract void printData();
   
   public String toString()
   {
       return id +""+ item+date+totalPrice+totalItem+status+type;
    }
}
