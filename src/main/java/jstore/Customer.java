package jstore;

import java.util.*;
import java.util.regex.*;


public class Customer
{
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;

    
    public Customer(int id, String name, String email, String username, String password, Calendar birthDate)
    {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthDate = birthDate;
    }

    
    public Customer(int id, String name, String email, String username, String password, int year, int month, int dayOfMonth)
    {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthDate = new GregorianCalendar(year,month - 1,dayOfMonth + 1);
    }

    
    public String getName() {
        return this.name;
    }

    
    public String getEmail() {
    
        return this.email;
    }

    
    public String getUsername() {
        return this.username;
    }

    
    public String getPassword() {
        return this.password;
    }

    
    public int getId() {
        return this.id;
    }

    
    public Calendar getBirthDate() {
        return birthDate;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public void setEmail(String email){
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        if(m.find( )){
            this.email = email;
        }else{
            this.email = "NULL";
        }
    }

    
    public void setPassword(String password){
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(password);
        if(m.find( )){
            this.password = password;
        }else{
            this.password = "NULL";
        }
    }

    
    public void setId(int id){
        this.id = id;
    }

    
    public String toString(){
        return "ID: " +id+ "\nName: " +name+ "\nEmail: " +email+ "\nUsername: " +username+ "\nPassword: " +password+ "\nBirth Date: " +getBirthDate().getTime();
    }
}
