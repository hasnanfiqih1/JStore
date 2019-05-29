package jstore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DatabaseInvoicePostgre extends DatabaseConnectionPostgre {

    
    private void insertToListItem(int invoiceId, ArrayList<Integer> listItem) throws SQLException {
        PreparedStatement li = getConn().prepareStatement("INSERT INTO listitem (invoiceid, itemid) VALUES (?,?) RETURNING *");
        li.setInt(1,invoiceId);
        for(int idItem : listItem){
            li.setInt(2,idItem);
            li.execute();
        }
        li.close();
    }

    
    private int insertToInvoice(boolean isActive, int customerId, InvoiceType invoiceType, InvoiceStatus invoiceStatus) throws SQLException {
        int invoiceId = 0;
        PreparedStatement st = getConn().prepareStatement("INSERT INTO invoice (active, customerid, type, status) VALUES (?,?,?,?) RETURNING id");
        st.setBoolean(1,isActive);
        st.setInt(2,customerId);
        st.setString(3,invoiceType.toString());
        st.setString(4,invoiceStatus.toString());
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            invoiceId = rs.getInt(1);
        }
        rs.close();
        st.close();
        return invoiceId;
    }

    
    private ArrayList<Integer> getListItem(int invoiceId) throws SQLException {
        PreparedStatement st2 = getConn().prepareStatement("SELECT itemid FROM listitem WHERE invoiceid = ?");
        st2.setInt(1,invoiceId);
        ResultSet rs2 = st2.executeQuery();
        ArrayList<Integer> listItemId = new ArrayList<>();
        while (rs2.next()){
            listItemId.add(rs2.getInt(1));
        }
        rs2.close();
        st2.close();
        return listItemId;
    }

    
    private Customer getCustomerByParamId(int idCustomer) throws SQLException {
        Customer customer = null;
        PreparedStatement st = getConn().prepareStatement("SELECT * FROM customer WHERE id = ?");
        st.setInt(1,idCustomer);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String password = rs.getString("password");
            int year = rs.getInt("year");
            int month = rs.getInt("month");
            int dayOfMonth = rs.getInt("dayofmonth");
            customer = new Customer(id,name,email,username,password,year,month,dayOfMonth);
        }
        rs.close();
        st.close();
        return customer;
    }

    
    public Invoice insertInvoicePaid (ArrayList<Integer> listItem, int customerId){
        try {
            Customer customer = getCustomerByParamId(customerId);
            getConn().setAutoCommit(false);
            int invoiceId = insertToInvoice(false, customer.getId(), InvoiceType.Sell, InvoiceStatus.Paid);
            insertToListItem(invoiceId, listItem);
            getConn().commit();
            getConn().setAutoCommit(true);
            return new Sell_Paid(listItem, invoiceId, customer);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                getConn().rollback();
                getConn().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

    
    public Invoice insertInvoiceUnpaid (ArrayList<Integer> listItem, int customerId){
        try {
            Customer customer = getCustomerByParamId(customerId);
            getConn().setAutoCommit(false);
            int invoiceId = insertToInvoice(true, customer.getId(), InvoiceType.Sell, InvoiceStatus.Unpaid);
            insertToListItem(invoiceId, listItem);
            getConn().commit();
            getConn().setAutoCommit(true);
            return new Sell_Unpaid(listItem, invoiceId, customer);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                getConn().rollback();
                getConn().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

    
    public Invoice insertInvoiceInstallment (ArrayList<Integer> listItem, int customerId, int installmentPeriod) {
        try {
            Customer customer = getCustomerByParamId(customerId);
            getConn().setAutoCommit(false);
            int invoiceId = 0;
            PreparedStatement st = getConn().prepareStatement("INSERT INTO invoice (active, customerid, type, status, instperiod) VALUES (?,?,?,?,?) RETURNING id");
            st.setBoolean(1,true);
            st.setInt(2,customer.getId());
            st.setString(3,InvoiceType.Sell.toString());
            st.setString(4,InvoiceStatus.Installment.toString());
            st.setInt(5,installmentPeriod);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                invoiceId = rs.getInt(1);
            }
            rs.close();
            st.close();
            insertToListItem(invoiceId, listItem);
            getConn().commit();
            getConn().setAutoCommit(true);
            return new Sell_Installment(listItem, invoiceId, installmentPeriod, customer);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                getConn().rollback();
                getConn().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

    
    public ArrayList<Invoice> getActiveInvoice (int customerId) {
        try {
            Customer customer = getCustomerByParamId(customerId);
            PreparedStatement st =  getConn().prepareStatement("SELECT * FROM invoice WHERE customerid = ? AND active = TRUE ORDER BY ID");

            st.setInt(1,customer.getId());
            ResultSet rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }

            int invoiceId = 0;
            Calendar calendar = new GregorianCalendar();
            InvoiceType invoiceType = null;
            InvoiceStatus invoiceStatus = null;
            int installmentPeriod = 0;

            ArrayList<Invoice> invoices = new ArrayList<>();
            while(rs.next()){
                invoiceId = rs.getInt("id");
                calendar.setTime(rs.getDate("orderdate"));
                invoiceType = InvoiceType.valueOf(rs.getString("type"));
                invoiceStatus = InvoiceStatus.valueOf(rs.getString("status"));

                if(invoiceStatus == InvoiceStatus.Installment){
                    installmentPeriod = rs.getInt("instperiod");
                }

                ArrayList<Integer> listItemId = getListItem(invoiceId);

                Invoice inv;
                if(invoiceStatus == InvoiceStatus.Installment){
                    inv = new Sell_Installment(listItemId,invoiceId,installmentPeriod,customer,calendar);
                }else if(invoiceStatus == InvoiceStatus.Unpaid){
                    inv = new Sell_Unpaid(listItemId,invoiceId,customer,calendar);
                }else {
                    inv = new Sell_Paid(listItemId,invoiceId,customer,calendar);
                }
                invoices.add(inv);
            }
            rs.close();
            st.close();
            return invoices;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public ArrayList<Invoice> getAllInvoice (int customerId) {
        try {
            Customer customer = getCustomerByParamId(customerId);
            PreparedStatement st =  getConn().prepareStatement("SELECT * FROM invoice WHERE customerid = ? ORDER BY id");

            st.setInt(1,customer.getId());
            ResultSet rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }

            int invoiceId = 0;
            Calendar calendar = new GregorianCalendar();
            InvoiceType invoiceType = null;
            InvoiceStatus invoiceStatus = null;
            boolean isActive = false;
            int installmentPeriod = 0;

            ArrayList<Invoice> invoices = new ArrayList<>();
            while(rs.next()){
                invoiceId = rs.getInt("id");
                calendar.setTime(rs.getDate("orderdate"));
                invoiceType = InvoiceType.valueOf(rs.getString("type"));
                isActive = rs.getBoolean("active");
                invoiceStatus = InvoiceStatus.valueOf(rs.getString("status"));

                if(invoiceStatus == InvoiceStatus.Installment){
                    installmentPeriod = rs.getInt("instperiod");
                }

                ArrayList<Integer> listItemId = getListItem(invoiceId);

                Invoice inv;

                if(invoiceStatus == InvoiceStatus.Installment){
                    inv = new Sell_Installment(listItemId,invoiceId,installmentPeriod,customer,calendar,isActive);
                }else if(invoiceStatus == InvoiceStatus.Unpaid){
                    inv = new Sell_Unpaid(listItemId,invoiceId,customer,calendar,isActive);
                }else {
                    inv = new Sell_Paid(listItemId,invoiceId,customer,calendar,isActive);
                }
                invoices.add(inv);
            }
            rs.close();
            st.close();
            return invoices;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Invoice getInvoice (int invoiceID) {
        try {
            PreparedStatement st =  getConn().prepareStatement("SELECT * FROM invoice WHERE id = ?");

            st.setInt(1,invoiceID);
            ResultSet rs = st.executeQuery();
            if(!rs.isBeforeFirst()){
                st.close();
                return null;
            }

            int invoiceId = 0;
            Calendar calendar = new GregorianCalendar();
            InvoiceType invoiceType = null;
            InvoiceStatus invoiceStatus = null;
            boolean isActive = false;
            int installmentPeriod = 0;
            int customerId = 0;

            Invoice inv = null;
            while(rs.next()){
                invoiceId = rs.getInt("id");
                calendar.setTime(rs.getDate("orderdate"));
                invoiceType = InvoiceType.valueOf(rs.getString("type"));
                isActive = rs.getBoolean("active");
                invoiceStatus = InvoiceStatus.valueOf(rs.getString("status"));
                customerId = rs.getInt("customerid");

                if(invoiceStatus == InvoiceStatus.Installment){
                    installmentPeriod = rs.getInt("instperiod");
                }

                ArrayList<Integer> listItemId = getListItem(invoiceId);

                Customer customer = getCustomerByParamId(customerId);

                if(invoiceStatus == InvoiceStatus.Installment){
                    inv = new Sell_Installment(listItemId,invoiceId,installmentPeriod,customer,calendar,isActive);
                }else if(invoiceStatus == InvoiceStatus.Unpaid){
                    inv = new Sell_Unpaid(listItemId,invoiceId,customer,calendar,isActive);
                }else {
                    inv = new Sell_Paid(listItemId,invoiceId,customer,calendar,isActive);
                }
            }
            rs.close();
            st.close();
            return inv;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Invoice finishTransaction(int invoiceID) {
        Invoice inv = getInvoice(invoiceID);
        if((inv.getInvoiceStatus() == InvoiceStatus.Installment || inv.getInvoiceStatus() == InvoiceStatus.Unpaid) && inv.getIsActive()){
            try {
                PreparedStatement st = getConn().prepareStatement("UPDATE invoice SET active = FALSE WHERE id = ? RETURNING *");
                st.setInt(1,invoiceID);
                ResultSet rs = st.executeQuery();
                if(!rs.isBeforeFirst()){
                    rs.close();
                    st.close();
                    return null;
                }else {
                    rs.close();
                    st.close();
                    return inv;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    
    public Invoice cancelTransaction(int invoiceID) {
        Invoice inv = getInvoice(invoiceID);
        if((inv.getInvoiceStatus() == InvoiceStatus.Installment || inv.getInvoiceStatus() == InvoiceStatus.Unpaid) && inv.getIsActive()){
            try {
                PreparedStatement st = getConn().prepareStatement("DELETE FROM invoice WHERE id = ? RETURNING *");
                st.setInt(1,invoiceID);
                ResultSet rs = st.executeQuery();
                if(!rs.isBeforeFirst()){
                    rs.close();
                    st.close();
                    return null;
                }else {
                    rs.close();
                    st.close();
                    return inv;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
