package jstore;


public class ItemNotFoundException extends Exception {
    private int item_error;

    
    public ItemNotFoundException(int item){
        super("item ID: ");
        item_error = item;
    }

    
    public String getExMessage(){
        return super.getMessage() + item_error + " not found.";
    }
}
