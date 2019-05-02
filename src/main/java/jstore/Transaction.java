package jstore;
import java.util.*;
import java.text.*;
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction{
    private static ArrayList<Integer> item_list = new ArrayList<Integer>();


   public static void orderNewItem(Item item){

//   item.setStatus(ItemStatus.NEW);
//   list.add(item.getId());
   Invoice invNew = new Buy_Paid(item_list);
   try {
       DatabaseInvoice.addInvoice(invNew);
   } catch (InvoiceAlreadyExistsException e){}

  // // item.setStatus(ItemStatus.NEW);
   // invNew.printData();
   // item.printData();

   //newInvoice.printData();

}

   public static void orderSecondItem(ArrayList<Integer> item_list){
//   item.setStatus(ItemStatus.SECOND);
//   list.add(item.getId());
   Invoice invSecond = new Buy_Paid(item_list);
   try{
   DatabaseInvoice.addInvoice(invSecond);} catch(InvoiceAlreadyExistsException e){}
      // if (invSecond instanceof Sell_Paid){
    // System.out.println("Benar, Invoice Type adalah Sell_Paid");
    // }  else{
    // System.out.println("Salah, Invoice Type Bukan Sell_Paid");
    // }
  // // DatabaseItem.addItem(item);
   // invSecond.printData();
   // item.printData();
   //secondInvoice.printData();
    }
    public static void orderRefurbItem(ArrayList<Integer> item_list){
//   item.setStatus(ItemStatus.REFURBISHED);
//   list.add(item.getId());
   Invoice invSecond = new Buy_Paid(item_list);
//    Invoice invRefurb = new Buy_Paid(1,item_list,"21/03/2019",45,item.getPrice());
//        if (invRefurb instanceof Sell_Paid){
//     System.out.println("Benar, Invoice Type adalah Sell_Paid");
//     }  else{
//     System.out.println("Salah, Invoice Type Bukan Sell_Paid");
//     }
//   DatabaseItem.addItem(item);
//
//   item.setStatus(ItemStatus.REFURBISHED);
//    invRefurb.printData();
//    item.printData();
//   refurbInvoice.printData();
    }
   public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer){

//        item.setStatus(ItemStatus.SOLD);
//       list.add(item.getId());
       Invoice invSP = new Sell_Paid(item_list, customer);

  
        // invSP.printData();
        // item.printData();
        
    //paidInv.printData();
    }
   public static void sellItemUnpaid(ArrayList<Integer> item_list,Customer customer){
//       item.setStatus(ItemStatus.SOLD);
//       list.add(item.getId());
       Invoice invSU = new Sell_Unpaid(item_list, customer);
       
    // //item.setStatus(ItemStatus.SOLD);
        // invSU.printData();
        // item.printData();
    //unpaidInv.printData();
    }
   public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentperiod){
//       item.setStatus(ItemStatus.SOLD);
//       list.add(item.getId());
       Invoice invSI = new Sell_Installment(item_list,installmentperiod,customer);
       
   // Invoice invSI = new Sell_Installment(1,item,"21/03/2019",item.getPrice(),431,5);   
   // // item.setStatus(ItemStatus.SOLD);
        // invSI.printData();
        // item.printData();
    //installmentInv.printData();
    }    
   public static boolean finishTransaction(Invoice invoice){
       if((invoice.getInvoiceStatus() == InvoiceStatus.UNPAID) || invoice.getInvoiceStatus() == InvoiceStatus.INSTALLMENT){
       for(Invoice inv : DatabaseInvoice.getInvoiceDatabase()) {
           if (invoice == inv) {
               invoice.setIsActive(false);
               System.out.println(invoice.getIsActive());
           }
       }
       }
       return false;
    }
   public static boolean cancelTransaction(Invoice invoice){
       if((invoice.getInvoiceStatus() == InvoiceStatus.UNPAID) || (invoice.getInvoiceStatus() == InvoiceStatus.INSTALLMENT)) {
           for (Invoice inv : DatabaseInvoice.getInvoiceDatabase()) {
               if (invoice.getId() == inv.getId()) {
                   try {
                       DatabaseInvoice.removeInvoice(invoice.getId());
                       return true;
                   } catch (InvoiceNotFoundException e) {
                       return false;
                   }
               }
           }
       }

       return false;
   }

}