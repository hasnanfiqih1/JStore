import java.util.*;

public class DatabaseSupplier {
    // instance variables - replace the example below with your own
    private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<Supplier>();
    private static int LAST_SUPPLIER_ID = 0;

    public static ArrayList<Supplier> getSupplierDatabase() {
        return SUPPLIER_DATABASE;
    }

    public static int getLastSupplierID() {
        return LAST_SUPPLIER_ID;
    }

    public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException {
        for (Supplier supplierDB : SUPPLIER_DATABASE) {
            if ((supplierDB.getEmail() == supplier.getEmail()) && (supplierDB.getPhoneNumber() == supplier.getPhoneNumber())) {
                throw new SupplierAlreadyExistsException(supplier);
            }
        }
        SUPPLIER_DATABASE.add(supplier);
        LAST_SUPPLIER_ID = supplier.getId();
        return true;
    }

    public static Supplier getSupplier(int id) {
        for (Supplier supplierDB : SUPPLIER_DATABASE) {
            if (supplierDB.getId() == id) {
                return supplierDB;
            }
        }
        return null;
    }

    public static boolean removeSupplier(int id) throws SupplierNotFoundException {
        for (Supplier supplierDB : SUPPLIER_DATABASE) {
            if (supplierDB.getId() == id) {
                DatabaseItem.getItemFromSupplier(supplierDB).clear();
                return true;
            }
        }
        throw new  SupplierNotFoundException(id);
    }
}
