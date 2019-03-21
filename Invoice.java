
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
   private String date;
   protected int totalPrice;
   private int totalItem;
   private InvoiceStatus status;
   private InvoiceType type;
   
   public Invoice(int id, Item item, String date, int totalItem, int totalPrice)
   {
       this.id = id;
       this.item = item;
       this.date = date;
       this.totalItem = totalItem;
       this.totalPrice = totalPrice;
   }
   
   public int getId()
   {
    return id;
   }
    
   public Item getItem()
   {
    return item;
   }
    
   public String getDate()
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
    
   public void setDate(String date)
   {
       this.date = date;
   }
    
   public void setTotalPrice(int totalPrice)
   {
       this.totalPrice = totalPrice;
   }
    
   public void setTotalItem(int totalItem)
   {
       this.totalItem = totalItem;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
   
   public abstract void printData();
}
