package jstore;
import java.util.ArrayList;
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer
{
   private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
   private static int LAST_CUSTOMER_ID = 0;
   
   public static ArrayList<Customer> getCustomerDatabase(){
   return CUSTOMER_DATABASE; 
   }
   public static int getLastCustomerId(){
   return LAST_CUSTOMER_ID; 
   } 
    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException{
    for(Customer cust: CUSTOMER_DATABASE){
        if((customer.getName() == cust.getName()) || customer.getEmail() == cust.getEmail()){
        throw new CustomerAlreadyExistsException(customer);
        }    
    }
    CUSTOMER_DATABASE.add(customer);
    LAST_CUSTOMER_ID = customer.getId();
    return true;
    }
    public static Customer getCustomer(int id){
      for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                return customer;
            } 
        }
        return null;
    }
    public static Customer getCustomerLogin(String email, String password){
       for(Customer customer: CUSTOMER_DATABASE){
       if((customer.getEmail().equals(email)) && (customer.getPassword().equals(password))){
        return customer;
       }
       }
       return null;
    }
    public static boolean removeCustomer(int id) throws CustomerNotFoundException{
    for(Customer customer : CUSTOMER_DATABASE){
      if(customer.getId() == id){
      CUSTOMER_DATABASE.remove(customer);
      return true;
      } 
    }
      throw new CustomerNotFoundException(id);
    }


}
