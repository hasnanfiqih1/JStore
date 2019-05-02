package jstore;
/**
 * Class Item merupakan suatu class yang mendefinisikan suatu barang baru
 * yang nantinya ingin kita masukan. Class ini sudah dilengkapi dengan method
 * getter dan setter yang akan memudahkan apabila nanti kita akan mengambil
 * nilai dari variabel atau ingin memodifikasinya.
 *
 * @author Michael
 * @version 28/02/2019
 */
public class Item
{
 // Inisialisasi Variabel
 private int id;
 private String name;
// private int stock;
 private int price;
 private ItemCategory category;
 private ItemStatus status;
 private Supplier supplier;
 
 //Constructor untuk Class Item
 public Item(String name,ItemStatus status,int price, Supplier supplier,ItemCategory category){
    id = DatabaseItem.getLastItemId() + 1;
    this.name = name;
//    this.stock = stock;
    this.status = status;
    this.price = price;
    this.supplier = supplier;
    this.category = category;
    }
 /**Method untuk mendapatkan Id dari Item   
  * @return int return nilai Id
  */  
 public int getId(){
    return id;
    }
 /**Method untuk mendapatkan name dari Item   
  * @return String return isi dari name
  */   
 public String getName(){
    return name;
    }
 /**Method untuk mendapatkan stock dari Item   
  * @return int return nilai stock
  */        

  /**Method untuk mendapatkan price dari Item   
  * @return int return nilai price
  */       
 public int getPrice(){
    return price;
    }
  /**Method untuk mendapatkan category dari Item   
  * @return String return isi dari category
  */        
 public ItemCategory getCategory(){
    return category;
    }
  /**Method untuk mendapatkan status dari Item   
  * @return String return isi dari category
  */        
 public ItemStatus getStatus(){
    return status;
    }    
  /**Method untuk mendapatkan supplier dari Item   
  * @return Supplier return isi dari supplier
  */       
 public Supplier getSupplier(){
    return supplier;
    }
 /**Method untuk mengganti id dari Item   
  * @param id Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai id
  */    
 public void setId(int id){
    this.id = id;
    }
 /**Method untuk mengganti name dari Item   
  * @param name Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai name
  */   
 public void setName(String name){
    this.name = name;
    }
 /**Method untuk mengganti stock dari Item   
  * @param stock Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai stock
  */  

 /**Method untuk mengganti price dari Item   
  * @param price Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai price
  */   
 public void setPrice(int price){
    this.price = price;
    }
 /**Method untuk mengganti category dari Item   
  * @param category Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai category
  */ 
 public void setCategory(ItemCategory category){
    this.category = category;
    }
 /**Method untuk mengganti supplier dari Item   
  * @param supplier Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai supplier
  */   
 public void setSupplier(Supplier supplier){
    this.supplier = supplier;
    }
 /**Method untuk mengganti status dari Item   
  * @param category Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai category
  */ 
 public void setStatus(ItemStatus status){
    this.status = status;
    }    
 /**Method untuk menampilkan nama dari Item ke standard output.
  */ 
 public String toString(){
    return ("=============ITEM=============" + "\nId : " + id + 
    "\nNama: " + name + "\nKategori: " + category +
    "\nStatus: " + status.toString() + "\nSupplier: " + supplier.getName() ); 
    }
}
