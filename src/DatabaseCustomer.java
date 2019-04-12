import java.util.*;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    public DatabaseCustomer()
    {

    }

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }

    public static boolean addCustomer(Customer customer)
    {
        boolean found = false;
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getName() == customer.getName() && temp.getEmail()
                    == customer.getEmail())
            {
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        LAST_CUSTOMER_ID = customer.getId();
        return true;
    }

    public static Customer getCustomer(int id)
    {
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getId() == id)
            {
                return temp;
            }
        }
        return null;
    }

    public boolean removeCustomer(int id)
    {
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getId() == id)
            {
                CUSTOMER_DATABASE.remove(temp);
                return true;
            }
        }
        return false;
    }
    
}
