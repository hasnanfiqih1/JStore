package jstore;
import java.util.regex.*;

public class Supplier
{
    //inisialisasi variabel
    private int id;
    private String name,email,phoneNumber;
    private Location location;
    //constructor untuk Supplier
    public Supplier(String name,String email,String phoneNumber,Location location){
   Pattern p = Pattern.compile("^\\+62\\d{12,15}$");
   Matcher m = p.matcher(phoneNumber);
    if(m.matches()){    
    this.id = DatabaseSupplier.getLastSupplierId() + 1;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.location = location;
    } else {
    System.out.println("Objek Gagal dibuat");
    }
    }
 /**Method untuk mendapatkan Id dari Supplier   
  * @return int return nilai Id
  */
 public int getId(){
    return id;
    }
 /**Method untuk mendapatkan name dari Supplier   
  * @return String return isi dari name
  */   
 public String getName(){
    return name;
    }
 /**Method untuk mendapatkan Id dari Supplier   
  * @return String return isi dari email
  */   
 public String getEmail(){
    return email;
    }
 /**Method untuk mendapatkan Id dari Supplier   
  * @return String return isi dari phoneNumber
  */   
 public String getPhoneNumber(){
    return phoneNumber;
    }
 /**Method untuk mendapatkan Id dari Supplier   
  * @return Location return isi dari Location
  */
 public Location getLocation(){
    return location;
    }
  /**Method untuk mengganti Id dari Supplier   
  * @param id Ini merupakan parameter yang digunakan untuk mengganti nilai Id
  */  
 public void setId(int id){
    this.id = id;
    }
  /**Method untuk mengganti name dari Supplier   
  * @param id Ini merupakan parameter yang digunakan untuk 
  * mengganti nilai name
  */     
 public void setName(String name){
    this.name = name;
    }
  /**Method untuk mengganti email dari Supplier   
  * @param email Ini merupakan parameter yang digunakan 
  * untuk mengganti nilai email
  */     
 public void setEmail(String email){
    this.email = email;
    }
  /**Method untuk mengganti phoneNumber dari Supplier   
  * @param phoneNumber Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai phoneNumber
  */     
 public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
    }
  /**Method untuk mengganti location dari Supplier   
  * @param location Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai location
  */     
 public void setLocation(Location location){
    this.location = location;
    }
  /**Method untuk menampilkan nama dari supplier ke standard output.
  */    
 public String toString(){
    return ("=============SUPPLIER============="+"\nID : " + id +
    "\nNama: " + name + "\nEmail: " + email + "\nNomor Telepon: " + phoneNumber +
    "Location: " + location);    
    }
}
