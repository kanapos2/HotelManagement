package Store;

import java.sql.*;

public class DBConnector {
    Connection connect = null;
    static final private String dbURL = "jdbc:sqlite:hoteldb.db";


    public Connection openDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            if(connect == null) {
                connect = DriverManager.getConnection(dbURL);
            }
            if (connect != null) {
                System.out.println("Connect to database!!!");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.connect;
    }

    public void closeDatabase() {
        try {
            this.connect.close();
            connect = null;
            System.out.println("Close DBConnector!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
