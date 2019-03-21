
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Installment extends Invoice 
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private int installmentPeriod;
    private int installmentPrice;
    
    public Sell_Installment (int id, Item item, String date, int totalItem, int totalPrice, int installmentPeriod)
    {
    super(id, item, date, totalItem, totalPrice);
    this.installmentPeriod = installmentPeriod;
    }
    
    public int getInstallmentPeriod()
    {
        return installmentPeriod;
    }
    
    public int getInstallmentPrice()
    {
        return installmentPrice;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public void setInstallmentPrice()
    {
        installmentPrice = totalPrice / installmentPeriod * 102 / 100;
    }
    
    public void setTotalPrice()
    {
        totalPrice = installmentPrice * installmentPeriod;
    }
    
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID: "+getId());
        System.out.println("Tanggal: "+getDate());
        System.out.println("Item: "+getItem().getName());
        System.out.println("Total Harga: "+totalPrice);
        System.out.println("Status: "+getInvoiceStatus());
        System.out.println("Installment Price: "+getInstallmentPrice());
        System.out.println("===========================");
    }
}
