/**
 * Enumeration class ItemCategory 
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ItemCategory

{
    Electronics("Electronics"), Furniture("Furniture"), Stationery("Stationery");
    
    private String ItemCategory;
    
    private ItemCategory(String ItemCategory) 
    {
        this.ItemCategory = ItemCategory;
    }
    
    private String ItemCategory()
    {
        return ItemCategory();
    }
}
