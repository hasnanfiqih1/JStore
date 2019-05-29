package jstore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseCustomerPostgre extends DatabaseConnectionPostgre{

    
    private Customer generateCustomerFromOneResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String username = rs.getString("username");
        String password = rs.getString("password");
        int year = rs.getInt("year");
        int month = rs.getInt("month");
        int dayOfMonth = rs.getInt("dayofmonth");
        return new Customer(id,name,email,username,password,year,month,dayOfMonth);
    }

    
    public ArrayList<Customer> getCustomerDatabase(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM customer");
            rs = st.executeQuery();
            ArrayList<Customer> customers = new ArrayList<>();
            while (rs.next()){
                Customer customer = generateCustomerFromOneResultSet(rs);
                customers.add(customer);
            }
            rs.close();
            st.close();
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Customer insertCustomer(String name, String email, String username, String password, int year, int month, int dayOfMonth){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int id = 0;
            st = getConn().prepareStatement("INSERT INTO customer (name,email,username,password,year,month,dayofmonth) values (?,?,?,?,?,?,?) RETURNING id");
            st.setString(1,name);
            st.setString(2,email);
            st.setString(3,username);
            st.setString(4,password);
            st.setInt(5,year);
            st.setInt(6,month);
            st.setInt(7,dayOfMonth);
            rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            st.close();
            return new Customer(id,name,email,username,password,year,month,dayOfMonth);
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Customer getCustomer(int customerId) throws CustomerNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Customer customer = null;

            st = getConn().prepareStatement("SELECT * FROM customer WHERE id = ?");
            st.setInt(1,customerId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new CustomerNotFoundException(customerId);
            }
            while (rs.next()){
                customer = generateCustomerFromOneResultSet(rs);
            }
            rs.close();
            st.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Customer customer = null;

            st = getConn().prepareStatement("DELETE FROM customer WHERE id = ? RETURNING *");
            st.setInt(1,customerId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new CustomerNotFoundException(customerId);
            }
            while (rs.next()){
                customer = generateCustomerFromOneResultSet(rs);
            }
            rs.close();
            st.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Customer loginCustomer(String customerEmail, String customerPassword){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Customer customer = null;

            st = getConn().prepareStatement("SELECT * FROM customer WHERE email = ? AND password = ?");
            st.setString(1,customerEmail);
            st.setString(2,customerPassword);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }
            while (rs.next()){
                customer = generateCustomerFromOneResultSet(rs);
            }
            rs.close();
            st.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    private void closeConnection(ResultSet rs, PreparedStatement st){
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
