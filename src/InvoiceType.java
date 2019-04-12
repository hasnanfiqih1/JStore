/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public enum InvoiceType
{
    Buy ("Buy"), Sell ("Sell");
    private String deskripsi;
    
    InvoiceType (String deskripsi)
    {
        this.deskripsi = deskripsi;
    }
    public String toString()
        {
            return deskripsi;
        }
}