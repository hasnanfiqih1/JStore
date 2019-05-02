package jstore;
public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    public InvoiceNotFoundException(int invoice_error){
        super("Invoice ID: ");
        this.invoice_error = invoice_error;
    }

    public String getExMessage(){
        return super.getMessage() + invoice_error + " not found.";
    }
}
