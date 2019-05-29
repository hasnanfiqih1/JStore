package jstore;


public class ItemAlreadyExistsException extends Exception {
    private Item item_error;

    
    public ItemAlreadyExistsException(Item item){
        super("item name: ");
        item_error = item;
    }

    
    public String getExMessage(){
        return super.getMessage() + item_error.getName() + ", category: " + item_error.getCategory() +
                ", status: " + item_error.getStatus() + ", from: " + item_error.getSupplier().getName() + " already exist";
    }
}
