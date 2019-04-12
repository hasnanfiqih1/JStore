
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author Hasnan Fiqih
 * @version (04/04/2019)
 */
public enum InvoiceStatus
{
    Paid ("Paid"), Unpaid ("Unpaid"), Installment ("Installment");
    private String status;
    
    InvoiceStatus (String status)
    {
        this.status = status;
    }
    public String toString()
        {
            return status;
        }
    }
