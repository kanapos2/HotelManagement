package Store;

import Model.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Database {
    Connection connect = null;
    Statement stmt = null;
    private ResultSet resultSet = null;

    public void openDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:hoteldb.db";
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
    }

    public void closeDatabase() {
        try {
            connect.close();
            connect = null;
            System.out.println("Close Database!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addUser(User user){
        try{
            String query = "INSERT INTO user_data ('ID','username','firstname','lastname','email','password') VALUES ('"+user.getiDentify()+"','"+user.getUserName()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.geteMail()+"','"+user.getPassWord()+"')";
            stmt = connect.createStatement();
            stmt.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<User> readUser(){
        ObservableList<User> listItem = FXCollections.observableArrayList();
        try{
            String query = "Select * From user_data";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Integer ID = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String lastname = resultSet.getString(4);
                String email = resultSet.getString(5);
                String password = resultSet.getString(6);

                listItem.add(new User(new SimpleIntegerProperty(ID),new SimpleStringProperty(username),new SimpleStringProperty(firstname),
                        new SimpleStringProperty(lastname), new SimpleStringProperty(email),new SimpleStringProperty(password)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
        return listItem;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }



}
