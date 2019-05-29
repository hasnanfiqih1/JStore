package jstore;


public class Location
{
    private String province, description, city;

    
    public Location(String city, String province, String description)
    {
        // initialise instance variables
        this.city = city;
        this.province = province;
        this.description = description;
    }

    
    public String getProvince()
    {
        return this.province;
    }

    
    public String getCity()
    {
        return this.city;
    }

    
    public String getDescription()
    {
        return this.description;
    }

    
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public String toString(){
        return "Provinsi: " + province + "\nCity: " + city +"\nDescription: " + description;
    }
}
