package jstore;


public class InvoiceAlreadyExistsException extends Exception{
    private Invoice invoice_error;

    
    public InvoiceAlreadyExistsException(Invoice inv){
        super("Invoice with Item list ");
        invoice_error = inv;
    }

    
    public String getExMessage(){
        return super.getMessage() + invoice_error.getItem() + " already ordered by " + invoice_error.getCustomer().getUsername();
    }
}
