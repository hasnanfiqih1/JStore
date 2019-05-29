package jstore;


public class DatabaseItem
{
//    private static final ArrayList<Item> ITEM_DATABASE = new ArrayList<>();
//    private static int LAST_ITEM_ID = 0;
//
//    public static ArrayList<Item> getItemDatabase() {
//        return ITEM_DATABASE;
//    }
//
//    public static int getLastItemId() {
//        return LAST_ITEM_ID;
//    }
//
//    public static boolean addItem(Item item) throws ItemAlreadyExistsException
//    {
//        for(Item i : ITEM_DATABASE){
//            if(i.getName().equals(item.getName()) && i.getStatus().equals(item.getStatus()) && i.getSupplier().equals(item.getSupplier()) && i.getCategory().equals(item.getCategory())){
//                throw new ItemAlreadyExistsException(item);
//            }
//        }
//        ITEM_DATABASE.add(item);
//        LAST_ITEM_ID = item.getId();
//        return true;
//    }
//
//    public static Item getItemFromID(int ID){
//        for(Item item : ITEM_DATABASE){
//            if(ID == item.getId()){
//                return item;
//            }
//        }
//        return null;
//    }
//
//    public static ArrayList<Item> getItemFromSupplier(Supplier supplier){
//        ArrayList<Item> temp = new ArrayList<>();
//        for(Item item : ITEM_DATABASE){
//            if(supplier.equals(item.getSupplier())){
//                temp.add(item);
//            }
//        }
//        if(temp.size() > 0){
//            return temp;
//        }
//        else{
//            return null;
//        }
//    }
//
//    public static ArrayList<Item> getItemFromCategory(ItemCategory category){
//        ArrayList<Item> temp = new ArrayList<>();
//        for(Item item : ITEM_DATABASE){
//            if(category.equals(item.getCategory())){
//                temp.add(item);
//            }
//        }
//        if(temp.size() > 0){
//            return temp;
//        }
//        else{
//            return null;
//        }
//    }
//
//    public static ArrayList<Item> getItemFromStatus(ItemStatus status){
//        ArrayList<Item> temp = new ArrayList<>();
//        for(Item item : ITEM_DATABASE){
//            if(status == item.getStatus()){
//                temp.add(item);
//            }
//        }
//        if(temp.size()>0){
//            return temp;
//        }
//        else{
//            return null;
//        }
//    }
//
//    public static boolean removeItem(int id) throws ItemNotFoundException
//    {
//        for(Item item : ITEM_DATABASE) {
//            if (id == item.getId()) {
//                ITEM_DATABASE.remove(item);
//                return true;
//            }
//        }
//        throw new ItemNotFoundException(id);
//    }
}