package jstore;

public class Location
{
    //inisialisasi variabel
    private String province,description,city;
    //Constructor location
    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
       
    }
  /**Method untuk mengganti province dari Location  
  * @param province Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai province
  */     
    public void setProvince(String province){
    this.province = province;
    }
  /**Method untuk mengganti city dari Location  
  * @param city Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai city
  */        
    public void setCity(String city){
    this.city = city;
    }
  /**Method untuk mengganti description dari Location  
  * @param description Ini merupakan parameter yang digunakan untuk mengganti 
  * nilai description
  */        
    public void setDescription(String description){
    this.description = description;
    }
 /**Method untuk mendapatkan province dari Location   
  * @return String return isi dari province
  */    
    public String getProvince(){
    return province;
    }
 /**Method untuk mendapatkan city dari Location   
  * @return String return isi dari city
  */       
    public String getCity(){
    return city;
    }
 /**Method untuk mendapatkan description dari Location   
  * @return String return isi dari description
  */       
    public String getDescription(){
    return description;
    }
 /**Method untuk menampilkan  Location
  */       
    public String toString(){
    return ("\n=============LOCATION============="+
    "\nProvinsi : " + province 
    +"\nKota: " + city 
    +"\nDeskripsi: " + description);
    }
}
