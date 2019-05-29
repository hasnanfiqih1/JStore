package jstore;



public class DatabaseCustomer
{
//    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
//    private static int LAST_CUSTOMER_ID = 0;
//
//    public static ArrayList<Customer> getCustomerDatabase(){ return CUSTOMER_DATABASE; }
//
//    public static int getLastCustomerId(){
//        return LAST_CUSTOMER_ID;
//    }
//
//    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException{
//        String name = customer.getName();
//        String email = customer.getEmail();
//        for ( Customer cus : CUSTOMER_DATABASE){
//            if(name.equals(cus.getName())){
//                throw new CustomerAlreadyExistsException(cus);
//            }
//            if(email.equals(cus.getEmail())){
//                throw new CustomerAlreadyExistsException(cus);
//            }
//        }
//        CUSTOMER_DATABASE.add(customer);
//        LAST_CUSTOMER_ID = customer.getId();
//        return true;
//    }
//
//    public static Customer getCustomer(int id)
//    {
//        for ( Customer cus : CUSTOMER_DATABASE ){
//            if (cus.getId() == id) {
//                return cus;
//            }
//        }
//        return null;
//    }
//
//    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
//        for ( Customer cus : CUSTOMER_DATABASE ){
//            if (cus.getId() == id) {
//                CUSTOMER_DATABASE.remove(cus);
//                return true;
//            }
//        }
//        throw new CustomerNotFoundException(id);
//    }
//
//    public static Customer getCustomerLogin(String email, String password){
//        for(Customer cus : CUSTOMER_DATABASE){
//            if(cus.getEmail().equals(email) && cus.getPassword().equals(password)){
//                return cus;
//            }
//        }
//        return null;
//    }
}
