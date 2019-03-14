
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction
{
    public static void orderNewItem(Supplier supplier)
    {
        Item item1 = new Item (10, "Buku", 15, ItemStatus.New, 3000, supplier, ItemCategory.Stationery);
        DatabaseItem itemDB1 = new DatabaseItem();
        itemDB1.addItem(item1);
        
        Invoice invoice1 = new Invoice (10, item1, "14 Maret 2019", item1.getPrice());
        item1.setStatus(ItemStatus.New);
        invoice1.setInvoiceStatus(InvoiceStatus.Paid);
        item1.printData();
        invoice1.printData();
        
    }
    
    public static void orderSecondItem(Supplier supplier)
    {
        Item item2 = new Item (20, "Handphone", 12, ItemStatus.Second, 5000000, supplier, ItemCategory.Electronics);
        DatabaseItem itemDB2 = new DatabaseItem();
        itemDB2.addItem(item2);
        
        Invoice invoice2 = new Invoice (20, item2, "14 Maret 2019", item2.getPrice());
        item2.setStatus(ItemStatus.Second);
        invoice2.setInvoiceStatus(InvoiceStatus.Paid);
        item2.printData();
        invoice2.printData();
        
    }
    
    public static void orderRefurbishedItem(Supplier supplier)
    {
        Item item3 = new Item (30, "Kursi", 15, ItemStatus.Refurbished, 38484, supplier, ItemCategory.Furniture);
        DatabaseItem itemDB3 = new DatabaseItem();
        itemDB3.addItem(item3);
        
        Invoice invoice3 = new Invoice (30, item3, "14 Maret 2019", item3.getPrice());
        item3.setStatus(ItemStatus.Refurbished);
        invoice3.setInvoiceStatus(InvoiceStatus.Paid);
        item3.printData();
        invoice3.printData();
        
    }
    
    public static void sellItemPaid(Item item)
    {
        Invoice invoice4 = new Invoice (10, item, "14 Maret 2019", item.getPrice());
        invoice4.setInvoiceStatus(InvoiceStatus.Paid);
        item.setStatus(ItemStatus.Sold);
        invoice4.printData();
    }
    
    public static void sellItemUnpaid(Item item)
    {
        Invoice invoice5 = new Invoice (20, item, "14 Maret 2019", item.getPrice());
        invoice5.setInvoiceStatus(InvoiceStatus.Unpaid);
        item.setStatus(ItemStatus.Sold);
        invoice5.printData();
    }
    
    public static void sellItemInstallment(Item item)
    {
        Invoice invoice6 = new Invoice (30, item, "14 Maret 2019", item.getPrice());
        invoice6.setInvoiceStatus(InvoiceStatus.Installment);
        item.setStatus(ItemStatus.Sold);
        invoice6.printData();
    }
}
