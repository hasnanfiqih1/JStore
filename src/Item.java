
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class Item
{
    private int id;
    private String name;
    private int stock;
    private int price;
    private Supplier supplier;
    private ItemStatus status;
    private ItemCategory category;


    public Item(String name, int stock, int price, ItemCategory category,
                ItemStatus status, Supplier supplier)
    {
        this.id = DatabaseItem.getLastItemId() + 1;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.category = category;
        this.status = status;
        this.supplier = supplier;
    }
    
    /**
     * Accessor Method untuk mengambil nilai ID dari objek Item
     * @return Nilai ID dari objek Item
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Accessor Method untuk mengambil String nama dari objek Item
     * @return String nama dari objek Item
     */
    public String getName()
    {
        return name;
    }
    
    /**
    * Accessor Method untuk mengambil nilai Stock dari objek Item
    * @return Nilai Stock dari objek Item
    */
    public int getStock()
    {
        return stock;
    }
    
    /**
    * Accessor Method untuk mengambil nilai harga dari objek Item
    * @return Nilai harga dari objek Item
    */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Accessor Method untuk mengambil String kategori dari objek Item
     * @return String kategori dari objek Item
     */
    public ItemCategory getCategory()
    {
        return category;
    }
    
    public ItemStatus getStatus()
    {
        return status;
    }
    
    /**
     * Accessor Method untuk mengambil Supplier dari objek Item
     * @return Supplier dari objek Item
     */
    public Supplier getSupplier()
    {
        return supplier;
    }
    
    /**
    * Mutator Method untuk mengubah ID dari objek Item
    * @param id Nilai ID yang diinginkan
    */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Item
    * @param name String Name yang diinginkan
    */
    public void setName(String name)
    {
       this.name = name;
    }
    
    /**
    * Mutator Method untuk mengubah Stock dari objek Item
    * @param stock Nilai Stock yang diinginkan
    */
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    
    /**
    * Mutator Method untuk mengubah Price dari objek Item
    * @param price Nilai Price yang diinginkan
    */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
    * Mutator Method untuk mengubah Category dari objek Item
    * @param category String Category yang diinginkan
    */
    public void setCategory(ItemCategory category)
    {
        this.category = category;
    }
    
    public void setStatus(ItemStatus status)
    {
        this.status = status;
    }
    
    /**
    * Mutator Method untuk mengubah Supplier dari objek Item
    * @param supplier Supplier yang diinginkan
    */
    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }

    public String toString()
    {
        System.out.println("==========ITEM==========");
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Stock:" + stock);
        System.out.println("Price:" + price);
        System.out.println("Category:" + category);
        System.out.println("Status:" + status);
        System.out.println("Supplier:" + supplier.getName());
        return "";
    }
}