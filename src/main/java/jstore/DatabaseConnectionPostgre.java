package jstore;

import java.sql.*;


public class DatabaseConnectionPostgre {

    private Connection conn = null;

    
    public void connect(){
        try {
            String jdbURL = "jdbc:postgresql://localhost:5432/jstore";
            String username = "postgres";
            String password = "kiki6398";

            conn = DriverManager.getConnection(jdbURL, username, password);
            System.out.println("Database Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    
    public void disconnect(){
        try {
            if(conn != null){
                conn.close();
            }
            System.out.println("Database Connection Terminated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Connection getConn() {
        return conn;
    }

}
