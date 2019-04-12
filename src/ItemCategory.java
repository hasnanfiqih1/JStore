
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public enum ItemCategory
{
    Electronics ("Electronics"), Furniture ("Furniture"), Stationery ("Stationery");
    private String status;
    
    ItemCategory (String status)
    {
        this.status = status;
    }
    public String toString()
        {
            return status;
        }
    }

   