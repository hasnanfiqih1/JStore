package jstore;


public enum ItemCategory
{
    Electronics("Electronics"),
    Furniture("Furniture"),
    Stationery("Stationery");
    
    private String value;

    
    ItemCategory(String name)
    {
        this.value = name;
    }

    
    public String toString()
    {
        return this.value;
    }
}
