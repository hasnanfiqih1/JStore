
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction
{
    public static void orderNewItem(Item item)
    {
        Invoice item1 = new Buy_Paid(11, item, "21 Maret 2019", 2, item.getPrice());
        DatabaseItem itemDB1 = new DatabaseItem();
        itemDB1.addItem(item);
        
        item1.printData();
        
        if (item1 instanceof Sell_Paid)
        {
            System.out.println("Benar Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type bukan Sell_Paid");
        }
    }
    
    public static void orderSecondItem(Item item)
    {
     Invoice item1 = new Buy_Paid(11, item, "21 Maret 2019", 2, item.getPrice());
        DatabaseItem itemDB1 = new DatabaseItem();
        itemDB1.addItem(item);
        
        item1.printData();
        
        if (item1 instanceof Sell_Paid)
        {
            System.out.println("Benar Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type bukan Sell_Paid");
        }
    }
    
    public static void orderRefurbishedItem(Item item)
    {
        Invoice item1 = new Buy_Paid(11, item, "21 Maret 2019", 2, item.getPrice());
        DatabaseItem itemDB1 = new DatabaseItem();
        itemDB1.addItem(item);
        
        item1.printData();
        
        if (item1 instanceof Sell_Paid)
        {
            System.out.println("Benar Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type bukan Sell_Paid");
        }
    }
    
    public static void sellItemPaid(Item item)
    {
        Invoice item2 = new Sell_Paid (22, item, "21 Maret 2019", 3, item.getPrice());
        item2.printData();
    }
    
    public static void sellItemUnpaid(Item item)
    {
        Invoice item3 = new Sell_Unpaid (33, item, "21 Maret 2019", 4, item.getPrice(), "30 Maret 2019");
        item3.printData();
    }
    
    public static void sellItemInstallment(Item item)
    {
        Invoice item4 = new Sell_Installment (44, item, "21 Maret 2019", 4, item.getPrice(), 3);
        item4.printData();
    }
}
