import java.util.*;

public abstract class Invoice {
    // Instance Variables
    private int id;
    private ArrayList<Integer> item;
    private Calendar date = Calendar.getInstance();
    private int totalPrice;
    private boolean isActive = true;
    private Customer customer;

    /**
     * Constructor
     */
    public Invoice(ArrayList<Integer> item) {
        this.item = item;
        id = DatabaseInvoice.getLastInvoiceID() + 1;
        // this.totalPrice = totalItem * item.getPrice();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getItem() {
        return item;
    }

    public Calendar getDate() {
        return date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract InvoiceStatus getInvoiceStatus();

    public abstract InvoiceType getInvoiceType();

    public void setId(int id)
    /***
     * Mutator for ID
     */
    {
        this.id = id;
    }

    public void setItem(ArrayList<Integer> item)
    /***
     * Mutator for Item
     */
    {
        this.item = item;
    }

    public void setDate(Calendar date)
    /***
     * Mutator for Date
     */
    {
        this.date = date;
    }

    public void setTotalPrice(int totalPrice)
    /***
     * Mutator for Total Price
     */
    {
        ArrayList<Integer> listItemID = DatabaseInvoice.getInvoice(id).getItem();
        for (int invoice : listItemID) {
            this.totalPrice = totalPrice + DatabaseItem.getItemFromID(invoice).getPrice();
        }
    }

    public void setInvoiceStatus(InvoiceStatus status) {
        // this.status = status;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public abstract String toString();
    // public abstract void printData();
    // public String toString() {
    // return toString();
    // }
}
