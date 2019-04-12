import java.util.*;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class DatabaseSupplier
{
    private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<Supplier>();
    private static int LAST_SUPPLIER_ID = 0;

    public DatabaseSupplier()
    {

    }


    public static ArrayList<Supplier> getSupplierDatabase()
    {
        return SUPPLIER_DATABASE;
    }

    public static int getLastSupplierId()
    {
        return LAST_SUPPLIER_ID;
    }

    public static boolean addSupplier(Supplier supplier)
    {
        for(Supplier temp : SUPPLIER_DATABASE)
        {
            if((temp.getName() == supplier.getName()) &&
                    (temp.getEmail() == supplier.getEmail()) &&
                    (temp.getPhoneNumber() == supplier.getPhoneNumber()))
            {
                return false;
            }
        }
        SUPPLIER_DATABASE.add(supplier);
        LAST_SUPPLIER_ID = supplier.getId();
        return true;
    }

    public static Supplier getSupplier(int id)
    {
        for(Supplier temp : SUPPLIER_DATABASE)
        {
            if(temp.getId() == id)
            {
                return temp;
            }
        }
        return null;
    }

    public static boolean removeSupplier(int id)
    {
        for(Supplier temp : SUPPLIER_DATABASE)
        {
            if(temp.getId() == id)
            {
                DatabaseItem.getItemFromSupplier(temp).clear();
                return true;
            }
        }
        return false;
    }

}
