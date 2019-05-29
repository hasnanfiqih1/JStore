package jstore;


public enum ItemStatus
{
    New("New"), 
    Second("Second"),
    Refurbished("Refurbished"),
    Sold("Sold");
    
    private String value;

    
    ItemStatus(String name)
    {
        this.value = name;
    }

    
    public String toString()
    {
        return value;
    }
}
