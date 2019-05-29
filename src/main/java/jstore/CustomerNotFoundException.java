package jstore;


public class CustomerNotFoundException extends Exception {
    private int customer_error;

    
    public CustomerNotFoundException(int cus){
        super("Customer ID: ");
        customer_error = cus;
    }

    
    public String getExMessage(){
        return super.getMessage() + customer_error + " not found";
    }
}
