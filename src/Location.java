
/**
 * Location Class
 *
 * @Senna Faris
 * @version 28/02/19
 *
 */
public class Location {
    private String province;
    private String description;
    private String city;

    /**
     * Constructor
     */
    public Location(String province, String description, String city) {
        this.province = province;
        this.description = description;
        this.city = city;
    }

    public String getProvince()
    /***
     * Accessor for Province value
     */
    {
        return province;
    }

    public String getCity()
    /***
     * Accessor for City value
     */
    {
        return city;
    }

    public String getDescription()
    /***
     * Accessor for Description value
     */
    {
        return description;
    }

    public void setProvince(String province)
    /***
     * Mutator of Province value
     */
    {
        this.province = province;
    }

    public void setCity(String city)
    /***
     * Mutator of City value
     */
    {
        this.city = city;
    }

    public void setDescription(String description)
    /***
     * Mutator of Description value
     */
    {
        this.description = description;
    }

    /**
     * This method is used to print the province of the instance
     */
    // public void printData()
    // {
    // System.out.println("Lokasi");
    // System.out.println("Provinsi = " + province);
    // System.out.println("Deskripsi = " + description);
    // System.out.println("Kota = " + city);
    // }
    public String toString() {
        return "Provinsi : " + province + "Deskripsi : " + description + "Kota : " + city;
    }

}
