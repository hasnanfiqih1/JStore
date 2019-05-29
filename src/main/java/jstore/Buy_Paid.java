package jstore;

import java.util.ArrayList;

public class Buy_Paid extends Invoice
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    
    public Buy_Paid(ArrayList<Integer> item,int id)
    {
        super(item,id);
        this.isActive = false;
        this.setTotalPrice();
    }

    
    public InvoiceStatus getInvoiceStatus() 
    {
        return INVOICE_STATUS;
    }

    
    public InvoiceType getInvoiceType() 
    {
        return INVOICE_TYPE;
    }

    
    public String toString(){
        StringBuilder total = new StringBuilder();
        total.append("Invoice ID : ").append(this.getId());
        total.append("\nType : ").append(this.getInvoiceType());
        total.append("\nStatus : ").append(this.getInvoiceStatus());
        total.append("\nActive : ").append(getIsActive());
        total.append("\nTotal Price : ").append(this.getTotalPrice());
        return total.toString();
    }
}
