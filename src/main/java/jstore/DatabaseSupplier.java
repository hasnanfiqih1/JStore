package jstore;


public class DatabaseSupplier
{
//    private static final ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<>();
//    private static int LAST_SUPPLIER_ID = 0;
//
//    public static ArrayList<Supplier> getSupplierDatabase(){ return SUPPLIER_DATABASE; }
//
//    public static int getLastSupplierId(){
//        return LAST_SUPPLIER_ID;
//    }
//
//    public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException
//    {
//        String email = supplier.getEmail();
//        String phoneNumber = supplier.getPhoneNumber();
//        for( Supplier sup : SUPPLIER_DATABASE){
//            if(email.equals(sup.getEmail())){
//                throw new SupplierAlreadyExistsException(supplier);
//            }
//            if(phoneNumber.equals(sup.getPhoneNumber())){
//                throw new SupplierAlreadyExistsException(supplier);
//            }
//        }
//        SUPPLIER_DATABASE.add(supplier);
//        LAST_SUPPLIER_ID = supplier.getId();
//        return false;
//    }
//
//    public static Supplier getSupplier(int id)
//    {
//        for ( Supplier sup : SUPPLIER_DATABASE ){
//            if (sup.getId() == id) {
//                return sup;
//            }
//        }
//        return null;
//    }
//
//    public static boolean removeSupplier(int id) throws SupplierNotFoundException
//    {
//        for ( Supplier sup : SUPPLIER_DATABASE ){
//            if (sup.getId() == id) {
//                ArrayList<Item> tempItem = DatabaseItem.getItemFromSupplier(sup);
//                if (tempItem != null) {
//                    for (Item item : tempItem){
//                        try {
//                            DatabaseItem.removeItem(item.getId());
//                        }catch (ItemNotFoundException e){
//                            System.out.println(e.getExMessage());
//                        }
//                    }
//                }
//                SUPPLIER_DATABASE.remove(sup);
//                return true;
//            }
//        }
//        throw new SupplierNotFoundException(id);
//    }
}
