
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Paid extends Invoice 
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    private Customer customer;
    
    public Sell_Paid (int id, Item item, int totalItem, Customer customer)
    {
    super(id, item, totalItem);
    this.customer = customer;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public String toString()
    {
        return INVOICE_TYPE+""+INVOICE_STATUS+customer;
    }
}
