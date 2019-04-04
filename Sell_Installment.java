
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
    private Customer customer;
    
    public Sell_Installment (int id, Item item, int totalItem, int installmentPeriod, Customer customer)
    {
    super(id, item, totalItem);
    this.installmentPeriod = installmentPeriod;
    this.customer = customer;
    }
    
    public int getInstallmentPeriod()
    {
        return installmentPeriod;
    }
    
    public int getInstallmentPrice()
    {
        return installmentPrice;
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
    
    public void setInstallmentPrice()
    {
        installmentPrice = getTotalPrice() / installmentPeriod * 102 / 100;
    }
    
    public void setTotalPrice()
    {
        setTotalPrice();
    }
    
    public void setCustomer()
    {
        this.customer = customer;
    }
    
    public String toString()
    {
        return INVOICE_TYPE+""+INVOICE_STATUS+installmentPeriod+installmentPrice+customer;
    }
}
