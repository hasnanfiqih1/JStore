
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class Supplier
{
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;


    public Supplier(String name, String email, String phoneNumber, Location location)
    {
        this.id=DatabaseSupplier.getLastSupplierId() + 1;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.location=location;
    }
    
    /**
     * Accessor Method untuk mengambil nilai ID dari objek Supplier
     * @return Nilai ID dari objek Supplier
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Accessor Method untuk mengambil String nama dari objek Supplier
     * @return String nama dari objek Supplier
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor Method untuk mengambil String alamat email dari objek Supplier
     * @return String email dari objek Supplier
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Accessor Method untuk mengambil String nomor telepon dari objek Supplier
     * @return String PhoneNumber dari objek Supplier
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Accessor Method untuk mengambil lokasi dari objek Supplier
     * @return Location dari objek Supplier
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
    * Mutator Method untuk mengubah ID dari objek Supplier
    * @param id Nilai ID yang diinginkan
    */
    public void setId(int id)
    {
        this.id=id;
    }
    
    /**
     * Mutator Method untuk mengubah nama dari objek Supplier
     * @param name String name yang diinginkan
     */
    public void setName(String name)
    {
        this.name=name;
    }
    
    /**
    * Mutator Method untuk mengubah Email dari objek Supplier
    * @param email String Email yang diinginkan
    */
    public void setEmail(String email){
        this.email=email;
    }
    
    /**
     * Mutator Method untuk mengubah nomor telepon dari objek supplier
     * @param phoneNumber String PhoneNumber yang diinginkan
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }
    
    /**
    * Mutator Method untuk mengubah Location dari objek Supplier
    * @param location Location yang diinginkan
    */
    public void setLocation(Location location)
    {
       this.location=location;
    }

    public String toString()
    {
        System.out.println("==========SUPPLIER==========");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("PhoneNumber: " + phoneNumber);
        System.out.println("Location: " + location.getCity());
        return "";
    }
}
