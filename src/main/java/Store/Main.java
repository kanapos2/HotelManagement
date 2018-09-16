package Store;

import Model.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnector db = new DBConnector();
        Connection connection = db.openDatabase();
        UserDBControl userDBControl = new UserDBControl(connection);

        User user = new User("000","admin","Admin",
                "Superadmin","8888888888","adminHR@hr.com","adminadmin");
        System.out.println(userDBControl.addUser(user));

        /////////////////////////////////////////////////////// เอาไว้อ่านข้อมูลจาก database

//        ArrayList<User> userList = userDBControl.readUser();
//        for (User i: userList) {
//            System.out.println(i);
//        }
    }

}
