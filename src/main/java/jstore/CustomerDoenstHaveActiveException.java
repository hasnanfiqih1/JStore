package jstore;


public class CustomerDoenstHaveActiveException extends Exception {
    private Customer customer_error;

    
    public CustomerDoenstHaveActiveException(Customer cus){
        super("Customer : ");
        this.customer_error = cus;
    }

    
    public String getExMessage(){
        return super.getMessage() + customer_error + " \ndoesnt have active invoice";
    }
}
