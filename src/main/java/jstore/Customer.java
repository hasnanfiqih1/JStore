package jstore;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.*; 
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
   private String name,email,username,password;
   private int id;
   private Calendar birthDate;
   
   public Customer(String name, String email,String username,String password,Calendar birthDate){   
   Pattern emailRegex = Pattern.compile("^\\w+\\W?\\w+@[a-zA-Z_]+?\\-?[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
   Matcher emailInput = emailRegex.matcher(email);
   Pattern passRegex = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$");
   Matcher passInput = passRegex.matcher(password);    
   this.name = name;
   this.id = DatabaseCustomer.getLastCustomerId();
   if(emailInput.matches()){
   this.email = email;
   } else {
   this.email = null; 
   }
   this.username = username;
   if(passInput.matches()){
   this.password = password;
   } else{
   this.password = null;
   }
   this.id = DatabaseCustomer.getLastCustomerId()+1;
   this.birthDate = birthDate;
   }
   public Customer(String name, String email, String username, String password, int year, int month,int dayOfMonth){
Pattern emailRegex = Pattern.compile("^\\w+\\W?\\w+@[a-zA-Z_]+?\\-?[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
   Matcher emailInput = emailRegex.matcher(email);
   Pattern passRegex = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$");
   Matcher passInput = passRegex.matcher(password);    
   this.name = name;
   this.id = DatabaseCustomer.getLastCustomerId()+1;
   if(emailInput.matches()){
   this.email = email;
   } else {
   this.email = null; 
   }
   this.username = username;
   if(passInput.matches()){
   this.password = password;
   } else {
      this.password = null;
   }
   birthDate = new GregorianCalendar(year,month,dayOfMonth);
   }
   public String getName(){
   return name; 
   }
   public String getEmail(){
   return email; 
   }
   public String getUsername(){
   return username; 
   }
   public String getPassword(){
   return password; 
   }
   public int getId(){
   return id; 
   }
   public String getBirthDate(){
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
   return ("Birth date: "+ formatter.format(birthDate.getTime()));
   }
   public void setName(String name){
   this.name = name;
   }
   public void setEmail(String email){
   Pattern p = Pattern.compile("^\\w+\\w?\\w+@[a-zA-Z_]+?\\-?[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
   Matcher m = p.matcher(email);
   if(m.matches()){
   this.email = email;
   } else
   {
       this.email = null;
   }
   }
   @RequestMapping(value = "/newcustomer", method= RequestMethod.POST)
   public Customer newCust(@RequestParam(value="name") String name,
                           @RequestParam(value="email") String email, @RequestParam(value="username")
                                   String username, @RequestParam(value="password") String password,
                           @RequestParam(value="birthDate",defaultValue = "1999") Calendar birthDate){
      Customer customer = new Customer(name, email, username, password, 2000, 10,
              10);
      try {
         DatabaseCustomer.addCustomer(customer);
      } catch(Exception ex) {
         ex.getMessage();
         return null;
      }
       return customer;
   }
   public void setUsername(String username){
   this.username = username;
   }
   public void setPassword(String password){
   this.password = password;
   }
   public void setId(int id){
   this.id = id;
   }
   public void setBirthDate(Calendar birthDate){
   this.birthDate = birthDate; 
   }
   public void setBirthDate(int year, int month, int dayOfMonth){
   birthDate.set(year,month,dayOfMonth);
   }
   public String toString(){
   return ("=====CUSTOMER====" + "\n Name: " + name + "\nEmail: " + email +
   "\nUsername: " + username + "\nPassword: " + password + 
   "\nID: " + id + "\nBirthdate: " + getBirthDate());
   }
   
   
}
