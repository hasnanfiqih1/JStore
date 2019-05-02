package jstore;
public class ItemNotFoundException extends Exception {
    private int item_error;

    public ItemNotFoundException(int item_error){
        super("Item ID: ");
        this.item_error = item_error;
    }

    public String getExMessage(){
        return super.getMessage() + item_error + " not found.";
    }

}
