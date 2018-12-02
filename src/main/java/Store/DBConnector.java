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

    public static void closeAllConfigure(ResultSet resultSet,Statement stmt,Connection connection){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static RoomDBConnector openRoomDB(){
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        RoomDBConnector RoomControls = new RoomDBConnector(connection);
        return RoomControls;
    }

    public static UserDBControl openUserDB(){
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        UserDBControl UserControls = new UserDBControl(connection);
        return UserControls;
    }





}
