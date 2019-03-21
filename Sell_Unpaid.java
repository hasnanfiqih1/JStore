
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
    private String dueDate;
    
    public Sell_Unpaid (int id, Item item, String date, int totalItem, int totalPrice, String dueDate)
    {
    super(id, item, date, totalItem, totalPrice);
    this.dueDate = dueDate;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public String getDueDate()
    {
        return dueDate;
    }
    
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+getId());
        System.out.println("Tanggal: "+getDate());
        System.out.println("Item: "+getItem().getName());
        System.out.println("Total Harga: "+totalPrice);
        System.out.println("Status: "+getInvoiceStatus());
        System.out.println("Due Date: "+getDueDate());
        System.out.println("===========================");
    }
}
