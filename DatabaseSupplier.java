
/**
 * Class Item
 *
 * @author Hasnan Fiqih
 * @version 28/2/2019
 */

public class DatabaseSupplier
{
    private String[] listSupplier;
    private Supplier supplier;
    
    public boolean addSupplier(Supplier supplier)
    {
        return true;
    }
    
    public void removeSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    
    public Supplier getSupplier()
    {
        return supplier;
    }
    
    public String[] getListSupplier()
    {
        return listSupplier;
    }
    
}
