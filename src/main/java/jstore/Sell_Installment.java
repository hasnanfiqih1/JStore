package jstore;

import java.util.ArrayList;
import java.util.Calendar;


public class Sell_Installment extends Invoice
{
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private double installmentPeriod;
    private double installmentPrice;
    private Customer customer;

    
    public Sell_Installment(ArrayList<Integer> item, int id, int installmentPeriod, Customer customer)
    {
        super(item, id);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
        this.isActive = true;
        this.setTotalPrice();
        this.setInstallmentPrice();
    }

    
    public Sell_Installment(ArrayList<Integer> item, int id, int installmentPeriod, Customer customer, Calendar date)
    {
        super(item, id, date);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
        this.isActive = true;
        this.setTotalPrice();
        this.setInstallmentPrice();
    }

    
    public Sell_Installment(ArrayList<Integer> item, int id, int installmentPeriod, Customer customer, Calendar date, boolean isActive)
    {
        super(item, id, date);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
        this.isActive = isActive;
        this.setTotalPrice();
        this.setInstallmentPrice();
    }

    
    public double getInstallmentPeriod()
    {
        return installmentPeriod;
    }

    
    public double getInstallmentPrice()
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
        installmentPrice = (this.getTotalPrice()/installmentPeriod);
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
        total.append("\nActive : ").append(this.getIsActive());
        total.append("\nPeriod : ").append(this.getInstallmentPeriod());
        total.append("\nTotal Price : ").append(this.getTotalPrice());
        total.append("\nInstallment Price :").append(this.getInstallmentPrice());
        return total.toString();
    }
}
