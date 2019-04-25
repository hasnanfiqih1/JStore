package jstore;
import java.util.*;

public class DatabaseItem {
    private static ArrayList<Item> ITEM_DATABASE = new ArrayList<Item>();
    private static int LAST_ITEM_ID = 0;

    public static ArrayList<Item> getItemDatabase() {
        return ITEM_DATABASE;
    }

    public static int getLastItemID() {
        return LAST_ITEM_ID;
    }

    public static boolean addItem(Item item) throws ItemAlreadyExistsException {
        for (Item itemDB : ITEM_DATABASE) {
            if ((item.getName() == itemDB.getName()) && (item.getStatus() == itemDB.getStatus())
                    && (item.getSupplier() == itemDB.getSupplier()) && (item.getCategory() == itemDB.getCategory())) {
                throw new ItemAlreadyExistsException(item);
            }
        }
        ITEM_DATABASE.add(item);
        LAST_ITEM_ID = item.getId();
        return true;
    }

    public static Item getItemFromID(int id) {
        for (Item itemDB : ITEM_DATABASE) {
            if (itemDB.getId() == id) {
                return itemDB;
            }
        }
        return null;
    }

    public static ArrayList<Item> getItemFromSupplier(Supplier supplier) {
        boolean temp = false;
        ArrayList<Item> list = new ArrayList<>();
        for (Item itemDB : ITEM_DATABASE) {
            if (itemDB.getSupplier() == supplier) {
                list.add(itemDB);
                temp = true;
            }
        }
        if (temp) {
            return list;
        } else {
            return null;
        }
    }

    public static ArrayList<Item> getItemFromCategory(ItemCategory category) {
        boolean temp = false;
        ArrayList<Item> list = new ArrayList<Item>();
        for (Item itemDB : ITEM_DATABASE) {
            if (itemDB.getCategory() == category) {
                list.add(itemDB);
                temp = true;
            }
        }
        if (temp) {
            return list;
        } else {
            return null;
        }
    }

    public static ArrayList<Item> getItemFromStatus(ItemStatus status) {
        boolean temp = false;
        ArrayList<Item> list = new ArrayList<Item>();
        for (Item itemDB : ITEM_DATABASE) {
            if (itemDB.getStatus() == status) {
                list.add(itemDB);
                temp = true;
            }
        }
        if (temp) {
            return list;
        } else {
            return null;
        }
    }

    public static boolean removeItem(int id) throws ItemNotFoundException {
        for (Item itemDB : ITEM_DATABASE) {
            if (itemDB.getId() == id) {
                ITEM_DATABASE.remove(itemDB);
                return true;
            }
        }
        throw new ItemNotFoundException(id);
    }
}
