
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class Location
{
    private String province;
    private String description;
    private String city;
    
    public Location(String city, String province, String description)
    {
       this.city = city;
       this.province = province;
       this.description = description;
    }
    
    public String getProvince()
    {
        return province;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void printData()
    {
     System.out.println("==========LOCATION==========");
     System.out.println("Provinsi: "+province);
     System.out.println("Kota: "+city);
     System.out.println("Deskripsi: "+description);
     System.out.println("============================");
    }
}
