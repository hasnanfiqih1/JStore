package jstore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseSupplierPostgre extends DatabaseConnectionPostgre {

    
    private Supplier generateSupplierFromOneResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phonenumber");
        String city = rs.getString("city");
        String province = rs.getString("province");
        String description = rs.getString("locdescription");
        Location loc = new Location(city,province,description);
        Supplier sup = new Supplier(id,name,email,phoneNumber,loc);
        return sup;
    }

    
    public ArrayList<Supplier> getSupplierDatabase(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM supplier");
            rs = st.executeQuery();
            ArrayList<Supplier> suppliers = new ArrayList<>();
            while (rs.next()){
                Supplier supplier = generateSupplierFromOneResultSet(rs);
                suppliers.add(supplier);
            }
            st.close();
            rs.close();
            return suppliers;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
                closeConnection(rs, st);
            }
            return null;
        }
    }

    
    public Supplier insertSupplier(String name, String email, String phoneNumber, String city, String province, String description){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int id = 0;
            st = getConn().prepareStatement("INSERT INTO supplier (name,email,phonenumber,city,province,locdescription) values (?,?,?,?,?,?) RETURNING id");
            st.setString(1,name);
            st.setString(2,email);
            st.setString(3,phoneNumber);
            st.setString(4,city);
            st.setString(5,province);
            st.setString(6,description);
            rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            st.close();
            rs.close();
            Location loc = new Location(city,province,description);
            return new Supplier(id,name,email,phoneNumber,loc);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
                closeConnection(rs, st);
            }
            return null;
        }
    }

    
    public Supplier getSupplier(int supplierId) throws SupplierNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            Supplier supplier = null;

            st = getConn().prepareStatement("SELECT * FROM supplier WHERE id = ?");
            st.setInt(1,supplierId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new SupplierNotFoundException(supplierId);
            }
            while (rs.next()){
                supplier = generateSupplierFromOneResultSet(rs);
            }
            st.close();
            rs.close();
            return supplier;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Supplier deleteSupplier(int supplierId) throws SupplierNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Supplier supplier = null;

            st = getConn().prepareStatement("DELETE FROM supplier WHERE id = ? RETURNING *");
            st.setInt(1,supplierId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new SupplierNotFoundException(supplierId);
            }
            while (rs.next()){
                supplier = generateSupplierFromOneResultSet(rs);
            }
            st.close();
            rs.close();
            return supplier;
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
