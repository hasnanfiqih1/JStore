import java.util.*;
import java.text.*;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;

    public Customer(String name, String email, String username, String password, int id, Calendar birthDate)
    {
       this.name = name;
       this.email = email;
       this.username = username;
       this.password = password;
       this.id = id;
       this.birthDate = birthDate;
    }
    
    public Customer(String name, String email, String username, String password, int id, int year, int month, int dayOfMonth)
    {
       this.name = name;
       this.email = email;
       this.username = username;
       this.password = password;
       this.id = id;
       this.birthDate = new GregorianCalendar(year, month, dayOfMonth);
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
    SimpleDateFormat bd = new SimpleDateFormat ("dd MMMM yyyy");
    System.out.println("Birth Date: " + bd.format(birthDate));
    return birthDate;
 }
 
 public void setName(String name)
 {
    this.name = name;
 }
 
 public void setEmail(String email)
 {
    this.email = email;
 }
 
 public void setUsername(String username)
 {
    this.username = username;
 }
 
 public void setPassword(String password)
 {
    this.password = password;
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
    this.birthDate = new GregorianCalendar(year, month, dayOfMonth);
 }
 
 public String toString()
 {
     return name+email+username+password+id+birthDate;
    }
   
}
