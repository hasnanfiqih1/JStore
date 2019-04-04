
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Buy_Paid extends Invoice 
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    
    public Buy_Paid (int id, Item item, int totalItem)
    {
    super(id, item, totalItem);
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public String toString()
    {
        return INVOICE_TYPE+""+INVOICE_STATUS;
    }
}
