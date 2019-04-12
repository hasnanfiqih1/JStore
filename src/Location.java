
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class Location
{
    private String province;
    private String description;
    private String city;


    public Location(String city, String province, String description)
    {
        this.city=city;
        this.province=province;
        this.description=description;
    }

    /**
    * Accessor Method untuk mengambil String Province dari objek Location
    * @return String Province dari objek Location
    */
    public String getProvince()
    {
        return province;
    }
    
    /**
    * Accessor Method untuk mengambil String City dari objek Location
    * @return String City dari objek Location
    */
    public String getCity()
    {
        return city;
    }
    
    /**
    * Accessor Method untuk mengambil String Description dari objek Location
    * @return String Description dari objek Location Object
    */
    public String getDescription()
    {
        return description;
    }
    
    /**
    * Mutator Method untuk mengubah provinsi dari objek Location
    * @param province String Province yang diinginkan
    */
    public void setProvince(String province)
    {
        this.province=province;
    }
    
    /**
    * Mutator Method untuk mengubah City dari objek Location
    * @param City String City yang diinginkan
    */
    public void setCity(String city)
    {
        this.city=city;
    }

    /**
    * Mutator Method untuk mengubah Description dari objek Location
    * @param description String Description yang diinginkan
    */
    public void setDescription(String Description)
    {
        this.description=description;
    }

    public String toString()
    {
        System.out.println("==========LOCATION==========");
        System.out.println("Province: " + province);
        System.out.println("City: " + city);
        System.out.println("Description: " + description);
        return "";
    }
}
