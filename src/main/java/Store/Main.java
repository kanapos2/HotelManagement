package Store;

import Model.User;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        User newUser;
        SimpleIntegerProperty id = new SimpleIntegerProperty(105);
        SimpleStringProperty userName = new SimpleStringProperty("Karn");
        SimpleStringProperty first = new SimpleStringProperty("Siri");
        SimpleStringProperty last = new SimpleStringProperty("Krai");
        SimpleStringProperty email = new SimpleStringProperty("karn@gmail.com");
        SimpleStringProperty pwd = new SimpleStringProperty("oopiou");
        newUser = new User(id,userName,first,last,email,pwd);
        db.openDatabase();
        db.addUser(newUser);
        db.closeDatabase();
    }
}
