package jstore;


public enum InvoiceType
{
    Buy("Buy"),
    Sell("Sell");
    
    private String invoiceType;

    
    private InvoiceType(String invoiceType)
    {
        this.invoiceType = invoiceType;
    }

    
    public String toString()
    {
        return this.invoiceType;
    }
}
