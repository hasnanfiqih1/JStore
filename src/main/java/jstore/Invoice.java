package jstore;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public abstract class Invoice
{
   //inisialisasi variabel
   private int id;
   protected int totalPrice;
   private Calendar date;
   
   private Customer customer;
   private boolean isActive;
   private ArrayList<Integer> item;
   //Constructor Invoice
   public Invoice(ArrayList<Integer> item){
    this.id = DatabaseInvoice.getLastInvoiceId() + 1;
    this.item = item;
    this.date = new GregorianCalendar();
    // this.id = id;
    // this.item = item;
    
    }
 /**Method untuk mendapatkan Id dari Invoice   
  * @return int return nilai dari id
  */     
   public int getId(){
    return id;
    }
  /**Method untuk mendapatkan item dari Invoice   
  * @return Item return nilai dari item
  */     
    public ArrayList<Integer> getItem(){
    return item;
    }
    
    public Customer getCustomer(){
    return customer;
    }
  /**Method untuk mendapatkan date dari Invoice   
  * @return String return nilai dari date
  */     
    public Calendar getDate(){
      
    return date;
    }
    public abstract InvoiceStatus getInvoiceStatus();
    public abstract InvoiceType getInvoiceType();
  /**Method untuk mendapatkan totalPrice dari Invoice   
  * @return int return nilai dari totalPrice
  */     
    public int getTotalPrice(){
    return totalPrice;
    }
    public boolean getIsActive(){
    return isActive;
    }
  /**Method untuk mendapatkan totalItem dari Invoice   
  * @return int return nilai dari totalPrice
  */     
    // public int getTotalItem(){
    // return totalItem;
    // }
  /**Method untuk mendapatkan totalItem dari Invoice   
  * @return int return nilai dari totalPrice
  */           
  /**Method untuk mengganti id dari Invoice  
  * @param id Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai id
  */    
    public void setId(int id){
    this.id = id;
    }
    public void setIsActive(boolean isActive){
    this.isActive=isActive;
    }
  /**Method untuk mengganti item dari Invoice  
  * @param item Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai item
  */    
    // public void setItem(Item item){
    // this.item = item;
    // }
  /**Method untuk mengganti date dari Invoice  
  * @param date Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai date
  */    
    public void setDate(Calendar date){
    this.date = date;
    }
  /**Method untuk mengganti totalPrice dari Invoice  
  * @param totalPrice Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai totalPrice
  */    
    public void setTotalPrice(int totalPrice){
    for(int temp : DatabaseInvoice.getInvoice(id).getItem()){
    this.totalPrice = totalPrice + DatabaseItem.getItemFromID(temp).getPrice();
    }
    }
  /**Method untuk mengganti totalPrice dari Invoice  
  * @param totalItem Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai totalItem
  */    
    // public void setTotalItem(int totalItem){
    // this.totalItem = totalItem;
    // }    
  /**Method untuk mengganti status dari Invoice  
  * @param status Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai status
  */    
    public abstract void setInvoiceStatus(InvoiceStatus status);
  /**Method untuk menampilkan jumlah harga ke standard output.
  */      
    public abstract String toString();//{
   /* System.out.println("=============INVOICE============="); 
    System.out.println("Id : " + id);
    System.out.println("Date: " + date);
    System.out.println("Item: " + item.getName());
    System.out.println("Total Price: " + totalPrice);
    System.out.println("Status: " + status);
       */
   // }
}
