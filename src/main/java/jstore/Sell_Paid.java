package jstore;

import java.util.*;


public class Sell_Paid extends Invoice
{

    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    private Customer customer;

    
    public Sell_Paid(ArrayList<Integer> item, int id, Customer customer)
    {
        super(item, id);
        this.customer = customer;
        this.isActive = false;
        this.setTotalPrice();
    }

    
    public Sell_Paid(ArrayList<Integer> item, int id, Customer customer, Calendar date)
    {
        super(item, id, date);
        this.customer = customer;
        this.isActive = false;
        this.setTotalPrice();
    }

    
    public Sell_Paid(ArrayList<Integer> item, int id, Customer customer, Calendar date, boolean isActive)
    {
        super(item, id, date);
        this.customer = customer;
        this.isActive = isActive;
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

    
    public Customer getCustomer()
    {
        return customer;
    }

    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    
    public String toString(){
        StringBuilder total = new StringBuilder();
        total.append("Invoice ID : ").append(this.getId());
        total.append("\nType : ").append(this.getInvoiceType());
        total.append("\nStatus : ").append(this.getInvoiceStatus());
        total.append("\nActive : ").append(getIsActive());
        total.append("\nTotal Price : ").append(this.getTotalPrice());
        total.append("\nDaftar Item :\n");
        return total.toString();
    }
}
