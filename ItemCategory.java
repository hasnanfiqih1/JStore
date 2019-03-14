
/**
 * Enumeration class ItemCategory - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ItemCategory
{
    Electronics("Electronics"),
    Furniture("Furniture"),
    Stationery("Stationery");
    
    private String value;
    
    private ItemCategory(String value)
    {
        this.value = value;
    }
    
    public String value()
    {
        return value;
    }
}
