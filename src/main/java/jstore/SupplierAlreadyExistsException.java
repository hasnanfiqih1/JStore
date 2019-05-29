package jstore;


public class SupplierAlreadyExistsException extends Exception{
    private Supplier supplier_error;

    
    public SupplierAlreadyExistsException(Supplier sup){
        super("Supplier Email: ");
        supplier_error = sup;
    }

    
    public String getExMessage(){
        return super.getMessage() + supplier_error.getEmail() + ", or phoneNumber: " + supplier_error.getPhoneNumber() + " already exist";
    }
}