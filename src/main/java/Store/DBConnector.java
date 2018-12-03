package Store;

import java.sql.*;

public class DBConnector {
    Connection connect = null;
    static final private String dbURL = "jdbc:sqlite:hoteldb.db";

    public Connection openMysql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            if (connect == null){
                connect = DriverManager.getConnection("jdbc:mysql://hoteladmin.c7r8xbm6ljha.ap-southeast-1.rds.amazonaws.com:3306/hoteladmin?"
                        +"user=hoteladmin&password=#hoteladmin");
            }
            if (connect != null){
                System.out.println("Connect to Mysql Complete.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.connect;
    }


//    public Connection openMysql() {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            if(connect == null) {
//                connect = DriverManager.getConnection(dbURL);
//            }
//            if (connect != null) {
//                System.out.println("Connect to database!!!");
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return this.connect;
//    }

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
        Connection connection = db.openMysql();
        RoomDBConnector RoomControls = new RoomDBConnector(connection);
        return RoomControls;
    }

    public static UserDBControl openUserDB(){
        DBConnector db = new DBConnector();
        Connection connection = db.openMysql();
        UserDBControl UserControls = new UserDBControl(connection);
        return UserControls;
    }





}
