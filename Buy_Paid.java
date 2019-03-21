
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
    
    public Buy_Paid (int id, Item item, String date, int totalItem, int totalPrice)
    {
    super(id, item, date, totalItem, totalPrice);
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+getId());
        System.out.println("Tanggal: "+getDate());
        System.out.println("Item: "+getItem().getName());
        System.out.println("Total Harga: "+totalPrice);
        System.out.println("Status: "+getInvoiceStatus());
        System.out.println("===========================");
    }
}
