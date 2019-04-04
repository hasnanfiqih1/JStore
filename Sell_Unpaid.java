import java.util.Calendar;
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Unpaid extends Invoice 
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Calendar dueDate = Calendar.getInstance();
    private Customer customer;
    
    public Sell_Unpaid (int id, Item item, int totalItem, Customer customer)
    {
    super(id, item, totalItem);
    this.customer = customer;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Calendar getDueDate()
    {
        return dueDate;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setDueDate(Calendar dueDate)
    {
        this.dueDate = dueDate;
    }
    
    public String toString()
    {
        return INVOICE_TYPE+""+INVOICE_STATUS+dueDate+customer;
    }
}
