import java.util.*;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public class DatabaseItem
{
    private static ArrayList<Item> ITEM_DATABASE = new ArrayList<Item>();
    private static int LAST_ITEM_ID = 0;

    public DatabaseItem()
    {

    }

    public static ArrayList<Item> getItemDatabase()
    {
        return ITEM_DATABASE;
    }

    public static int getLastItemId()
    {
        return LAST_ITEM_ID;
    }

    public static boolean addItem(Item item)
    {
        boolean found = false;
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getName() == item.getName() && temp.getStatus() == item.getStatus()
                    && temp.getSupplier() == item.getSupplier())
            {
                return false;
            }
        }
        ITEM_DATABASE.add(item);
        LAST_ITEM_ID = item.getId();
        return true;
    }

    public static Item getItemFromID(int id)
    {
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getId() == id)
            {
                return temp;
            }
        }
        return null;
    }

    public static ArrayList<Item> getItemFromSupplier(Supplier supplier)
    {
        ArrayList<Item> list = new ArrayList<Item>();
        boolean found = false;
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getSupplier() == supplier)
            {
                list.add(temp);
                found = true;
            }
        }
        if(found)
        {
            return list;
        }
        else
        {
            return null;
        }
    }

    public static ArrayList<Item> getItemFromCategory(ItemCategory category)
    {
        ArrayList<Item> list = new ArrayList<Item>();
        boolean found = false;
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getCategory() == category)
            {
                list.add(temp);
                found = true;
            }
        }
        if(found)
        {
            return list;
        }
        else
        {
            return null;
        }
    }

    public static ArrayList<Item> getItemFromStatus(ItemStatus status)
    {
        ArrayList<Item> list = new ArrayList<Item>();
        boolean found = false;
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getStatus() == status)
            {
                list.add(temp);
                found = true;
            }
        }
        if(found)
        {
            return list;
        }
        else
        {
            return null;
        }
    }

    public static boolean removeItemId(int id)
    {
        for(Item temp : ITEM_DATABASE)
        {
            if(temp.getId() == id)
            {
                ITEM_DATABASE.remove(temp);
                return true;
            }
        }
        return false;
    }
}
