
/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceType
{
    Buy("Buy"),
    Sell("Sell");
    
    private String value;
    
    private InvoiceType(String value)
    {
        this.value = value;
    }
    
    public String value()
    {
        return value;
    }
}
