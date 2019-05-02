package jstore;
/**
 * Enumeration class InvoiceType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceType
{
    BUY("Buy"),
    SELL("Sell");
    
    private String type;
    InvoiceType(String type){
        this.type=type;
    }
    
    public String toString(){
    return type;
    }
}
