package jstore;


public enum InvoiceStatus
{
    Paid("Paid"),
    Unpaid("Unpaid"),
    Installment("Installment");
    
    private String value;

    
    InvoiceStatus(String name)
    {
        this.value = name;
    }

    
    public String toString()
    {
        return this.value;
    }
}
