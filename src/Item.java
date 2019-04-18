public class Item {
    private int id;
    private String name;
    private int price;
    private ItemCategory category;
    private ItemStatus status;
    private Supplier supplier;

    /**
     * Constructor of Item
     */
    public Item(String name, ItemStatus status, int price, ItemCategory category, Supplier supplier) {
        this.id = DatabaseItem.getLastItemID() + 1;
        this.name = name;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
        this.status = status;
        this.category = category;
    }

    public int getId()
    /**
     * Accessor for ID
     */
    {
        return id;
    }

    public String getName()
    /**
     * Accessor for name value
     */
    {
        return name;
    }
    public int getPrice()
    /**
     * Accessor for price value
     */
    {
        return price;
    }

    public ItemCategory getCategory()
    /**
     * Accessor for category value
     */
    {
        return category;
    }

    public ItemStatus getStatus()
    /**
     * Accessor for category value
     */
    {
        return status;
    }

    public Supplier getSupplier()
    /**
     * Accessor for supplier value
     */
    {
        return supplier;
    }

    public void setId(int id)
    /**
     * Mutator for id
     */
    {
        this.id = id;
    }

    public void setName(String name)
    /**
     * Mutator for name
     */
    {
        this.name = name;
    }
    public void setPrice(int price)
    /**
     * Mutator for price
     */
    {
        this.price = price;
    }

    public void setCategory(ItemCategory category)
    /**
     * Mutator for category
     */
    {
        this.category = category;
    }

    public void setStatus(ItemStatus category)
    /**
     * Mutator for category
     */
    {
        this.status = status;
    }

    public void setSupplier(Supplier supplier)
    /**
     * Mutator for supplier
     */
    {
        this.supplier = supplier;
    }

    // public void printData()
    // /**
    // * This method will print the name value of the instance
    // */
    // {
    // System.out.println("==========Item===========");
    // System.out.println("ID = " + id);
    // System.out.println("Nama = " + name);
    // System.out.println("Kategori = " + category);
    // System.out.println("Status = " + status);
    // System.out.println("Supplier = " + supplier.getName());
    // System.out.println("=========================");
    // }

    public String toString() {
        return "ID : " + id + "\nNama : " + name + "\nPrice : " + price + "\nCategory : " + category
                + "\nStatus : " + status + "\nSupplier : " + supplier.getName() + "\n\n";
    }
}
