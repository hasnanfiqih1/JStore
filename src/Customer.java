import java.util.*;
import java.text.*;
import java.util.regex.*;


public class Customer {
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, String email, String username, String password, Calendar birthDate) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = DatabaseCustomer.getLastCustomerID() + 1;
        this.birthDate = birthDate;
    }

    public Customer(String name, String email, String username, String password, int year, int month, int dayOfMonth) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = DatabaseCustomer.getLastCustomerID() + 1;
        this.birthDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public Calendar getBirthDate() {
        System.out.printf("%s %te %<tB %<tY", "Birth date: ", birthDate);

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("Birth date: " + format.format(birthDate));
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.find()) {
            System.out.println("Email : " + m.group());
            this.email = email;
        } else {
            System.out.println("Email : null");
            this.email = email;
        }

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if (m.find()) {
            System.out.println("Password: " + m.group());
            this.password = password;
        } else {
            System.out.println("Password: NULL");
            this.password = "NULL";
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(int year, int month, int dayOfMonth) {
        this.birthDate = new GregorianCalendar(year, month, dayOfMonth);
    }

    public String toString() {
        return "Nama : " + name + "\nEmail : " + email + "\nUsername : " + username + "\nPassword : " + password + "\nID : "
                + id + "\nbirthDate : " + birthDate.getTime() + "\n\n";
    }

}
