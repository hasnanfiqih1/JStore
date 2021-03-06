package jstore;


public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    
    public InvoiceNotFoundException(int inv){
        super("Invoice ID : ");
        invoice_error = inv;
    }

    
    public String getExMessage(){
        return super.getMessage() + invoice_error + " not found ";
    }
}
