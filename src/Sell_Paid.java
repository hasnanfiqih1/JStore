import java.util.*;

/**
 * Write a description of class Sell_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Paid extends Invoice {
    // instance variables - replace the example below with your own
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    private Customer customer;
    private boolean isActive = false;

    /**
     * Constructor for objects of class Sell_Paid
     */
    public Sell_Paid(ArrayList<Integer> item, Customer customer) {
        super(item);
        // this.totalPrice = totalItem * item.getPrice();
        this.customer = customer;
    }

    public InvoiceStatus getInvoiceStatus() {
        return INVOICE_STATUS;
    }

    public InvoiceType getInvoiceType() {
        return INVOICE_TYPE;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInvoiceStatus(InvoiceStatus status) {
    }

    // public void printData()
    // {
    // System.out.println("========Invoice========");
    // System.out.println("ID = " + getId());
    // System.out.println("Item = " + getItem().getName());
    // System.out.println("Tanggal = " + getDate());
    // System.out.println("Harga = " + totalPrice);
    // System.out.println("Jumlah = " + getTotalItem());
    // System.out.println("Harga = " + totalPrice);
    // System.out.println("Status = " + INVOICE_STATUS);
    // System.out.println("Tipe = " + INVOICE_TYPE);
    // System.out.println("=========================");
    // }
    public String toString() {
        String string = "=====Invoice=====";
        string += "\nID = " + getId();
        string += "\nBuy date = " + getDate().getTime();
        for (Integer invoice : getItem()) {
            Item item = DatabaseItem.getItemFromID(invoice.intValue());
            string += "\nItem = " + item.getName();
            string += "\nAmount = " + getItem().size();
            string += "\nPrice = " + item.getPrice();
            string += "\nSupplier ID = " + item.getSupplier().getId();
            string += "\nSupplier Name = " + item.getSupplier().getName();
        }
        string += "\nTotal Price = " + getTotalPrice();
        string += "\nCustomer ID = " + customer.getId();
        string += "\nCustomer Name = " + customer.getName();
        string += "\nStatus = " + INVOICE_STATUS;
        string += "\nSell Success";
        return string;
    }
}
