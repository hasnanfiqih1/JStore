package jstore;
import java.util.ArrayList;

public class DatabaseSupplier
{

   //inisialisasi variabel
   private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<>();
   private static int LAST_SUPPLIER_ID = 0;
   private static boolean temp;
   private static Supplier tempSupp;
  public static ArrayList<Supplier> getSupplierDatabase(){
  return SUPPLIER_DATABASE; 
  }
  
  public static int getLastSupplierId(){
   return LAST_SUPPLIER_ID; 
   } 
  /**Method untuk menambahkan item ke DatabaseSupplier  
  * @param supplier Untuk ditambahkan ke listSupplier
  */     
   public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException{
    for(Supplier sup: SUPPLIER_DATABASE){
        if((supplier.getEmail() == sup.getEmail()) || (supplier.getPhoneNumber() == sup.getPhoneNumber())){
        throw new SupplierAlreadyExistsException(supplier);
        }
    }
    SUPPLIER_DATABASE.add(supplier);
    LAST_SUPPLIER_ID=supplier.getId();
    return true;
    }
    
    

  public static Supplier getSupplier(int id){
  for (Supplier supplier : SUPPLIER_DATABASE) {
            if (supplier.getId() == id) {
                return supplier;
            } 
        }
        return null;   
  }
   public static boolean removeSupplier(int id) throws SupplierNotFoundException,ItemNotFoundException{
    for(Supplier supplier : SUPPLIER_DATABASE){
        if(supplier.getId() == id){
            for(Item item: DatabaseItem.getItemDatabase())
            {
                try{
                if(item.getSupplier() == supplier){
                DatabaseItem.removeItem(item.getId());
                }} catch (ItemNotFoundException a){
                    System.out.println(a);
                }
            } 
            return true;
        }
    }
    throw new SupplierNotFoundException(id);
    }

}


