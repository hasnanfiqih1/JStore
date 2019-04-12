import java.util.*;

public abstract class Invoice
{
    //variabel yang dipakai
    private int id;
    private ArrayList<Integer> item;
    private Calendar date;
    private int totalPrice;
    private boolean isActive;
    private Customer customer;
    private static InvoiceStatus status;

    
    
    //Konstruktor dari kelas Invoice   
    public Invoice(ArrayList<Integer> item)
    {
        this.id = DatabaseInvoice.getLastInvoiceId() + 1;
        this.item = item;
        this.date = new GregorianCalendar();
    }

    //Menampilkan nomor id invoice    
    public int getId()
    {
        return id;
    }

    //Menampilkan nama Item
    public ArrayList<Integer> getItem()
    {
        return item;
    }

    //Menampilkan tanggal    
    public Calendar getDate()
    {
        return date;
    }

    //Menampilkan total harga  
    public int getTotalPrice()
    {
        return totalPrice;
    }

    public abstract InvoiceStatus getInvoiceStatus();

    public abstract InvoiceType getInvoiceType();

    public boolean getIsActive()
    {
        return isActive;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    //Menampilkan Status Invoice
    //public abstract InvoiceStatus getInvoiceStatus();
    
   // public abstract InvoiceType getInvoiceType();
    
    //Mengubah id Item    
    public void setId(int id)
    {
        this.id = id;
    }

    //Mengubah nama Item    
    public void setItem(ArrayList<Integer> item)
    {
        this.item = item;
    }

    //Mengubah tanggal    
    public void setDate(Calendar date)
    {
        this.date = date;
    }

    //Mengubah total harga    
    public void setTotalPrice(int totalPrice)
    {
        ArrayList<Integer> listItemID = DatabaseInvoice.getInvoice(id).getItem();
        for(int tempID : listItemID)
        {
            this.totalPrice = totalPrice + DatabaseItem.getItemFromID(tempID).getPrice();
        }
    }

    public void setInvoiceStatus(InvoiceStatus status)
    {
        status = status;
    }

    //Mengubah total item  
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    //Mengganti InvoiceStatus 
    //public abstract void setInvoiceStatus(InvoiceStatus status);
    
    //public abstract String toString();
}