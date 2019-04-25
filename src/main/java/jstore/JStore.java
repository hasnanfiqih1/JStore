package jstore;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class JStore{

    public JStore(){

    }
    public static void main (String[] args){
        SpringApplication.run(JStore.class, args);
        /*ArrayList<Integer> item_list = new ArrayList<>();
        item_list.add(3);
        item_list.add(4);
        Location JakartaTimur = new Location("Jakarta Timur","DKI Jakarta","Jakarta yang ada di timur");
        Item item = new Item("Halo", ItemStatus.New,1000,ItemCategory.Electronics, DatabaseSupplier.getSupplier(1));

        try{
            DatabaseSupplier.addSupplier(new Supplier("Supply Com","supplgrarco@ui.ac.id","+62812139590999",JakartaTimur));
            DatabaseSupplier.addSupplier(new Supplier("Supply Com","supplgrarco@ui.ac.id","+62812139590999",JakartaTimur));
            DatabaseSupplier.addSupplier(new Supplier("Suply Com","supplgraro@ui.ac.id","+62812169590999",JakartaTimur));
        } catch (SupplierAlreadyExistsException e){System.out.println(e.getExMessage());}
        try{
            DatabaseCustomer.addCustomer(new Customer("Hasnan", "hasnanfiqih@gmail.com", "hasnan", "qwerty", 2007,9,9));
            DatabaseCustomer.addCustomer(new Customer("Hasnan", "hasnanfiqih@gmail.com", "hasnan", "qwerty", 2007,9,9));
            DatabaseCustomer.addCustomer(new Customer("Fiqih", "hasnanfiqih1@gmail.com", "fiqih", "asdfg", 2097,3,3));

        } catch (CustomerAlreadyExistsException e){System.out.println(e.getExMessage());}
        try{
            DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(1));
        } catch (CustomerDoesntHaveActiveException e){System.out.println(e.getExMessage());}
        try{
            DatabaseInvoice.addInvoice(new Sell_Paid(item_list,DatabaseCustomer.getCustomer(1)));
            DatabaseInvoice.addInvoice(new Sell_Unpaid(item_list, DatabaseCustomer.getCustomer(2)));

        } catch (InvoiceAlreadyExistsException e){System.out.println(e.getExMessage());}

        try{
            DatabaseItem.addItem(new Item("Hape", ItemStatus.New,90000,ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Hape", ItemStatus.New,90000,ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
        } catch (ItemAlreadyExistsException e){System.out.println(e.getExMessage());}

        try{
            DatabaseItem.removeItem(99);
        } catch (ItemNotFoundException e) {System.out.println(e.getExMessage());}
        try{
            DatabaseCustomer.removeCustomer(99);
        } catch (CustomerNotFoundException e) {System.out.println(e.getExMessage());}
        try{
            DatabaseSupplier.removeSupplier(99);
        } catch (SupplierNotFoundException e)
        {System.out.println(e.getExMessage());}
        try{
            DatabaseInvoice.removeInvoice(99);
        } catch (InvoiceNotFoundException e){System.out.println(e.getExMessage());}
 /*     Location JakartaTimur = new Location("Jakarta Timur","DKI Jakarta","Jakarta yang ada di timur");
      Supplier supplier1 = new Supplier("Supply Co","supplyco@ui.ac.id","+62081213959099",JakartaTimur);
       Supplier supplier2 = new Supplier("Supply Com","supplieco@ui.ac.id","+6212133562442",JakartaTimur);


      System.out.println(supplier1);
      System.out.println(supplier2);
      DatabaseSupplier.addSupplier(new Supplier("Supply Com","supplgrarco@ui.ac.id","+62812139590999",JakartaTimur));
       DatabaseSupplier.addSupplier(new Supplier("Suppy Com","suplgrarco@ui.ac.id","+62812159590999",JakartaTimur));
       DatabaseSupplier.addSupplier(new Supplier("Suply Com","supplgraro@ui.ac.id","+62812169590999",JakartaTimur));
      for (Supplier supplier: DatabaseSupplier.getSupplierDatabase()){
          System.out.println(supplier);
      }
      DatabaseCustomer.addCustomer(new Customer("Michael", "michaelwijaya1999@yahoo.com", "michaewl", "MichaelW99", 2007,9,9));
       DatabaseCustomer.addCustomer(new Customer("Michel", "michaelwijeya1999@yahoo.com", "michae2wl", "MichaewlW99", 2097,2,2));
       DatabaseCustomer.addCustomer(new Customer("Mihael", "michaelwijrya1999@yahoo.com", "michaew3l", "MicharelW99", 2087,3,3));
       for (Customer customer: DatabaseCustomer.getCustomerDatabase()){
           System.out.println(customer);
       }
      DatabaseItem.addItem(new Item("Hape", 900, ItemStatus.NEW,90000, DatabaseSupplier.getSupplier(1),ItemCategory.ELECTRONICS));
       DatabaseItem.addItem(new Item("Diode", 9042, ItemStatus.REFURBISHED,90000, DatabaseSupplier.getSupplier(1),ItemCategory.ELECTRONICS));
       DatabaseItem.addItem(new Item("Pensil", 930, ItemStatus.SECOND,90000, DatabaseSupplier.getSupplier(1),ItemCategory.STATIONERY));
       DatabaseItem.addItem(new Item("LED", 901, ItemStatus.NEW,90000, DatabaseSupplier.getSupplier(1),ItemCategory.ELECTRONICS));

       for (Item item: DatabaseItem.getItemDatabase()){
           System.out.println(item);
       }
       ArrayList<Integer> item = new ArrayList<>();
       item.add(1);
       item.add(2);

       DatabaseInvoice.addInvoice(new Sell_Paid(item, DatabaseCustomer.getCustomer(1)));
       DatabaseInvoice.addInvoice(new Sell_Unpaid(item, DatabaseCustomer.getCustomer(2)));
       DatabaseInvoice.addInvoice(new Sell_Installment(item,9, DatabaseCustomer.getCustomer(1)));
       for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){
           System.out.println(invoice);
       }
       Transaction.finishTransaction(DatabaseInvoice.getInvoice(2));
       Transaction.finishTransaction(DatabaseInvoice.getInvoice(3));
       for(Invoice inv : DatabaseInvoice.getInvoiceDatabase()){
           System.out.println(inv);
       }
       System.out.print("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5\n\n");
       Transaction.cancelTransaction(DatabaseInvoice.getInvoice(3));
       for(Invoice inv : DatabaseInvoice.getInvoiceDatabase()){
           System.out.println(inv);
       }*/
    }
}
