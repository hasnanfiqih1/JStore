package jstore;
import java.util.*;

/**
 * Write a description of class Sell_Installment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Installment extends Invoice {
    // instance variables - replace the example below with your own
    private InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private int installmentPeriod;
    private int installmentPrice;
    private Customer customer;
    private boolean isActive = true;

    /**
     * Constructor for objects of class Sell_Installment
     */
    public Sell_Installment(ArrayList<Integer> item, int installmentPeriod, Customer customer) {
        super(item);
        this.installmentPeriod = installmentPeriod;
        this.installmentPrice = installmentPrice;
        this.customer = customer;
    }

    public InvoiceStatus getInvoiceStatus() {
        return INVOICE_STATUS;
    }

    public InvoiceType getInvoiceType() {
        return INVOICE_TYPE;
    }

    public int getInstallmentPeriod() {
        return installmentPeriod;
    }

    public int getInstallmentPrice() {
        return installmentPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setInstallmentPrice() {
        // this.installmentPrice = totalPrice / installmentPeriod * 102 / 100;
    }

    public void setTotalPrice() {
        // this.totalPrice = installmentPrice * installmentPeriod;
    }

    public void setInvoiceStatus(InvoiceStatus status) {
    }

    public void setCustomer() {
        this.customer = customer;
    }

    // public void printData()
    // {
    // System.out.println("========Invoice========");
    // System.out.println("ID = " + getId());
    // System.out.println("Item = " + getItem().getName());
    // System.out.println("Tanggal = " + getDate());
    // System.out.println("Jumlah = " + getTotalItem());
    // System.out.println("Status = " + INVOICE_STATUS);
    // System.out.println("Tipe = " + INVOICE_TYPE);
    // System.out.println("Periode Pemasangan = " + installmentPeriod);
    // System.out.println("Harga Pemasangan = " + installmentPrice);
    // //System.out.println("Total Harga = " + totalPrice);
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
        string += "\nInstallment Price = " + installmentPrice;
        string += "\nCustomer ID = " + customer.getId();
        string += "\nCustomer Name = " + customer.getName();
        string += "\nStatus = " + INVOICE_STATUS;
        string += "\nAktif = " + DatabaseInvoice.getInvoice(getId()).getIsActive();
        string += "\nInstallment period = " + installmentPeriod;
        string += "\nSell Success";
        return string;
    }
}
