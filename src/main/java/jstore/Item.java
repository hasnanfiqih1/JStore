package jstore;


public class Item
{
    private int id;
    private String name;
    private int price;
    private ItemCategory category; // from enum 
    private ItemStatus status; // from enum
    private Supplier supplier; // instance of class Supplier

    
    public Item(int id, String name, ItemStatus status, int price, Supplier supplier, ItemCategory category)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.status = status;
        this.supplier = supplier;
    }

    
    public int getId()
    {
        return this.id;
    }

    
    public String getName()
    {
        return this.name;
    }

    
    public int getPrice()
    {
        return this.price;
    }

    
    public ItemCategory getCategory()
    {
        return this.category;
    }

    
    public ItemStatus getStatus()
    {
        return this.status;
    }

    
    public Supplier getSupplier()
    {
        return this.supplier;
    }

    
    public void setId(int id)
    {
        this.id = id;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }


    
    public void setStatus(ItemStatus status)
    {
        
        this.status = status;
    }

    
    public String toString(){
        return "Item ID: " +id+ "\nName: " +name+ "\nPrice: " +price+ "\nCategory: " +category+ "\nStatus: " +status+ "\nSupplier: \n" +supplier;
    }
}
