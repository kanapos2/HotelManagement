package Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
    static protected ArrayList<String> userName;

    public Database() {
        this.userName = new ArrayList<>();
    }

    public void addDataRegister(String user,String passwd){
        String userCombinepasswd = user+passwd;
        userName.add(userCombinepasswd);
        System.out.println (getUserName());
    }

    public static ArrayList<String> getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Database{" + "userName=" + userName + '}';
    }

}
