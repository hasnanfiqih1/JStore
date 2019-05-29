package jstore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabaseItemPostgre extends DatabaseConnectionPostgre {

    
    private Supplier getSupplierFromResultId(int supplierId) throws SQLException {
        String name = "", email = "", phoneNumber = "", city = "", province = "", description = "";
        int id = 0;
        Location loc = null;
        PreparedStatement st = getConn().prepareStatement("SELECT * FROM Supplier WHERE id = ?");
        st.setInt(1,supplierId);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            id = rs.getInt("id");
            name = rs.getString("name");
            email = rs.getString("email");
            phoneNumber = rs.getString("phonenumber");
            city = rs.getString("city");
            province = rs.getString("province");
            description = rs.getString("locdescription");
            loc = new Location(city,province,description);
        }
        Supplier sup = new Supplier(id,name,email,phoneNumber,loc);
        rs.close();
        st.close();
        return sup;
    }

    
    private Item generateItemFromOneResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        String category = rs.getString("category");
        String status = rs.getString("status");
        int supplierId = rs.getInt("supplierid");
        Supplier supplier = getSupplierFromResultId(supplierId);
        return new Item(id, name, ItemStatus.valueOf(status), price, supplier, ItemCategory.valueOf(category));
    }

    
    public ArrayList<Item> getItemDatabase(){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM item");
            rs = st.executeQuery();
            ArrayList<Item> items = new ArrayList<>();
            while (rs.next()){
                Item item = generateItemFromOneResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Item getItemById(int itemId) throws ItemNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Item item = null;
            st = getConn().prepareStatement("SELECT * FROM item WHERE id = ?");
            st.setInt(1,itemId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new ItemNotFoundException(itemId);
            }
            while (rs.next()){
                item = generateItemFromOneResultSet(rs);
            }
            rs.close();
            st.close();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public ArrayList<Item> getItemFromStatus(ItemStatus itemStatus){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM item WHERE status = ?");
            st.setString(1,itemStatus.toString());
            rs = st.executeQuery();

            ArrayList<Item> items = new ArrayList<>();
            while (rs.next()){
                Item item = generateItemFromOneResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public ArrayList<Item> getItemFromCategory(ItemCategory itemCategory){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM item WHERE category = ?");
            st.setString(1,itemCategory.toString());
            rs = st.executeQuery();

            ArrayList<Item> items = new ArrayList<>();
            while (rs.next()){
                Item item = generateItemFromOneResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public ArrayList<Item> getItemFromSupplier(int idSupplier){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = getConn().prepareStatement("SELECT * FROM item WHERE supplierid = ?");
            st.setInt(1,idSupplier);
            rs = st.executeQuery();
            ArrayList<Item> items = new ArrayList<>();
            while (rs.next()){
                Item item = generateItemFromOneResultSet(rs);
                items.add(item);
            }
            rs.close();
            st.close();
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Item insertItem(String name, int price, ItemCategory itemCategory, ItemStatus itemStatus, int idSupplier){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int id = 0;
            st = getConn().prepareStatement("INSERT INTO item (name, price, category, status, supplierid) values (?,?,?,?,?) RETURNING id");
            st.setString(1,name);
            st.setInt(2,price);
            st.setString(3,itemCategory.toString());
            st.setString(4,itemStatus.toString());
            st.setInt(5,idSupplier);
            rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            rs.close();
            st.close();
            Supplier sup = getSupplierFromResultId(idSupplier);
            return new Item(id,name,itemStatus,price,sup,itemCategory);
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, st);
            return null;
        }
    }

    
    public Item deleteItem(int itemId) throws ItemNotFoundException {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Item item = null;
            st = getConn().prepareStatement("DELETE FROM item WHERE id = ? RETURNING *");
            st.setInt(1,itemId);
            rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                throw new ItemNotFoundException(itemId);
            }
            while (rs.next()){
                item = generateItemFromOneResultSet(rs);
            }
            rs.close();
            st.close();
            return item;
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
