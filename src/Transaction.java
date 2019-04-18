import java.util.*;

public class Transaction
{
    public static void orderNewItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void orderSecondItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void orderRefurbishedItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Paid(item_list, customer));
    }

    public static void sellItemUnpaid(ArrayList<Integer> item_list, Customer customer) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Unpaid(item_list, customer));
    }

    public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentPeriod) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Installment(item_list, installmentPeriod, customer));
    }

    public static boolean finishTransaction(Invoice invoice)
    {
        if(invoice.getInvoiceStatus().equals(InvoiceStatus.Installment)
                || invoice.getInvoiceStatus().equals(InvoiceStatus.Unpaid)){
            for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase()){
                if (invoiceDB.getId() == invoice.getId()) {
                    invoice.setIsActive(false);
                    System.out.println("Invoice Status : " + invoice.getIsActive());
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cancelTransaction(Invoice invoice) throws InvoiceNotFoundException {
        if(invoice.getInvoiceStatus().equals(InvoiceStatus.Installment)
                || invoice.getInvoiceStatus().equals(InvoiceStatus.Unpaid)){
            for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase()) {
                if (invoiceDB.getId() == invoice.getId()) {
                    DatabaseInvoice.removeInvoice(invoice.getId());
                    return true;
                }
            }
        }
        return false;
    }
}