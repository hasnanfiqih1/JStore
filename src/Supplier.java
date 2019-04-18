/**
 * Supplier Class
 *
 * @Senna Faris
 * @version 28/02/19
 */
public class Supplier {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor
     */
    public Supplier(String name, String email, String phoneNumber, Location location) {
        this.id = DatabaseSupplier.getLastSupplierID() + 1;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    public int getId()
    /***
     * Accessor for ID
     */
    {
        return id;
    }

    public String getName()
    /***
     * Accessor for name
     */
    {
        return name;
    }

    public String getEmail()
    /***
     * Accessor for email
     */
    {
        return email;
    }

    public String getPhoneNumber()
    /***
     * Accessor for Phone Number
     */
    {
        return phoneNumber;
    }

    public Location getLocation()
    /***
     * Accessor for Location
     */
    {
        return location;
    }

    public void setId(int id)
    /***
     * Mutator of ID
     */
    {
        this.id = id;
    }

    public void setName(String name)
    /***
     * Mutator of name
     */
    {
        this.name = name;
    }

    public void setEmail(String email)
    /***
     * Mutator of email
     */
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    /***
     * Mutator of Phone Number
     */
    {
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(Location location)
    /***
     * Mutator of Location
     */
    {
        this.location = location;
    }

    /**
     * This method is to print the name value of the instance
     */
    // public void printData()
    // {
    // System.out.println("Supplier dan ID");
    // System.out.println("ID = " + id);
    // System.out.println("Nama = " + name);
    // System.out.println("Email = " + email);
    // System.out.println("No. Telpon = " + phoneNumber);
    // System.out.println("Lokasi = " + location.getProvince());
    // }
    public String toString() {
        return "ID : " + id + "\nNama : " + name + "\nEmail : " + email + "\nTelpon : " + phoneNumber + "\nLokasi : "
                + location.getProvince()+ "\n\n";
    }
}
