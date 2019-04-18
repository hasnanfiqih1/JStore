
/**
 * Enumeration class InvoiceType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceType

{
    Buy("Buy"), Sell("Sell");
    
    private String InvoiceType;
    
    private InvoiceType(String InvoiceType) 
    {
        this.InvoiceType = InvoiceType;
    }
    
    private String InvoiceType()
    {
        return InvoiceType();
    }
}
