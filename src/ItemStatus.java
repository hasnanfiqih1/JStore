
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public enum ItemStatus
{
   New ("New"), Second ("Second"), Refurbished ("Refurbished"), Sold ("Sold");
    private String status;
    
    ItemStatus (String status)
    {
        this.status = status;
    }
    public String toString()
        {
            return status;
        }
    
    }
