package jstore;

import java.util.*;

public abstract class Invoice
{
    private int id;
    private int totalPrice;
    private ArrayList<Integer> item;
    private Calendar date;
    protected boolean isActive;
    private Customer customer;

    
    public Invoice(ArrayList<Integer> item, int id)
    {
        this.item = item;
        this.date = GregorianCalendar.getInstance();
        this.id = id;
    }

    
    public Invoice(ArrayList<Integer> item, int id,Calendar date)
    {
        this.item = item;
        this.date = date;
        this.id = id;
    }

    
    public int getId()
    {
        return this.id;
    }

    
    public ArrayList<Integer> getItem()
    {
        return this.item;
    }

    
    public Calendar getDate()
    {
        return this.date;
    }

    
    public int getTotalPrice()
    {
        return this.totalPrice;
    }

    public abstract InvoiceStatus getInvoiceStatus();
    
    public abstract InvoiceType getInvoiceType();

    
    public boolean getIsActive(){
        return isActive;
    }

    
    public Customer getCustomer(){
        return customer;
    }

    
    public void setId(int id)
    {
        this.id = id;
    }

    
    public void setItem(ArrayList<Integer> item)
    {
        this.item = item;
    }

    
    public void setDate(Calendar date)
    {
        this.date = date;
    }

    
    public void setTotalPrice()
    {
        DatabaseItemPostgre dbItem = new DatabaseItemPostgre();
        dbItem.connect();
        int total = 0;
        for(int id : this.item){
            Item temp = null;
            try {
                temp = dbItem.getItemById(id);
            } catch (ItemNotFoundException e) {
                e.printStackTrace();
            }
            int priceTemp = 0;
            if (temp != null) {
                priceTemp = temp.getPrice();
            }
            total += priceTemp;
        }
        dbItem.disconnect();
        this.totalPrice = total;
    }


    
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    
    public abstract String toString();
}
