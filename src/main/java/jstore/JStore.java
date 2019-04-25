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
        Location location = new Location("DKI Jakata", "Tebet", "Jakarta Selatan");
        try {
            DatabaseSupplier.addSupplier(new Supplier("Adnan", "adnan@mail.com", "08123456", location));
            DatabaseSupplier.addSupplier(new Supplier("Julius", "julius@mail.com", "08124756124", location));
            DatabaseSupplier.addSupplier(new Supplier("Michael", "michael@mail.com", "325634867", location));
        }
        catch (SupplierAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseItem.addItem(new Item("Meja", ItemStatus.New, 5000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Hape", ItemStatus.New, 3000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(3)));
            DatabaseItem.addItem(new Item("Tipi", ItemStatus.New, 1000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(3)));
            DatabaseItem.addItem(new Item("Kursi", ItemStatus.New, 2000, ItemCategory.Furniture, DatabaseSupplier.getSupplier(2)));
        }
        catch (ItemAlreadyExistsException e)
        {
            System.out.println(e.getExMessage());
        }
    }
}
