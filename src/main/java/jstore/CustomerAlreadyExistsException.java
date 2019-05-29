package jstore;


public class CustomerAlreadyExistsException extends Exception {
    private Customer customer_error;

    
    public CustomerAlreadyExistsException(Customer cus){
        super("Customer ID: ");
        customer_error = cus;
    }

    
    public String getExMessage(){
        return super.getMessage() + customer_error.getEmail() + ", or username: " + customer_error.getUsername() + " already exist";
    }
}
