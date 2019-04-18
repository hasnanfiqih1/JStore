import java.util.*;

/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Buy_Paid extends Invoice {
    // Instance variables
    private InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    private boolean isActive = false;

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Buy_Paid(ArrayList<Integer> item) {
        super(item);
        // this.totalPrice = totalItem * item.getPrice();
    }

    public InvoiceStatus getInvoiceStatus() {
        return INVOICE_STATUS;
    }

    public InvoiceType getInvoiceType() {
        return INVOICE_TYPE;
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
    // System.out.println("Status = " + INVOICE_STATUS);
    // System.out.println("Tipe = " + INVOICE_TYPE);
    // System.out.println("=========================");
    // }

    public String toString() {
        String string = "=====Invoice=====";
        string += "\nID = " + getId();
        string += "\nBuy date = " + getDate();
        for (Integer invoice : getItem()) {
            Item item = DatabaseItem.getItemFromID(invoice.intValue());
            string += "\nItem = " + item.getName();
            string += "\nAmount = " + getItem().size();
            string += "\nPrice = " + item.getPrice();
            string += "\nSupplier ID = " + item.getSupplier().getId();
            string += "\nSupplier Name = " + item.getSupplier().getName();
        }
        string += "\nTotal Price = " + getTotalPrice();
        string += "\nStatus = " + INVOICE_STATUS;
        string += "\nBuy Success";
        return string;

    }
}
