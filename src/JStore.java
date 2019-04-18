
import java.util.*;

public class JStore {
    public static void main(String args[]) {
       Location location1= new Location("Jakarta", "Tes", "Jakarta Selatan");
        try {
            DatabaseSupplier.addSupplier(new Supplier("Haaasnan", "hasnanfiqih@gmail.com", "085719994355", location1));
        } catch (SupplierAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseSupplier.addSupplier(new Supplier("Faiqih", "qwerty@gmail.com", "085746248234", location1));
        } catch (SupplierAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseSupplier.addSupplier(new Supplier("Caoba", "asdfgh@gmail.com", "0857346346246", location1));
        } catch (SupplierAlreadyExistsException e) {
            e.printStackTrace();
        }
        for (Supplier i:DatabaseSupplier.getSupplierDatabase())
       {
           System.out.println(i);
       
    }

        try {
            DatabaseCustomer.addCustomer (new Customer("Saatu", "satu@mail.com", "satusatu", "password1", 1990, 1, 10));
        } catch (CustomerAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseCustomer.addCustomer (new Customer("Duaa", "dua@mail.com", "duadua", "password2", 1989, 2, 20));
        } catch (CustomerAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseCustomer.addCustomer (new Customer("Tigaa", "tiga@mail.com", "tigatiga", "password3", 1985, 3, 30));
        } catch (CustomerAlreadyExistsException e) {
            e.printStackTrace();
        }

        for (Customer i:DatabaseCustomer.getCustomerDatabase())
       {
           System.out.println(i);
       
    }
    
    //DatabaseItem.addItem (new Item("Item1", 10, ItemStatus.New, 1000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(1)));
    //DatabaseItem.addItem (new Item("Item2", 20, ItemStatus.New, 2000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(1)));
    //DatabaseItem.addItem (new Item("Item3", 30, ItemStatus.New, 3000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(1)));
    //DatabaseItem.addItem (new Item("Item4", 40, ItemStatus.New, 4000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(1)));
    
    for (Item i:DatabaseItem.getItemDatabase())
       {
           System.out.println(i);
       
    }
    
    ArrayList<Integer> array1 = new ArrayList<>();
    array1.add(1);
    array1.add(2);
    array1.add(3);
    
    
    ArrayList<Integer> array2 = new ArrayList<>();
    array2.add(2);
    array2.add(4);
    array2.add(3);
    
    ArrayList<Integer> array3 = new ArrayList<>();
    array2.add(1);
    array2.add(4);
    array2.add(3);

        try {
            DatabaseInvoice.addInvoice (new Sell_Paid(array1, DatabaseCustomer.getCustomer(1)));
        } catch (InvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice (new Sell_Unpaid(array2, DatabaseCustomer.getCustomer(1)));
        } catch (InvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        try {
            DatabaseInvoice.addInvoice (new Sell_Installment(array3, 3, DatabaseCustomer.getCustomer(1)));
        } catch (InvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }

        for (Invoice i:DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(i);
       
    }
   
    
    Transaction.finishTransaction(DatabaseInvoice.getInvoice(3));
    
    for (Invoice i:DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(i);
       
    }

        try {
            Transaction.cancelTransaction(DatabaseInvoice.getInvoice(2));
        } catch (InvoiceNotFoundException e) {
            e.printStackTrace();
        }

        for (Invoice i:DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(i);
       
    }
}

    public void transaction() {

    }

    public JStore() {

    }
}
