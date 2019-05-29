package jstore;

import java.util.*;


public class Sell_Unpaid extends Invoice
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Customer customer;
    private Calendar dueDate;

    
    public Sell_Unpaid(ArrayList<Integer> item, int id, Customer customer)
    {
        super(item, id);
        this.customer = customer;
        this.isActive = true;
        this.setTotalPrice();
        this.dueDate =  new GregorianCalendar();
        this.dueDate.add(Calendar.MONTH,6); // duedate merupakan +6 bulan dari tanggal pembuatan invoice
    }

    
    public Sell_Unpaid(ArrayList<Integer> item, int id, Customer customer, Calendar date)
    {
        super(item, id, date);
        this.customer = customer;
        this.isActive = true;
        this.setTotalPrice();
        this.dueDate =  date.getInstance();
        this.dueDate.add(Calendar.MONTH,6); // duedate merupakan +6 bulan dari tanggal pembuatan invoice
    }

    
    public Sell_Unpaid(ArrayList<Integer> item, int id, Customer customer, Calendar date, boolean isActive)
    {
        super(item, id, date);
        this.customer = customer;
        this.isActive = isActive;
        this.setTotalPrice();
        this.dueDate =  date.getInstance();
        this.dueDate.add(Calendar.MONTH,6); // duedate merupakan +6 bulan dari tanggal pembuatan invoice
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

    
    public String toString() {
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
