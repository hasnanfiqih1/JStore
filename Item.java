
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class Item
{
 private int id;
 private String name;
 private int stock;
 private int price;
 private ItemCategory category;
 private ItemStatus status;
 private Supplier supplier;
 
 public Item(int id, String name, int stock, ItemStatus status, int price, Supplier supplier, ItemCategory category)
 {
  this.id = id;
  this.name = name;
  this.stock = stock;
  this.status = status;
  this.price = price;
  this.supplier = supplier;
  this.category = category;
 }
    
 public int getId()
 {
    return id;
 }
 
 public String getName()
 {
    return name;
 }
 
 public int getStock()
 {
    return stock;
 }
 
 public int getPrice()
 {
    return price;
 }
 
 public ItemCategory getCategory()
 {
    return category;
 }
 
 public ItemStatus getStatus()
 {
     return status;
    }
 
 public Supplier getSupplier()
 {
     return supplier;
 }
 
 public void setId(int id)
 {
    this.id = id;
 }
 
 public void setName(String name)
 {
    this.name = name;
 }
 
 public void setStock(int stock)
 {
    this.stock = stock;
 }
 
 public void setPrice(int price)
 {
    this.price = price;
 }
 
 public void setCategory(ItemCategory category)
 {
    this.category = category;
 }
 
 public void setStatus(ItemStatus status)
 {
     this.status = status;
    }
 
 public void setSupplier(Supplier supplier)
 {
    this.supplier = supplier;
 }
 
 public void printData()
 {
     System.out.println("==========ITEM==========");
     System.out.println("ID: "+id);
     System.out.println("Nama: "+name);
     System.out.println("Kategori: "+category);
     System.out.println("Status: "+status);
     System.out.println("Supplier: "+supplier.getName());
     System.out.println("========================");
 }
}
