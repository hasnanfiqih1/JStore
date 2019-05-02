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
       Location Tebet = new Location("Jakarta Selatan", "DKI Jakarta", "De Liter");
       try{
           DatabaseSupplier.addSupplier(new Supplier("Hasnan","hasnan@ui.ac.id","+6281216598510999",Tebet));
       } catch (SupplierAlreadyExistsException e){System.out.println(e.getExMessage());}

       try{
           DatabaseItem.addItem(new Item("Laptop",ItemStatus.NEW,10000,DatabaseSupplier.getSupplier(1),ItemCategory.ELECTRONICS));
           DatabaseItem.addItem(new Item("Meja",ItemStatus.SECOND,10020,DatabaseSupplier.getSupplier(2),ItemCategory.FURNITURE));
           DatabaseItem.addItem(new Item("Sendok",ItemStatus.REFURBISHED,11020,DatabaseSupplier.getSupplier(3),ItemCategory.FURNITURE));
       }catch (ItemAlreadyExistsException e){
           e.getExMessage();
       }
}
}
