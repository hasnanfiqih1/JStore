

import java.util.*;
import java.util.regex.*;
import java.text.*;


/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyy");

 
 public Customer(String name, String email, String username,
     String password, Calendar birthDate)
 {
  this.name = name;
  this.email = email;
  this.username = username;
  this.password = password;
  this.id = DatabaseCustomer.getLastCustomerID() + 1;
  this.birthDate = birthDate;
 }   

 public Customer(String name, String email, String username,
     String password, int year, int month, int dayOfMonth)
 {
  this.name = name;
  this.email = email;
  this.username = username;
  this.password = password;
  this.id = DatabaseCustomer.getLastCustomerID() + 1;
  this.birthDate = new GregorianCalendar(year, month-1, dayOfMonth);
  
 } 

 public String getName()
 {
  return name;
 }
 
 public String getEmail()
 {
  return email;
 }
 
 public String getUsername()
 {
  return username;
 }
 
 public String getPassword()
 {
  return password;
 }
 
 public int getId()
 {
  return id;
 }
 
 public Calendar getBirthDate()
 {
     System.out.println("Birth date: " + dateFormat.format(birthDate.getTime()));
     return birthDate;
 }
 
 
 
 ///////////////////////////////////////////////////////////
 
 
 
 public void setName(String name)
 {
  this.name = name;
 }
 
 public void setEmail(String email)
 {
     if(Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
             "[a-zA-Z0-9_+&*-]+)*@" +
             "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
             "A-Z]{2,7}$", email))
     {
         this.email = email;
     }
     else
     {
         this.email = "";
     }
 } 

 public void setUsername(String username)
 {
  this.username = username;
 }
 
 public void setPassword(String password)
 {
     if(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$", password))
     {
         this.password = password;
     }
     else
     {
         this.password = "";
     }
 } 
 
 public void setId(int id)
 {
  this.id = id;
 } 
 
 public void setBirthDate(Calendar birthDate)
 {
  this.birthDate = birthDate;
 }

 public void setBirthDate(int year, int month, int dayOfMonth)
 {
    birthDate = new GregorianCalendar(year, month-1, dayOfMonth);
 } 
 
 public String toString()
 {
     System.out.println("Name: " + name);
     System.out.println("Email: " + email);
     System.out.println("Username: " + username);
     System.out.println("Password: " + password);
     System.out.println("ID: " + id);
     System.out.println("Birthdate: " + birthDate);
     return "";
 }
}
