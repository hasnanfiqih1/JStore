
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
 private String category;
 private Supplier supplier;
 
 public Item(int id, String name, int stock, int price, String category, Supplier supplier)
 {
  this.id = id;
  this.name = name;
  this.stock = stock;
  this.price = price;
  this.category = category;
  this.supplier = supplier;
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
 
 public String getCategory()
 {
    return category;
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
 
 public void setCategory(String category)
 {
    this.category = category;
 }
 
 public void setSupplier(Supplier supplier)
 {
    this.supplier = supplier;
 }
 
 public void printData()
 {
     System.out.println(name);
 }
}
