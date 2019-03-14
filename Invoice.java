
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class Invoice
{
   private int id;
   private Item item;
   private String date;
   private int totalPrice;
   private int totalItem;
   private InvoiceStatus status;
   
   public Invoice(int id, Item item, String date, int totalPrice)
   {
       this.id = id;
       this.item = item;
       this.date = date;
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
   
   public void printData()
   {
     System.out.println("==========INVOICE==========");
     System.out.println("ID: "+id);
     System.out.println("Tanggal: "+date);
     System.out.println("Item: "+item.getName());
     System.out.println("Total Harga: "+totalPrice);
     System.out.println("Status: "+status);
     System.out.println("===========================");
   }
}
