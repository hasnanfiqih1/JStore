import java.util.*;

/**
 * Write a description of class Sell_Unpaid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Unpaid extends Invoice {
    // instance variables - replace the example below with your own
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Calendar dueDate = Calendar.getInstance();
    private Customer customer;
    private boolean isActive = true;

    /**
     * Constructor for objects of class Sell_Unpaid
     */
    public Sell_Unpaid(ArrayList<Integer> item, Customer customer) {
        super(item);
        this.customer = customer;
        this.dueDate.add(Calendar.DATE, 1);
        
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

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public void setInvoiceStatus(InvoiceStatus status) {
    }

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
        string += "\nDue date = " + getDueDate().getTime();
        string += "\nAktif = " + DatabaseInvoice.getInvoice(getId()).getIsActive();
        string += "\nIf payment is not received by due date, transaction will be cancelled.";
        return string;
    }
}
