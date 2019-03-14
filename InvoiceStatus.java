
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus
{
    Paid("Paid"),
    Unpaid("Unpaid"),
    Installment("Installment");
    
    private String value;
    
    private InvoiceStatus(String value)
    {
        this.value = value;
    }
    
    public String value()
    {
        return value;
    }
}
