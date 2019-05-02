package jstore;
public class CustomerNotFoundException extends Exception{
    private int customer_error;

    public CustomerNotFoundException(int customer_error){
        super("Customer ID: ");
        this.customer_error = customer_error;
    }

    public String getExMessage(){
        return super.getMessage() + customer_error + " not found.";
    }

}
