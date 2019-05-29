package jstore;



public class DatabaseInvoice {
//    // instance variables used only in this class
//    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
//    private static int LAST_INVOICE_ID = 0;
//
//    public static ArrayList<Invoice> getInvoiceDatabase() {
//        return INVOICE_DATABASE;
//    }
//
//    public static int getLastInvoiceId() {
//        return LAST_INVOICE_ID;
//    }
//
//    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException {
//        for(Invoice inv : DatabaseInvoice.getInvoiceDatabase()){
//            if(inv.getCustomer().equals(invoice.getCustomer())){
//                if(inv.getItem().equals(invoice.getItem()) && inv.getIsActive()){
//                    throw new InvoiceAlreadyExistsException(invoice);
//                }
//            }
//        }
//        INVOICE_DATABASE.add(invoice);
//        LAST_INVOICE_ID = invoice.getId();
//        return true;
//    }
//
//    public static Invoice getInvoice(int id) {
//        for (Invoice inv : INVOICE_DATABASE) {
//            if (id == inv.getId()) {
//                return inv;
//            }
//        }
//        return null;
//    }
//
//    public static ArrayList<Invoice> getOrders(Customer customer) {
//        ArrayList<Invoice> temp = new ArrayList<>();
//        for (Invoice inv : INVOICE_DATABASE) {
//            if (customer.getId() == inv.getCustomer().getId()) {
//                temp.add(inv);
//            }
//        }
//        if(temp.size() == 0){
//            temp = null;
//        }
//        return temp;
//    }
//
//    public static ArrayList<Invoice> getActiveOrder(Customer customer) throws CustomerDoenstHaveActiveException{
//        ArrayList<Invoice> temp = new ArrayList<>();
//        for (Invoice inv : INVOICE_DATABASE) {
//            if (customer.getId() == inv.getCustomer().getId() && inv.getIsActive() && (inv.getInvoiceStatus().equals(InvoiceStatus.Unpaid) || inv.getInvoiceStatus().equals(InvoiceStatus.Installment))) {
//                temp.add(inv);
//            }
//        }
//        if(temp.size() == 0){
//            throw new CustomerDoenstHaveActiveException(customer);
//        }
//        return temp;
//    }
//
//    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
//        for(Invoice inv : INVOICE_DATABASE) {
//            if (id == inv.getId()) {
//                if (inv.getIsActive()) {
//                    inv.setIsActive(false);
//                }
//                INVOICE_DATABASE.remove(inv);
//                return true;
//            }
//        }
//        throw new InvoiceNotFoundException(id);
//    }
}