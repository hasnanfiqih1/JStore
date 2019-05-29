package jstore;


public class SupplierNotFoundException extends Exception {
    private int supplier_error;

    
    public SupplierNotFoundException(int sup){
        super("Supplier ID: ");
        supplier_error = sup;
    }

    
    public String getExMessage(){
        return super.getMessage() + supplier_error + " not found";
    }
}
